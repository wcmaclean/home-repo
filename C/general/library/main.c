/* Will MacLean 
   main.c
*/

#include <stdio.h>
#include <stdlib.h>
#include "hello_here_bye.h"

extern void hello();
extern void here();
extern void bye();

int main(){ 
	hello();
	here();
	bye();
	return(1); 
}
