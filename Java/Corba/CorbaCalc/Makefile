.SUFFIXES: .java .class .idl .module

.java.class:
	vbjc $<

.idl.module:
	idl2java $<
	touch $@

default: all

clean: 
	rm -rf Bank
	rm -f *.class *.tmp *.module *~

IDLS = \
	CorbaCalc.idl

MODULES = $(IDLS:.idl=.module) 

SRCS = \
	CalculatorImpl.java \
	ParserUtils.java \
	Client.java \
	Server.java 


CLASSES = $(SRCS:.java=.class) 

all:	$(MODULES) $(CLASSES)
