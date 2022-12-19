/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package udpadibidea2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author rodriguez.markel
 */
public class UDPServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException, IOException {

        //Puerto por el que escucha el servidor: 9876
        DatagramSocket ServerSocket = new DatagramSocket(9876);
        byte[] recibidos = new byte[1024];
        byte[] enviados = new byte[1024];
        String cadena;
        while (true) {
            System.out.println("Esperando datagrama ");
            //RECIBO DATAGRAMA
            recibidos = new byte[1024];
            DatagramPacket paqRecibido = new DatagramPacket(recibidos, recibidos.length);

            ServerSocket.receive(paqRecibido);
            cadena = new String(paqRecibido.getData());
            //DIRECCION ORIGEN
            InetAddress IPOrigen = paqRecibido.getAddress();
            int puerto = paqRecibido.getPort();
            System.out.println("\tOrigen: " + IPOrigen + +puerto);
            System.out.println("\tMensaje recibido: " + cadena.trim());
            //CONVERTIR CADENA A MAYÚSCULA
            String mayuscula = cadena.trim().toUpperCase();
            enviados = mayuscula.getBytes();
            //ENVIO DATAGRAMA AL CLIENTE
            DatagramPacket paqEnviado = new DatagramPacket(enviados, enviados.length, IPOrigen, puerto);
            ServerSocket.send(paqEnviado);
            //Para terminar
            if (cadena.trim().equals("*")) {
                break;
            }
        }
        ServerSocket.close();
        System.out.println("Socket cerrado...");
    }
}
