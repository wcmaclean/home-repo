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
	SQLQueryResultSetImpl.java \
	Server.java \
	AuditAdminServlet.java \
	FilledTradeAdminServlet.java \
	AdminServlet.java

CLASSES = $(SRCS:.java=.class) 

all:	$(MODULES) $(CLASSES)
