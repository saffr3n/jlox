GENERATOR := tool/GenerateAst
GENERATED := Expr.java Stmt.java
SOURCES   := $(wildcard *.java)

Lox.class: $(GENERATED) $(SOURCES)
	javac Lox.java

$(GENERATED): $(GENERATOR).class
	java $(GENERATOR) .

$(GENERATOR).class: $(GENERATOR).java
	javac $<

.PHONY: clean
clean:
	find . -name '*.class' -delete
	rm -f $(GENERATED)
