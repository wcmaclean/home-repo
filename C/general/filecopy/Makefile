#Will MacLean
#CSPP 51081
#Lab 3.3 Makefile

all: filecopy

filecopy: filecopy.o
	gcc -o filecopy filecopy.o

filecopy.o: filecopy.c
	gcc -c filecopy.c

clean:
	-rm filecopy.o filecopy
