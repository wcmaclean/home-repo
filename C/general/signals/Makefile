#Will MacLean
#CSPP 51081
#Lab 3.4 Makefile

all: my_sig

my_sig: my_sig.o
	gcc -o my_sig my_sig.o

my_sig.o: my_sig.c
	gcc -c my_sig.c

clean:
	-rm my_sig.o my_sig
