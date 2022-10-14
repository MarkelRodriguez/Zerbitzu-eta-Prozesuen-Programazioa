/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ariketa2_1;

/**
 *
 * @author rodriguez.markel
 */
public class Hilo1 extends Thread {

    private int c;

    public void run() {

        for (c = 0; c < 5; c++) {

            try {
                System.out.println("TIC");
                sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }

    }
}
