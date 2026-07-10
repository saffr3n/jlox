SOURCES := $(wildcard *.java)

Lox.class: $(SOURCES)
	javac Lox.java
