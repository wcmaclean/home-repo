/*
	Will MacLean
	CSPP51081
	Lab 4-1
	The Shell
*/

#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <sys/types.h>
#include <sys/time.h>
#include <sys/stat.h>
#include <unistd.h>
#include <dirent.h>
#include <errno.h>
#include <sys/wait.h>
#include <fcntl.h>
#include "gosh.h"
#include <string.h>

#define TMP_STRING_LEN 255

char * cmd2[] = { "ls", "-l" };

int n_line()
{
	return(2);
}

int main() {

  	while(1) {
  		/* variables for storing and checking input */
  		char * commandParams[256];
		char * command;
		char exit_str[] = "exit\n";
		char n_str[] = "\n"; 
		
		/* print a prompt */
		printf("\nYer wish is my command... > ");
		
		/* getting some input */
		char tmp_str[TMP_STRING_LEN + 1];
		fgets(tmp_str, TMP_STRING_LEN, stdin);
		
		/* print a line to separate */
		printf("\n");
		
		/* check for \n now, cuz we strip it off next */
		if(!strcmp(tmp_str, n_str))
		{
			printf("Ignoring and returning %d \n", n_line());
		}
		else if(!strcmp(tmp_str, exit_str))
		{
			printf("Exiting... \n");
			exit(1); 
		}
		else
		{		
			/* strip the endline */
			int len;
			len = strlen(tmp_str);
			if (tmp_str[len-1] == '\n')
			{
				tmp_str[len-1] = '\0';
			}
		
			/* tokenizing out the command */
			command = strtok(tmp_str, " ");
			
			/* building the argument array  */
			int counter = 0;
			commandParams[0] = command;
			while(commandParams[counter] != NULL)
			{
				counter++;
				commandParams[counter] = strtok(NULL, " ");
			}
			
			/* print command array */
			counter=0;
			while(commandParams[counter] != NULL)
			{
				printf("Cl %d: %s \n", counter, commandParams[counter]);
				counter++;
			}
			
			/* print a line to separate */
			printf("\n");
		
			/* forking and execing */
			pid_t a_pid;
		
			if((a_pid = fork()) < 0)
			{
				printf("Error: no fork \n");		
			}
			/* child and parent */
			if(a_pid == 0)
			{ /* this is the child */
				printf("Running command \n\n");
				execvp(command, commandParams);
				perror("execvp");	
			}
  			else
  			{ /* this is the parent */
  				waitpid(a_pid, NULL, 0);
  			}
		}	
	}  
	return(0);
}
