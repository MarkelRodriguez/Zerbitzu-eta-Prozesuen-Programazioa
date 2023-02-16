/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcpazterketa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodriguez.markel
 */
public class SerbidoreaHaria extends Thread  {

    BufferedReader fsarrera;
    PrintWriter firteera;
    Socket socket = null;
    Random zenbakiaAsmatzeko;
    int aukerak ;
    public SerbidoreaHaria(Socket s) throws IOException {//CONSTRUCTOR
        socket = s;
//se crean flujos de entrada y salida
        firteera = new PrintWriter(socket.getOutputStream(), true);
        fsarrera = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
    }
    public Random zenbakiaSortu(){
        Random zenbakia = new Random();
        zenbakia.nextInt(0, 100);
        return zenbakia;
        
    }
    @Override
    public void run() {//tarea a realizar con el cliente
        
        zenbakiaAsmatzeko = zenbakiaSortu() ;
        int zenbakia;    
        try {
            zenbakia = fsarrera.read();//jaso zenbakia
            System.out.println(zenbakia);
            String mezua="";
        for(aukerak = 6; aukerak>=0;aukerak--){
            if(zenbakiaAsmatzeko.equals(zenbakia)){
                mezua = "zenbakia asmatu duzu!!!";
            }
            else{
                 mezua = "aukera bat galgu duzu";
                    
                }
                firteera.println(mezua);
            }
            mezua = "galdu duzu";
            firteera.println(mezua);
        }     
         catch (IOException ex) {
            Logger.getLogger(SerbidoreaHaria.class.getName()).log(Level.SEVERE, null, ex);
        }
           
            
        
        System.out.println("FIN CON: " + socket.toString());
        firteera.close();
        try {
            fsarrera.close();
        } catch (IOException ex) {
            Logger.getLogger(SerbidoreaHaria.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(SerbidoreaHaria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
