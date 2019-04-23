/*
	Will MacLean
	CSPP 51081
	Lab 3.2
	my_stat.c
*/

#include <stdio.h>
#include <unistd.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <dirent.h>
#include <pwd.h>
#include <grp.h>
#include <time.h>
#include <locale.h>
#include <langinfo.h>
#include <stdint.h>

/*
#include "my_stat.h"
*/

struct stat statStuff;

int main (int argc, char * argv[]) 
{
	int i;
	for (i = 0; i < argc; i++)
	{
		lstat(argv[i], &statStuff);
		printf("\n");
		mode_t mode = statStuff.st_mode;		
		
		/* first line */
		printf("Filename: \"%s\" \n", argv[i]);
		
		/* second line */
		printf("Size: %d   ", statStuff.st_size);
		printf("Blocks: %d   ", statStuff.st_blksize);
		printf("IO Block: %d   ", statStuff.st_blocks);

		/* using mode to get file type */
		printf("Filetype: ");
		if (S_ISREG(mode))
 		{
			printf("regular file");
		}
		else if (S_ISDIR(mode))
		{
			printf("directory");
		}
		else if (S_ISLNK(mode))
		{
			printf("symbolic link");	
		}
		else if (S_ISCHR(mode))
		{
			printf("char special file");
		}		else if (S_ISBLK(mode))
		{
			printf("block special");
		}
		else if (S_ISFIFO(mode))
		{
			printf("fifo");		
		}
		else if (S_ISSOCK(mode))
		{
			printf("socket");
		}
		else
		{
			printf("unknown file type");	
		}
		printf("\n");

		/* third line */
 		printf("Device: %s    ", statStuff.st_rdev);
		printf("Inode: %d   ", statStuff.st_ino);
		printf("Links: %d ", statStuff.st_nlink);
	
		printf("\n");
		
		/* fourth line */
		/* using mode to print permissions */
		printf("Access: [%o/", statStuff.st_mode);

		/* file type, redux */
		if (S_ISDIR(mode))
		{
			printf("d");
		}
		if (S_ISCHR(mode))
		{
			printf("c");
		}
		if (S_ISBLK(mode))
		{
			printf("b");
		}
		if (S_ISFIFO(mode))
		{
			printf("p");
		}
		if (S_ISLNK(mode))
		{
			printf("l");
		}
		if (S_ISSOCK(mode))
		{
			printf("s");
		}
		
		/* user access permissions */
		/* read permissions */
		if (mode & S_IRUSR)
		{
			printf("r");
		}
		else
		{
			printf("-");
		}
		/* write permissions */
		if (mode & S_IWUSR)
		{
			printf("w");
		}
		else
		{
			printf("-");
		}
		/* execute permissions */
		if (mode & S_IXUSR)
		{
			printf("x");
		}
		else
		{
			printf("-");
		}

		/* group access permissions */
		/* read permissions */
		if (mode & S_IRGRP)
		{
			printf("r");
		}
		else
		{
			printf("-");
		}
		/* write permissions */
		if (mode & S_IWGRP)
		{
			printf("w");
		}
		else
		{
			printf("-");
		}

		/* execute permissions */
		if (mode & S_IXGRP)
		{
			printf("x");
		}
		else
		{
			printf("-");
		}
		
		/* other access permissions */
		/* read permissions */
		if (mode & S_IROTH)
		{
			printf("r");
		}
		else
		{
			printf("-");
		}
		/* write permissions */
		if (mode & S_IWOTH)
		{
			printf("w");
		}
		else
		{
			printf("-");
		}
		/* execute permissions */
		if (mode & S_IXOTH)
		{
			printf("x");
		}
		else
		{
			printf("-");
		}
		printf("]   ");

		/* using pwd to get an actual Owner name */
		struct passwd *pPwd;
		printf("Uid: [%d/", statStuff.st_uid);
		if((pPwd = getpwuid(statStuff.st_uid)) != NULL)
			printf("%-8.8s", pPwd->pw_name);
		else
			printf("%-8d", statStuff.st_uid);
		printf("]   ");

		/* using grp to get an actual group name */
		struct group *pGrp;
		printf("Gid: [%d/", statStuff.st_gid);
		if((pGrp = getgrgid(statStuff.st_gid)) != NULL)
			printf("%-8.8s", pGrp->gr_name);
		else
			printf("%-8d", statStuff.st_gid);
		printf("] \n");

		/* use strftime and time to get readable dates */
		struct tm *tm;
		char datestring[256];

		tm = localtime(&statStuff.st_atime);
		strftime(datestring,sizeof(datestring),nl_langinfo(D_T_FMT),tm);
		printf("Access: %s \n", datestring);

		tm = localtime(&statStuff.st_mtime);
		strftime(datestring,sizeof(datestring),nl_langinfo(D_T_FMT),tm);
		printf("Modify: %s \n", datestring);

		tm = localtime(&statStuff.st_ctime);
		strftime(datestring,sizeof(datestring),nl_langinfo(D_T_FMT),tm);
		printf("Change: %s \n", datestring);
		printf("\n");
	}
	return 0;

}

