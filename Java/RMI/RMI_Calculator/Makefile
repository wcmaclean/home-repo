SRC =  edu/cspp51024/wmaclean/ParserUtils.java edu/cspp51024/wmaclean/CalcServer.java edu/cspp51024/wmaclean/CalcServerImpl.java edu/cspp51024/wmaclean/CalcClient.java

all: $(SRC)

	javac $(SRC)

	rmic edu.cspp51024.wmaclean.CalcServerImpl

clean:
	/bin/rm *.class *~


