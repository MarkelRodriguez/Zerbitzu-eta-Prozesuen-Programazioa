/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcpkalkulagailua;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author rodriguez.markel
 */
public class TCPServidoreaKalkulagailua {

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
           String[] eragiketa = cad.split(" ");
           double emaitza;
           if("+".equals(eragiketa[1])){
               emaitza = Double.parseDouble(eragiketa[0]) + Double.parseDouble(eragiketa[2]);
               fsalida.println(emaitza);
               
           }
           else if("-".equals(eragiketa[1])){
               emaitza = Double.parseDouble(eragiketa[0]) - Double.parseDouble(eragiketa[2]);
               fsalida.println(emaitza);
               
           }
           else if("X".equals(eragiketa[1])){
               emaitza = Double.parseDouble(eragiketa[0]) * Double.parseDouble(eragiketa[2]);
               fsalida.println(emaitza);
               
           }
           else if("/".equals(eragiketa[1])){
               emaitza = Double.parseDouble(eragiketa[0]) / Double.parseDouble(eragiketa[2]);
               fsalida.println(emaitza);
               
           }
        }
       
// CERRAR STREAMS Y SOCKETS
        fentrada.close();
        fsalida.close();
        
        clienteConectado.close();
        servidor.close();
    }// main 
    
    
}
