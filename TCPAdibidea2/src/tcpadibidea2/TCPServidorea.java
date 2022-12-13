/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcpadibidea2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author rodriguez.markel
 */
public class TCPServidorea {

    /**
     * @param args the command line arguments
     */
      public static void main(String[] args) throws IOException {
        int numeroPuerto = 6000;// Puerto
        ServerSocket servidor = new ServerSocket(numeroPuerto);
        String cad = "";
        Socket clienteConectado = null;
        System.out.println("Esperando al cliente ");
        clienteConectado = servidor.accept();
// CREO FLUJO DE ENTRADA DEL CLIENTE
        PrintWriter fsalida =new PrintWriter(clienteConectado.getOutputStream(),true);
        

        
// CREO FLUJO DE SALIDA AL CLIENTE
        BufferedReader fentrada = new BufferedReader(new InputStreamReader(clienteConectado.getInputStream()));
// ENVIO UN SALUDO AL CLIENTE
       while ((cad=fentrada.readLine()) != null){
           System.out.println("Recibiendo: " + cad);//recibo cad del clrente 
           if(cad.equals("kaixo")){
               fsalida.println ("Kaixo bezero");
           }
           
           else if(cad.equals("agur")){
                fsalida.println ("Agur bezero");
                break;
           }//envio cadena al cliente
           else{
               fsalida.println("ez dago mezurik horrentzako");
           }
            
            
             }
       
// CERRAR STREAMS Y SOCKETS
        fentrada.close();
        fsalida.close();
        
        clienteConectado.close();
        servidor.close();
    }// main 
    
}
