BIN = bin
CLASS = class
JFLAGS = -d $(BIN) -cp class
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) src/*.java
	cp $(CLASS)/* $(BIN)

CLASSES = src/TestTerrain src/TestSimulation

MAIN = TestTerrain

default: classes 

classes: $(CLASSES:.java=.class)

clean:
	rm -f $(BIN)/*

run: $(BIN)/$(MAIN).class 
	java -cp $(BIN) TestTerrain

start: src/$(MAIN).java
	make
	make run
	make clean