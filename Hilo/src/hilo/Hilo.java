/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hilo;

/**
 *
 * @author rodriguez.markel
 */
public class Hilo extends Thread{
    private int x; 
    Hilo (int x){
        this.x=x;
    }

    public void run() {
        for (int i=0; i<x; i++)
        System.out.println("En el Hilo... ");
    }

    
}
