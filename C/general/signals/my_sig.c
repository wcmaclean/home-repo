/*
	Will MacLean
	CSPP 51081
	my_sig.c
	
	Based on an example in Chpt 10 of 
	Beginning Linux Programming.
*/

#include <signal.h>
#include <stdio.h>
#include <unistd.h>

int MAXSTOPS = 5;
int COUNT = 0;

void ouch(int sig)
{
	COUNT++;
	printf("Got signal - we\'ve now handled %d CTRL-Cs \n", COUNT);
	if (COUNT == MAXSTOPS)
	{
		printf("We\'ve reached the MAXSTOPS of %d \n", MAXSTOPS);
		exit(0);
	}
}

void sig1(int sig)
{
	printf("handled sigusr1 \n");
}

int main(int argc, char * argv[])
{
	/* these are the sigactions we'll use */
	struct sigaction act;
	struct sigaction act2;
	
	/* testing the command-line input, and using it if it's int */
	MAXSTOPS = atoi(argv[1]);
	
	/* setting up ctr-c sig handler */
	act.sa_handler = ouch;
	sigemptyset(&act.sa_mask);
	act.sa_flags = 0;
	
	sigaction(SIGINT, &act, 0);
	
	/* settign up other sig handler */
	act2.sa_handler = sig1;
	sigemptyset(&act2.sa_mask);
	act2.sa_flags = 0;
	
	sigaction(SIGUSR1, &act2, 0);	
	
	
	while(1)
	{
		printf("Hullo \n");
		sleep(2);
		
		/* killing SIGUSR to make it do something */
		kill(getpid(),SIGUSR1);	
	}
}	
