BIN = bin
CLASS = class
JFLAGS = -d $(BIN) -cp $(CLASS)
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) src/*.java
	cp $(CLASS)/* $(BIN)

CLASSES = src/TestTerrain.java

MAIN = TestTerrain

default: classes 

classes: $(CLASSES:.java=.class)

clean:
	rm -f $(BIN)/*.class

run: $(BIN)/$(MAIN).class 
	java -cp $(BIN) TestTerrain