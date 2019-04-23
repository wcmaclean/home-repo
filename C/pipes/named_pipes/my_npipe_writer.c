/*
	Will MacLean
	CSPP51081
	Lab 4-3
	my_npipe_writer.c
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
#define TEN_MEG (1024 * 1024 * 10)

int main()
{
	static char message[BUFSIZ];
	char * myfifo = "MYFIFO";
	int fifo;


	/*fprintf(stderr, "USAGE:  %s >/dev/tty/?\n",argv[0]);*/

	/* create the FIFO, if it already exists, ignore the error */
	if( mkfifo(myfifo, 0666) < 0 )
	{
		printf("We already have a %s, but we can borrow it \n",myfifo);
	}

	/* now, let's open the FIFO */
	if( (fifo = open(myfifo, O_WRONLY)) < 0)
	{
		perror("Something is amiss, awry, and askew...");
		exit(-1);
	}
	else
		printf("Enter stuff: ");
		
	while ( fgets(message,BUFSIZ,stdin) != NULL 
					&& (strcmp(message, "exit\n")) )
	{
		/* printing */
		printf("Writing buffer to pipe...");
		write(fifo, message, strlen(message));
		memset(message, '\0', BUFSIZ);
		printf("done \n");
		printf("Enter more stuff: ");
			

	}
	printf ("done - and closing down now. \n");
	write(fifo, "exit", strlen("exit"));
	memset(message, '\0', BUFSIZ);
	putchar('\n');
	close(fifo);
	exit(0);
}
