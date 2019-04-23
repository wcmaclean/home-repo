/*
	Will MacLean
	CSPP 51081
	Lab 3.3
	filecopy.c
*/

#include <unistd.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdlib.h>

void main(int argc, char * argv[])
{
	char c;
	char* sourcefile = argv[1];
	char* targetfile = argv[2];

/*
	printf ("Source: %s \n", argv[1]);
	printf ("Destination: %s \n", argv[2]);
*/

	/* if(argv[1] == argv[2]) */
	if(*sourcefile == *targetfile)
	{
		printf("Filenames must be different \n");
	}
	else if(argc!=3)
	{
		printf("Must have two filenames \n");
	}
	else
	{
		int in;
		int out;
		
		printf("Source: %s \n", sourcefile);
		printf("Destination: %s \n", targetfile);

		in = open(argv[1], O_RDONLY);
		out = open(argv[2], O_WRONLY|O_CREAT, S_IRUSR|S_IWUSR); 

		while(read(in,&c,1) == 1)
			write(out,&c,1);
	}
}


