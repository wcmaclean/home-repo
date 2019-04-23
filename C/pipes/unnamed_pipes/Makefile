#Will MacLean
#CSPP 51081
#Lab 4-2 Makefile

all: my_upipe 

my_upipe: my_upipe.o
	gcc -o my_upipe my_upipe.o

my_upipe.o: my_upipe.c
	gcc -c my_upipe.c

clean:
	-rm my_upipe.o my_upipe
