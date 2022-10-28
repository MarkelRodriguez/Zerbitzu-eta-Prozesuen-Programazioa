/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package faktorialahariekin;

import java.util.Scanner;

/**
 *
 * @author rodriguez.markel
 */
public class FaktorialaHariekin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int z1, z2, z3, z4, z5, z6;
        Scanner sc = new Scanner(System.in);
        System.out.println("Sartu 6 zenbaki");
        z1 = sc.nextInt();
        z2 = sc.nextInt();
        z3 = sc.nextInt();
        z4 = sc.nextInt();
        z5 = sc.nextInt();
        z6 = sc.nextInt();

        Faktorial h1 = new Faktorial(z1);
        Faktorial h2 = new Faktorial(z2);
        Faktorial h3 = new Faktorial(z3);
        Faktorial h4 = new Faktorial(z4);
        Faktorial h5 = new Faktorial(z5);
        Faktorial h6 = new Faktorial(z6);

        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
        h6.start();

        try {
            h1.join();
            h2.join();
            h3.join();
            h4.join();
            h5.join();
            h6.join();
        }catch (InterruptedException ex) {
                System.out.println(ex);
            }

    }

}
