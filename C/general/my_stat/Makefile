#Will MacLean
#CSPP 51081
#Lab 3.2 Makefile

all: mystat

mystat: my_stat.o
	gcc -o mystat my_stat.o

my_stat.o: my_stat.c
	gcc -c my_stat.c

clean:
	-rm my_stat.o mystat
