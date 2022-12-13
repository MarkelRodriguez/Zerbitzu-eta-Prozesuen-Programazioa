/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcpkalkulagailua;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author rodriguez.markel
 */
public class TCPClienteKalkulagailua {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String Host = "localhost";

        int Puerto = 6000;//puerto remoto
        System.out.println("PROGRAMA CLIENTE INICIADO....");
        Socket Cliente = new Socket(Host, Puerto);
// CREO FLUJO DE SALIDA AL SERVIDOR
        PrintWriter fsalida = new PrintWriter(Cliente.getOutputStream(), true);
// ENVIO UN SALUDO AL SERVIDOR
        BufferedReader fentrada = new BufferedReader(new InputStreamReader(Cliente.getInputStream()));
// CREO FLUJO DE ENTRADA AL SERVIDOR
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        // EL SERVIDOR ME ENVIA UN MENSAJE

        String cadena, eco = "";
        System.out.print("Introduce cadena: ");
        cadena = in.readLine();//lectura por teclado 
        while (cadena != null) {
            fsalida.println(cadena); //envió cadena al servidor
            eco = fentrada.readLine(); //recibo cadena del servidor
            System.out.println(" =>ECO: " + eco);
            System.out.print("Introduce cadena: ");
            cadena = in.readLine();//lectura por teclado
        }
// CERRAR STREAMS Y SOCKETS
        fsalida.close();
        fentrada.close();
        Cliente.close();
    }// main 
}
