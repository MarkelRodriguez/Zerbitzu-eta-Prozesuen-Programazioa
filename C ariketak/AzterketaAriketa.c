int main()
{

    int dirua = 10000;
    int sartutakoDirua;
    int ateratakoDirua;
    int diruaAtera;
    int diruaSartu;

    int pidAita, pidSemea1, pidSemea2;
    int fd1[2];
    int fd2[2];
    int fd3[2];
    int fd4[2];

    pipe1(fd1);
    pipe2(fd2);
    pipe3(fd3);
    pipe4(fd4);

    pidSemea1 = fork();

    if (pidSemea1 == -1)
    {
        printf("ez du semerik sortu");
    }
    else if (pidSemea1 == 0)
    {
        close(fd1[1]);
        read(fd1[0], ateratakoDirua); // leo el pipe
        printf("\tateratako dirua: %d\n");
        

        diruaAtera = diruaAtera + ateratakoDirua;
    }
    else
    {
        pidSemea2 = fork();
        switch (pidSemea2)
        {
        case -1:
            printf("ez du semerik sortu");
            break;

        case 0:

        default:

            int aukera;
            printf("1,Dirua atera");
            printf("2.Dirua sartu");
            printf("3.Egungo Egoera");
            scanf("%i", aukera);
            switch (aukera)
            {
            case 1:
                printf("Zenbat diru atera nahi duzu?");
                scanf("%i", ateratakoDirua);
                if (ateratakoDirua <= dirua)
                {
                    close(fd1[0]);
                    write(fd1[1], ateratakoDirua); // escribo en pipe
                    dirua = dirua - ateratakoDirua;
                }
                else
                {
                    printf("Ez daukazu diru nahikorik");
                }
                break;
            case 2:

                printf("Zenbat diru atera nahi duzu?");
                scanf("%i", sartutakoDirua);
                close(fd3[0]);
                write(fd3[1],sartutakoDirua);

            default:
                break;
            }
        }
    }
}
