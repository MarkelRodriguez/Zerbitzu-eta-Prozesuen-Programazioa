/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package threadejemplorunnable;

/**
 *
 * @author rodriguez.markel
 */
public class ThreadEjemploRunnable implements Runnable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ThreadEjemploRunnable ter = new ThreadEjemploRunnable();
        Thread t1 = new Thread(ter, "Pepe");
        Thread t2 = new Thread(ter, "Juan");
        Thread t3 = new Thread(ter, "Markel");
        t1.start();
        t2.start();
        t3.start();
        System.out.println("Termina thread main");
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + Thread.currentThread().getName());
            System.out.println("Termina Thread:" + Thread.currentThread().getName());
        }
    }

}
