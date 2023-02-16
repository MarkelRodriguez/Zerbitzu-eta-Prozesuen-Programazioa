/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package udpazterketa;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author rodriguez.markel
 */
public class UDPSerbitzaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket ServerSocket = new DatagramSocket(9876);
        byte[] jasota = new byte[1024];
        byte[] bidalita = new byte[1024];
        String zenbakia;
        int emaitza;
        
            System.out.println("datagrama itxaroten");
            //jaso datagrama
            jasota = new byte[1024];
            DatagramPacket paqJasota = new DatagramPacket(jasota, jasota.length);

            ServerSocket.receive(paqJasota);
            zenbakia = new String(paqJasota.getData());
            //direkzioa
            InetAddress IPOrigen = paqJasota.getAddress();
            int portua = paqJasota.getPort();
            
            System.out.println("\tjasotako zenbakia: " + zenbakia.trim());
            //berreketa egin eta byte-etara pasa
            emaitza = Integer.parseInt(zenbakia.trim())* Integer.parseInt(zenbakia.trim());
            bidalita = Integer.toString(emaitza).getBytes();
            //datagrama bidali bezerora
            DatagramPacket paqBidalita = new DatagramPacket(bidalita, bidalita.length, IPOrigen, portua);
            ServerSocket.send(paqBidalita);
            //Para terminar
           
        
        ServerSocket.close();
        System.out.println("Socket cerrado...");
    }
    
}
