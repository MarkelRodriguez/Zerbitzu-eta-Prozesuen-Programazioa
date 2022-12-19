/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package udpadibidea;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author rodriguez.markel
 */
public class UDPCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        // TODO code application logic here
        InetAddress destino = InetAddress.getLocalHost();
        int port = 12345; //puerto al que envió el datagrama
        byte[] mensaje = new byte[1024];
        String Saludo = "Enviando Saludos !!";
        mensaje = Saludo.getBytes(); //codifico String a bytes
        //CONSTRUYO EL DATAGRAMA A ENVIAR
        DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, port);
        DatagramSocket socket = new DatagramSocket(34567);//Puerto local
        System.out.println("Enviando Datagrama de longitud: " + mensaje.length);
        System.out.println("Host destino : " + destino.getHostName());
        System.out.println("IP Destino : " + destino.getHostAddress());
        System.out.println("Puerto local del socket: "
                + socket.getLocalPort());
        System.out.println("Puerto al que envio: " + envio.getPort());
        //ENVIO DATAGRAMA
        socket.send(envio);
        socket.close(); //cierro el socket
    }
}
