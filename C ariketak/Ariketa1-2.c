#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

int main(void)
{

    int fd[2];
    pid_t pid;
    char saludoPadre[] = "Buenos dias padre\0";
    char buffer[80];
    pipe(fd);     // creo pipe
    pid = fork(); // creo proceso
    switch (pid)
    {
    case -1: // ERROR
        printf("NO SE HA PODIDO CREAR HIJO...");
        exit(-1);
    case 0:                                  // Hijo envia
        close(fd[0]);                        // cierra el descriptor de entrada
        write(fd[1], saludoPadre, strlen(saludoPadre));// escribo en pipe
        printf("El hijo envia algo al pipe\n");
        break;
    default: // Padre recive
        close(fd[1]);
        read(fd[0], buffer, sizeof(buffer));// leo el pipe
        printf("\tEl padre recibe algo del pipe: %s\n", buffer);
        
        
        wait(NULL); // espero al proceso hijo
        break;
    }
    return 0;
}