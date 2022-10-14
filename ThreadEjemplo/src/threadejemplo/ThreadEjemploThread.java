/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package threadejemplo;

/**
 *
 * @author rodriguez.markel
 */
public class ThreadEjemploThread extends Thread {

    public ThreadEjemploThread(String str){
        super(str);
    }
    public void run(){
        for (int i = 0; i < 10;i++){
            System.out.println(i+ " "+ getName() );
            System.out.println("Termina Thread:" + getName());
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        ThreadEjemploThread pepe = new ThreadEjemploThread("Pepe");
        pepe.start();
        new ThreadEjemploThread("juan").start();
        System.out.println("Termina thread main");
    }
    
}
