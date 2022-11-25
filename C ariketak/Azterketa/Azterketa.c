#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>


int main()
{
    
    
    char buffer[80];
    int dirua;
    int ateratako_dirua;
    int sartutako_dirua;


    printf("Zenbat diru daukazu?");
    scanf("%i", dirua);
    int aukera;
    int pid_padre, pid_hijo1, pid_hijo2;
    pid_padre = getpid();
    pid_hijo1 = fork();
    pid_hijo2 = fork();
    int fd[2];
    
    pipe(fd);
    while (aukera != 0)
    {
        printf("1,Dirua atera");
        printf("2.Dirua sartu");
        printf("3.Egungo Egoera");
        scanf("%i", aukera);
        switch (aukera)
        {
        case 1:
            int dirua_atera;
            printf("Zenbat diru atera nahi duzu?");
            scanf("%i", dirua_atera);
            if (dirua_atera <= dirua)
            {
                switch (pid_hijo1)
                {
                case -1: // ERROR
                    printf("NO SE HA PODIDO CREAR HIJO...");
                    exit(-1);
                case 0:                                  // HIJO RECIBE
                    close(fd[1]);                        // cierra el descriptor de entrada
                    read(fd[0], buffer, sizeof(buffer)); // leo el pipe
                    printf("\t ateratako dirua: %i\n", buffer);
                    break;
                default: // PADRE ENVIA
                    close(fd[0]);

                    write(fd[1], dirua_atera, strlen(80)); // escribo en pipe
                    dirua = dirua - dirua_atera;

                    ateratako_dirua = ateratako_dirua + dirua_atera;
                    wait(NULL); // espero al proceso hijo
                    break;
                }
            }
            else
            {
                printf("ez daukazu diru nahikorik");
            }

            break;

        case 2:

            switch (pid_hijo2)
            {
            case -1: // ERROR
                printf("NO SE HA PODIDO CREAR HIJO...");
                exit(-1);
            case 0:                                  // HIJO RECIBE
                close(fd[1]);                        // cierra el descriptor de entrada
                read(fd[0], buffer, sizeof(buffer)); // leo el pipe
                printf("\tsartutako dirua: %i\n", buffer);
                break;
            default: // PADRE ENVIA
                close(fd[0]);
                int dirua_sartu;
                
                printf("Zenbat diru atera nahi duzu?");
                scanf("%i", dirua_sartu);

                dirua = dirua + dirua_sartu;
                sartutako_dirua = sartutako_dirua + dirua_sartu;
                write(fd[1], dirua_sartu, strlen(80)); // escribo en pipe
                printf("El PADRE ENVIA MENSAJE AL HIJO...\n");
                wait(NULL); // espero al proceso hijo
                break;
            }

            break;

        case 3:

            printf("kontuaren balioa: %i\n", dirua);

            switch (pid_hijo1)
            {
            case -1: // ERROR
                printf("NO SE HA PODIDO CREAR HIJO...");
                exit(-1);
            case 0:                                             // Hijo envia
                close(fd[0]);                                   // cierra el descriptor de entrada
                write(fd[1], ateratako_dirua, strlen(80)); // escribo en pipe
                
                break;
            default: // Padre recive
                close(fd[1]);
                read(fd[0], buffer, sizeof(buffer)); // leo el pipe
                printf("\tatera duzun diru kopuru totala: %s\n", buffer);

                wait(NULL); // espero al proceso hijo
                break;
            }

            switch (pid_hijo2)
            {
            case -1: // ERROR
                printf("NO SE HA PODIDO CREAR HIJO...");
                exit(-1);
            case 0:                                             // Hijo envia
                close(fd[0]);                                   // cierra el descriptor de entrada
                write(fd[1], sartutako_dirua, strlen(80)); // escribo en pipe
                printf("El hijo envia algo al pipe\n");
                break;
            default: // Padre recive
                close(fd[1]);
                read(fd[0], buffer, sizeof(buffer)); // leo el pipe
                printf("\tsartu duzun diru kopuru totala: %s\n", buffer);

                wait(NULL); // espero al proceso hijo
                break;
            }

            break;

            case 0:

            break;

        default:
            break;
        }
    }
    return 0;
}
