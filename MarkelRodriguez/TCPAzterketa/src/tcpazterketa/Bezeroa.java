/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcpazterketa;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author rodriguez.markel
 */
public class Bezeroa {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String Host = "localhost";

        int Puerto = 6000;//puerto remoto
        System.out.println("PROGRAMA CLIENTE INICIADO....");
        Socket Bezeroa = new Socket(Host, Puerto);
// CREO FLUJO DE SALIDA AL SERVIDOR
        // CREO FLUJO DE SALIDA AL SERVIDOR
        PrintWriter firteera = new PrintWriter(Bezeroa.getOutputStream(), true);
// ENVIO UN SALUDO AL SERVIDOR
        BufferedReader fsarrera = new BufferedReader(new InputStreamReader(Bezeroa.getInputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        String zenbakia;
        String erantzuna = "";
        System.out.print("Sartu zenbakia: ");
        zenbakia = in.readLine();//lectura por teclado
        
        while (zenbakia != null) {
            firteera.println(zenbakia); //envió cadena al servidor
            erantzuna = fsarrera.readLine(); //recibo cadena del servidor
            System.out.println(erantzuna);
            
            System.out.print("Sartu zenbakia: ");
            zenbakia = in.readLine();//lectura por teclado
        }
        System.out.print("galdu duzu ");
// CERRAR STREAMS Y SOCKETS
        fsarrera.close();
        firteera.close();
        Bezeroa.close();
    }
    }
    

