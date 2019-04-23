/* 
Will MacLean
CSPP51081 
Lab 6

I used a template echo server for starters
*/

#include <stdio.h>
#include <sys/types.h> 
#include <sys/socket.h>
#include <netinet/in.h>

/* nabbed from hangman server example */
char * word[] = {
  #include "words"
};
/* access it later like this: word[x]; */

/* for troubleshooting and error reporting */
void error(char *msg)
{
    perror(msg);
    exit(1);
}

/* Loop through word[] and check testWord for spelling */
int CheckWord(char * testWord)
{
	int x = 0;
	
	/* walk through the word array */
	while(word[x]!=NULL)
	{
	
		/* comparing word against the word in word[] */
		printf("Checking %s against %s \n", word[x], testWord);
		if(strcmp(testWord, word[x])==0)
		{
			/* if true, return 1 */
			printf("checked - true");
			return 1;
		}
		printf("nope \n");
		x = x + 1;
	}
	/* if false, return 0 */
	return 0;
}

int main(int argc, char *argv[])
{

	/* setting up variables */
	int sockfd, newsockfd, portno, clilen;
	char buffer[256];
	struct sockaddr_in serv_addr, cli_addr;
	int n;
	
	/* checking argv for command-line arguments */
	if (argc < 2) {
		fprintf(stderr,"ERROR, no port provided\n");
		printf("try: server 5060 \n");
		exit(1);
	}
	
	/* creating socket */
	sockfd = socket(AF_INET, SOCK_STREAM, 0);
	if (sockfd < 0) 
		error("ERROR opening socket");
		
	/* bzero should be memset in our environment */
	/* but this works, so I won't change it */
	/* because I don't want to break it */
	bzero((char *) &serv_addr, sizeof(serv_addr));
	
	/* assigning argv input to variable */
	portno = atoi(argv[1]);
	
	/* setting up socket info */
	serv_addr.sin_family = AF_INET;
	serv_addr.sin_addr.s_addr = INADDR_ANY;
	serv_addr.sin_port = htons(portno);
	
	/* binding socket */
	if (bind(sockfd, (struct sockaddr *) &serv_addr,sizeof(serv_addr)) < 0) 
		error("ERROR on binding");
		
	/* listening for client connection */
	listen(sockfd,5);
	
	/* when a client calls, connect */
	clilen = sizeof(cli_addr);
	newsockfd = accept(sockfd, (struct sockaddr *) &cli_addr, &clilen);
	if (newsockfd < 0) 
		error("ERROR on accept");
	bzero(buffer,256);
     
   /* loop */
	while(1)
	{
		/* zeroing out the buffer */
		memset(buffer,'\0',256);
		
		/* waiting for stuff from client */ 
		printf("Waiting for word");
		
		/* read from socket */
		n = read(newsockfd,buffer,255);
		if (n < 0) error("ERROR reading from socket");
		printf("Test this word: %s\n",buffer);
		
		/* checking if word is spelled correctly */
		/* reporting result to client */
		int test = CheckWord(buffer);
		if(test==1)
		{
			char msg[] = "correctly";
			write(newsockfd, msg, 255);  
		}
		else
		{
			char msg[] = "incorrectly";
			write(newsockfd, msg, 255);  
		}
	}
	return 0; 
}
