/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hiloejemplo1;

/**
 *
 * @author rodriguez.markel
 */
public class HiloEjemplo1 extends Thread {

    private int c;
    private int hilo;
     
   

    public HiloEjemplo1(int hilo) {
        this.hilo = hilo;
        System.out.println("CREANDO HILO:" + hilo);
    }
//método run

    @Override
    public void run() {
        c = 0;
        while (c <= 5) {
            System.out.println("Hilo:" + hilo + " C = " + c);
            c++;
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        HiloEjemplo1 h = null;
        for (int i = 0; i < 3; i++){
            h = new HiloEjemplo1(i+1);
            h.start();
        } 
    }

}
