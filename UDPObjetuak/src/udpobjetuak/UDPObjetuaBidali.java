/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package udpobjetuak;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author rodriguez.markel
 */
public class UDPObjetuaBidali {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        InetAddress destino = InetAddress.getLocalHost();
        int port = 12345; //puerto al que envió el datagrama
        byte[] mensaje = new byte[1024];
        Pertsona persona = new Pertsona("Maria", 22);
        //CONVERTIMOS OBJETO A BYTES
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bs);
        out.writeObject(persona); //escribir objeto Persona en el stream
        out.close(); //cerrar stream
        byte[] bytes = bs.toByteArray(); // objeto en bytes
        DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, port);
        DatagramSocket socket = new DatagramSocket(34567);//Puerto local
        
        socket.send(envio);
        socket.close(); //cierro el socket
    }

}
