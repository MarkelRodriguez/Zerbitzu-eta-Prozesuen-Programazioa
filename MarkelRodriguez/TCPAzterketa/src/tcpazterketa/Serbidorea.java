/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcpazterketa;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author rodriguez.markel
 */
public class Serbidorea {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String args[]) throws IOException  {
        ServerSocket servidor;
        servidor = new ServerSocket(6000);
        
System.out.println("Servidor iniciado...");
        while (true) {
            Socket cliente = new Socket();
            cliente = servidor.accept();//esperando cliente
            SerbidoreaHaria haria = new SerbidoreaHaria(cliente);
            haria.start(); //se atiende al cliente
        }
    }
}

