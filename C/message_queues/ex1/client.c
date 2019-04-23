/*
Will MacLean
CSPP51081
Lab 5-1 - Message Queues
client.c
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
	char some_text[MAX_TEXT];
};

int main()
{
	int running = 1;
	char buffer[BUFSIZ];
	long int msg_to_receive = 0;
	
	/* up queue */
	struct my_msg_st up;
	int up_int;
	
	/* down queue */
	struct my_msg_st down;
	int down_int;

	/* using pid as message type */
	up.my_msg_type = (long int)getpid();
	down.my_msg_type = (long int)getpid();
	
	/* creating queues */
	up_int = msgget((key_t)2112, 0666 | IPC_CREAT);
	down_int = msgget((key_t)3113, 0666 | IPC_CREAT);

	/* checking to see if the queues are created */
	if(up_int == -1 || down_int == -1)
	{
		fprintf(stderr, "msgget cheezed: %d \n", errno);
		exit(EXIT_FAILURE);	
	}
	
	/* loop and do stuff */
	while(running)
	{
		/* prompt user and get input */
		printf("Insert message to send to server: ");
		fgets(buffer, BUFSIZ, stdin);
		/* up.my_msg_type = 1; */
		strcpy(up.some_text, buffer);
		
		/* write to up */
		if(msgsnd(up_int, (void *)&up, MAX_TEXT, 0) == -1)
		{
			fprintf(stderr, "client msgsend cheezed \n");
			exit(EXIT_FAILURE);		
		}
		/* wait and read from down */
		if(msgrcv(down_int, 
			(void *)&down, BUFSIZ, msg_to_receive, 0) == -1)
		{
			fprintf(stderr, "client msgrcv failed to get anything: %d \n", errno);
			exit(EXIT_FAILURE);		
		}
		printf("Msg processed: %s \n", down.some_text);
		
		/* check for end */
		if(strncmp(buffer, "end", 3) == 0)
		{
			running =0;		
		}
			
	}
		
	exit(EXIT_SUCCESS);
}
