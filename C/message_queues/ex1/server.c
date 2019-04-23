/*
Will MacLean
CSPP51081
Lab 5-1 - Message Queues
server.c
*/

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <errno.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/msg.h>

#define MAX_TEXT 256

/* based on sample from BLP */

struct my_msg_st
{
	long int my_msg_type;
	char some_text[BUFSIZ];
};

/* borrowing the conv() function from the lab 5 notes online */
void conv(char *msg, int size)
{
	int i;
	for(i=0;i<size;++i)
		if(islower(msg[i]))
			msg[i] = toupper(msg[i]);
		else if (isupper(msg[i]))
			msg[i] = tolower(msg[i]);
}

int main()
{
	int running = 1;
	long int msg_to_receive = 0;
	
	/* creating up queue */
	int up_int;
	struct my_msg_st up;
	up_int = msgget((key_t)2112, 0666 | IPC_CREAT);
	
	/* creating down queue */
	int down_int;
	struct my_msg_st down;
	down_int = msgget((key_t)3113, 0666 | IPC_CREAT);
	
	/* checking to see if queues are created */
	if (up_int == -1 || down_int == -1)
	{
		fprintf(stderr, "msgget cheezed - failed to create queues: %d \n", errno);
		exit(EXIT_FAILURE);	
	}
	
	/* indicate that something is happening */
	printf("Listening on message queue... \n");	
	
	while(running)
	{
		/* wait and read from up */
		if(msgrcv(up_int, 
			(void *)&up, BUFSIZ, msg_to_receive, 0) == -1)
		{
			fprintf(stderr, "msgrcv failed to get anything: %d \n", errno);
			exit(EXIT_FAILURE);		
		}
		printf("Received message from client: %s", up.some_text);
		if(strncmp(up.some_text, "end", 3) == 0)
		{
			running = 0;		
		}

		/* convert to upper */
		strcpy(down.some_text, up.some_text);
		conv(down.some_text, MAX_TEXT);
		printf("Processed msg: %s", down.some_text);
		
		/* using pids from message type to */
		/* coordinate messages to specific clients */
		down.my_msg_type = up.my_msg_type;
		
		/* send msg to down */
		if(msgsnd(down_int, (void *)&down, MAX_TEXT, 0) == -1)
		{
			fprintf(stderr, "server msgsend cheezed \n");
			exit(EXIT_FAILURE);		
		}
	}	
	if((msgctl(up_int, IPC_RMID, 0) == -1) || (msgctl(down_int, IPC_RMID, 0) == -1))
	{
		fprintf(stderr, "msgctl(IPC_RMID) cheezed \n");
		exit(EXIT_FAILURE);	
	}	
	
	exit(EXIT_SUCCESS);	
}
