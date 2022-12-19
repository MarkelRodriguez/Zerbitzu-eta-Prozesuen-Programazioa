/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcpobjetuak;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author rodriguez.markel
 */
public class TCPClienteaObjetuak {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String Host = "localhost";
        int Puerto = 6000;//puerto remoto
        System.out.println("PROGRAMA CLIENTE INICIADO....");
        Socket cliente = new Socket(Host, Puerto);
        //Flujo de entrada para objetos
        ObjectInputStream perEnt = new ObjectInputStream(
                cliente.getInputStream());
        //Se recibe un objeto
        Pertsona dato = (Pertsona) perEnt.readObject();//recibo objeto
        System.out.println("Recibo: " + dato.getNombre() + "*" + dato.getEdad());
        //Modifico el objeto
        dato.setNombre("Juan Ramos");
        dato.setEdad(22);
        //FLUJO DE salida para objetos
        ObjectOutputStream perSal = new ObjectOutputStream(
                cliente.getOutputStream());
        // Se envia el objeto
        perSal.writeObject(dato);
        System.out.println("Envio: " + dato.getNombre() + "*" + dato.getEdad());
        // CERRAR STREAMS Y SOCKETS
        perEnt.close();
        perSal.close();
        cliente.close();

    }

}
