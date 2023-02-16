
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aitzol
 */
public class ServidorUDPObjetos {
    public static void main(String[] args) throws SocketException, IOException, ClassNotFoundException {
        //Puerto por el que escucha el servidor: 9876
        DatagramSocket ServerSocket = new DatagramSocket (9876);
        byte[] recibidos = new byte[1024];
        
        while(true){
            System.out.println("Esperando datagrama...");
            DatagramPacket paqRecibido = new DatagramPacket(recibidos, recibidos.length);
            ServerSocket.receive(paqRecibido); //recibo el datagrama
            //CONVERTIMOS BYTES A OBJETO
            ByteArrayInputStream bais = new ByteArrayInputStream(recibidos);
            ObjectInputStream in = new ObjectInputStream(bais);
            Persona persona = (Persona) in.readObject();
            in.close();

            System.out.println("Persona recibida");
            System.out.println("Nombre: " + persona.izena + ",Apellido: " + persona.abizena);
        }
    }
}
