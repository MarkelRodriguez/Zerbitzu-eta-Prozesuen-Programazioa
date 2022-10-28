/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package faktorialahariekin;

/**
 *
 * @author rodriguez.markel
 */
public class Faktorial extends Thread {
    int zenbakia;
    
    public Faktorial(int zenbakia){
        this.zenbakia = zenbakia;
    }
    private double fakt(int zenb){
        int faktorial = 1;
        for (int x=2;x<=zenbakia;x++){
            faktorial = faktorial * x;
        }
        return faktorial;
    }
    
    public void run(){
        
        System.out.println(zenbakia + ":" + fakt(zenbakia));
    }
}
