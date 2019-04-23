/*
	Will MacLean
	CSPP51081
	Lab 4-3
	my_npipe_reader.c
*/

/*
I tried using a model from the Beginning Linux Progamming
book for this, but found Prof Shacklette's examples easier to understand,
so I used those as a starting point.
*/


#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <fcntl.h>
#include <limits.h>
#include <sys/types.h>
#include <sys/stat.h>

#define FIFO_NAME "/tmp/my_fifo"
#define BUFFER_SIZE PIPE_BUF

int main(int argc, char * argv[] )
{
	static char message[BUFSIZ];
	char * myfifo = "MYFIFO";
	int fifo;
	int n;
	
	

	/* create the FIFO, if it already exists, ignore the error */
	if( mkfifo(myfifo, 0666) < 0 )
	{
		printf("We already have a %s, but we can borrow it \n",myfifo);
	}

	/* now, let's open the FIFO */
	if( (fifo = open(myfifo, O_RDONLY)) < 0)
	{
		perror("Something is amiss, awry, and askew...");
		exit(-1);
	}

	fprintf(stderr, "Waiting for input...");

	while( (n = read(fifo, message, sizeof(message))) > 0 
			&& (strcmp(message, "exit")) )
	{				
		fprintf( stderr, "Got it: %s \nWaiting for input...", message);
		/* read(fifo, message, strlen(message)); */
		memset(message, '\0', BUFSIZ);
	}
	printf("\n");
	printf("Received exit - and closing down now. ");
	putchar('\n');
	close(fifo);
	exit(0);
}
