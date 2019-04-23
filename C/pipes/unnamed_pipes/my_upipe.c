/*
	Will MacLean
	CSPP51081
	Lab 4-2
	my_upipe
*/

/* 
As with lab 4-3 (I did these backwards), I tried to start with
some sample code from the BLP book, but found Prof. Shacklette's
online sample easier to understand.
*/

#include <sys/types.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <signal.h>

#define CHILD (pid_t) 0

int main(int argc, char * argv[] )
{
	pid_t child;
	int fdes[2];
	static char message[BUFSIZ];
	
	/* checking argv */
	/*	
	int i;
	for (i=0;i<argc;i++)
	{
		printf("argv[%d]: %s \n", i, argv[i]);	
	} 
	*/ 
	
	/* variables for the commands */
	char * command;
	char * commandParams[256];
	char * command2;
	char * command2Params[256];
	
	/* tokenizing out the first command */
	command = strtok(argv[1], " ");
	/* building the first argument array  */
	int counter = 0;
	commandParams[0] = command;
	while(commandParams[counter] != NULL)
	{
		counter++;
		commandParams[counter] = strtok(NULL, " ");
	}
	
	/* tokenizing out the second command */
	command2 = strtok(argv[2], " ");
	/* building the second argument array  */
	counter = 0;
	command2Params[0] = command2;
	while(command2Params[counter] != NULL)
	{
		counter++;
		command2Params[counter] = strtok(NULL, " ");
	}

	/* print first command array */
	/* 	
	counter=0;
	while(commandParams[counter] != NULL)
	{
		printf("Cl %d: %s \n", counter, commandParams[counter]);
		counter++;
	}	
	*/ 
	
	/* print second command array */
	/* 	
	counter=0;
	while(commandParams[counter] != NULL)
	{
		printf("C2 %d: %s \n", counter, command2Params[counter]);
		counter++;
	} 
	*/ 

	if( pipe(fdes) == -1 )
	{
		perror("Pipe");
		exit(-1);
	}

	printf("parent process id is: %d\n",getpid());

	if( (child = fork()) == CHILD )
	{
		/* close stdout, and send it to fdes[1] (our "write" pipe) */
		dup2(fdes[1], fileno(stdout));
		/* now we can close the child's descriptors, as we don't need them */
		/* exec will inherit the dup'd stdout */
		close(fdes[0]);
		close(fdes[1]);
		/* execlp("ls","ls", "/usr/bin", NULL); */
		execvp(command, commandParams); 
		/* execlp(command, NULL); */
		exit(5);
	}
	else
	{
		/* close stdin, and send it to fdes[0] (our "read" pipe) */
		dup2(fdes[0], fileno(stdin));
		/* now we can close the parent's descriptors, as we don't need them */
		/* exec will inherit the dup'd stdin */
		close(fdes[0]);
		close(fdes[1]);
		/* execlp("sort","sort",NULL); */
		execvp(command2, command2Params);
		/* execlp(command2, NULL); */
		exit(6);
	}
}

