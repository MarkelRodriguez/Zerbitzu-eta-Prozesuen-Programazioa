/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package threadejemplomuertesegura;

/**
 *
 * @author rodriguez.markel
 */
public class ThreadEjemploMuerteSegura extends Thread {
    private boolean stopHilo = false;
    
    public void pararHilo(){
        stopHilo = true;
    }
    public void run(){
        while(stopHilo){
            System.out.println("En el hilo");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ThreadEjemploMuerteSegura h = new ThreadEjemploMuerteSegura();
        h.start();
        for(int i = 0; i< 100000000; i++){
            h.pararHilo();
        }
    }
    
}
