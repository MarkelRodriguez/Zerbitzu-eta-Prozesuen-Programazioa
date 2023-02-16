
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aitzol
 */
public class ClienteUDPObjetos {
    public static void main(String[] args) throws UnknownHostException, IOException {
        // DATOS DEL SERVIDOR al que enviar mensaje
        DatagramSocket clientSocket = new DatagramSocket();//socket cliente
        InetAddress IPServidor = InetAddress.getLocalHost();// localhost
        int puerto = 9876; // puerto por el que escucha
        
        
        Persona persona = new Persona("Aitzol","Soto");
        //CONVERTIR OBJETO A BYTES
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bs);
        out.writeObject(persona);
        out.close();
        byte[] bytes = bs.toByteArray();
        DatagramPacket envio = new DatagramPacket(bytes, bytes.length, IPServidor, puerto);
        clientSocket.send(envio);
    }
}
