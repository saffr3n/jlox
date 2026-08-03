import java.util.ArrayList;
import java.util.List;

public class Environment {
  public final Environment enclosing;
  private final List<Object> values = new ArrayList<>();

  public Environment() {
    enclosing = null;
  }

  public Environment(Environment enclosing) {
    this.enclosing = enclosing;
  }

  public void define(String name, Object value) {
    values.add(value);
  }

  public void assignAt(Interpreter.VarLocation location, Object value) {
    ancestor(location).values.set(location.index, value);
  }

  public Object getAt(Interpreter.VarLocation location) {
    return ancestor(location).values.get(location.index);
  }

  private Environment ancestor(Interpreter.VarLocation location) {
    Environment environment = this;
    for (int i = 0; i < location.distance; i++) {
      environment = environment.enclosing;
    }
    return environment;
  }
}
