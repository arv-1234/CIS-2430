JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java
CLASSES = \
        Stock.java \
        Investment.java \
        MutualFund.java \
        Menu.java\
        ePortfolio.java 
default: classes
classes: $(CLASSES:.java=.class)
clean:
	$(RM) *.class