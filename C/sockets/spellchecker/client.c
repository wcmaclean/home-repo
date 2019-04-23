/* 
Will MacLean
CSPP51081 
Lab 6

I used a template echo client for starters
*/

#include <stdio.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h> 

void error(char *msg)
{
    perror(msg);
    exit(0);
}

int main(int argc, char *argv[])
{
	/* set up variables for socket */
	int sockfd, portno, n;
	struct sockaddr_in serv_addr;
	struct hostent *server;

	/* check for command-line arguments */
	if (argc < 3) 
	{
		fprintf(stderr,"usage %s hostname port\n", argv[0]);
		printf("try: client 127.0.0.1 5060\n");
		exit(0);
	}
	
	/* convert argv input into variable data types */
	portno = atoi(argv[2]);
	sockfd = socket(AF_INET, SOCK_STREAM, 0);
	
	/* attempt opening socket */
	if (sockfd < 0) 
		error("ERROR opening socket");
	server = gethostbyname(argv[1]);
	if (server == NULL) {
		fprintf(stderr,"ERROR, no such host\n");
		exit(0);
	}
	
	/* this is supposed to zero out something */
	/* but I've found by trial-and-error that */
	/* bzero doesn't work in our environment */
	/* I should change to memset, but this works */
	/* and I don't want to break anything */
	bzero((char *) &serv_addr, sizeof(serv_addr));
	
	/* setting socket info */
	serv_addr.sin_family = AF_INET;
	bcopy((char *)server->h_addr, (char *)&serv_addr.sin_addr.s_addr, server->h_length);
	serv_addr.sin_port = htons(portno);

	/* attempt to connect to socket */
	if (connect(sockfd,&serv_addr,sizeof(serv_addr)) < 0) 
		error("ERROR connecting");
		
	/* loop */
	while(1)
	{
		/* set up buffers */
		char buffer[256];
		char word[256];
		
		/* prompt for input */
		printf("Please enter a word to spellcheck: ");
		fgets(buffer,255,stdin);

		/* strip the endline */
		int len;
		len = strlen(buffer);
		if (buffer[len-1] == '\n')
		{
			buffer[len-1] = '\0';
		}
		
		/* hold buffer in word, for output */
		strcpy(word, buffer);		
		
		/* write to socket */
		n = write(sockfd,buffer,strlen(buffer));
		if (n < 0) 
			error("ERROR writing to socket");

		/* read from socket */
		n = read(sockfd,buffer,255);
		if (n < 0) 
			error("ERROR reading from socket");
		
		/* report to shell */
		printf("The word %s is spelled %s \n", word, buffer);
		
		/* reset buffers */
		memset(buffer,'\0',256);
		memset(word,'\0',256);
	}
    return 0;
}
