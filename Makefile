SOURCES := $(wildcard *.java)

Lox.class: $(SOURCES)
	javac Lox.java

.PHONY: clean
clean:
	rm -f *.class
