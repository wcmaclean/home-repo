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
	SQLQueryResultSet.idl

MODULES = $(IDLS:.idl=.module) 

SRCS = \
	DBLink.java \
	SQLQueryResultSetImpl.java \
	Client.java \
	Server.java \
	SQLQueryWithCORBAServlet.java \
	


CLASSES = $(SRCS:.java=.class) 

all:	$(MODULES) $(CLASSES)
