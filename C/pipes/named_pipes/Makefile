#Will MacLean
#CSPP 51081
#Lab 4-3 Makefile

all: my_npipe_reader my_npipe_writer

my_npipe_reader: my_npipe_reader.o
	gcc -o my_npipe_reader my_npipe_reader.o

my_npipe_reader.o: my_npipe_reader.c
	gcc -c my_npipe_reader.c

my_npipe_writer: my_npipe_writer.o
	gcc -o my_npipe_writer my_npipe_writer.o

my_npipe_writer.o: my_npipe_writer.c
	gcc -c my_npipe_writer.c

clean:
	-rm my_npipe_writer my_npipe_writer.o my_npipe_reader my_npipe_reader.o
