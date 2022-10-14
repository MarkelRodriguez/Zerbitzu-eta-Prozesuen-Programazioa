/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ariketa2_1;

/**
 *
 * @author rodriguez.markel
 */
public class Ariketa2_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
            Hilo1 h1 = new Hilo1();
            Hilo2 h2 = new Hilo2();
            h1.start();
            h2.start();
            try{
                h1.join();
                h2.join();
            }catch (InterruptedException ex) {
                System.out.println(ex);
            }
    }
    
}
