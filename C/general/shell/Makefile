#Will MacLean
#CSPP 51081
#Lab 3.4 ex1 Makefile - gosh

all: gosh

gosh: gosh_from_scratch.o
	gcc -g -I./ gosh_from_scratch.o -o gosh

gosh_from_scratch.o: gosh_from_scratch.c gosh.h
	gcc -g -c -I./ gosh_from_scratch.c

clean:
	-rm gosh_from_scratch.o gosh
