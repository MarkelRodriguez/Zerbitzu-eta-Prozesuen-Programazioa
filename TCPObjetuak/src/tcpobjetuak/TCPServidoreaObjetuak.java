/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcpobjetuak;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author rodriguez.markel
 */
public class TCPServidoreaObjetuak {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int portua = 6000;
        ServerSocket servidorea = new ServerSocket(portua);
        System.out.println("Esperando al cliente...");
        Socket cliente = servidorea.accept();
        
        //se prepara un flujo de salida de objetos
        ObjectOutputStream outObjetua = new ObjectOutputStream(cliente.getOutputStream());
        
        //se prepara un objeto y se envia 
        Pertsona p = new Pertsona("Juan", 21);
        outObjetua.writeObject(p);
        
        //enviando objeto
        System.out.println("Envio: " + p.getNombre() + " " + p.getEdad());
        
        //se obtiene un stream para leer
        ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
        
    }
    
}
