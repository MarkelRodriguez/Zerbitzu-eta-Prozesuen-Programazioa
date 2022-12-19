/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package udpobjetuak;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author rodriguez.markel
 */
public class UDPObjetuaJaso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO code application logic here
        byte[] recibidos = new byte [1024];
DatagramPacket paqRecibido = new
DatagramPacket(recibidos, recibidos.length);
DatagramSocket socket = new DatagramSocket(34567);//Puerto local
socket.receive(paqRecibido); //recibo el datagrama
// CONVERTIMOS BYTES A OBJETO
ByteArrayInputStream bais = new ByteArrayInputStream(recibidos);
ObjectInputStream in = new ObjectInputStream(bais);
Pertsona persona = (Pertsona) in.readObject();//obtengo obj eto
in.close();
    }
    
}
