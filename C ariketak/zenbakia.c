#include <stdio.h>

int main(int argc, char *argv[]) 
{
    int zenb;
    int *punteroa; 

    printf("sartu zenbaki bat: ");
    scanf("%i",&zenb);
    printf("sartu duzun zenbakia da: %i \n",zenb);
    printf("sartu duzun zenbakia hemen dago gordeta: %p \n",&zenb);
    punteroa = &zenb;
    *punteroa = 7;
    printf("sartu duzun zenbakia da: %i \n",zenb);
    return 0;
    
}