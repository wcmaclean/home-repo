/*
	Will MacLean
	CSPP51060
	portfolio.c
*/

#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <string.h>

int main()
{
	char * test = "12.34";
	char * filename = "portfolio.txt";
	FILE * file;
	char string[256];
	char * fields[256];
	char * shareString;
	float total = 0;
	float shares = 0;
	float price = 0;
	
	if((file = fopen(filename, "r")) == NULL)
	{
		printf("file open cheezed\n");
		return 1;
	}

	printf("\nName \tShares \t  Price\n");
	printf("---- \t------ \t  -----\n");

	while(!feof(file))
	{
		if(fgets(string, 126, file))
		{
			// swapping \n with \0
			int length = strlen(string);
			if(string[length-1] == '\n')
				string[length-1] = '\0';
			// printf("%s \n", string);

			// tokening out the fields
			fields[0] = strtok(string, " ");
			fields[1] = strtok(NULL, " ");
			fields[2] = strtok(NULL, " ");
		
			// convert strings to numbers
			shares = atof(fields[1]);
			price = atof(fields[2]);

			// print
			printf("%s \t %5.0f \t %6.2f \n", fields[0], shares, price);
			// math
			total = total + shares * price;
			
		}
	}

	printf("\nTotal Cost: %-.2f\n\n", total);

	fclose(file);	
	return 0;
}
