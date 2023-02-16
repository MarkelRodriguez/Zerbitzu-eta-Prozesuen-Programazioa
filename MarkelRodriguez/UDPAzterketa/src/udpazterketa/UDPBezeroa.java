/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package udpazterketa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author rodriguez.markel
 */
public class UDPBezeroa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();//socket bezeroa
        byte[] bidalita = new byte[1024];
        byte[] jasota = new byte[1024];
        // serbitzariaren datuak
        InetAddress IPServidor = InetAddress.getLocalHost();// localhost
        int puerto = 9876; // erabilitako portua
        //datuak teklatutik sartu
        System.out.print("Sartu zenbakia: ");
        String zenbakia = in.readLine();
        bidalita = zenbakia.getBytes();
        //bidali datagrama serbitzarira
        DatagramPacket bidali = new DatagramPacket(bidalita, bidalita.length, IPServidor, puerto);
        clientSocket.send(bidali);
        // jaso datagrama serbitzartik
        DatagramPacket jaso = new DatagramPacket(jasota, jasota.length);
        System.out.println("Datagrama itxaroten");
        clientSocket.receive(jaso);
        String berreketa = new String(jaso.getData());
        //datagramaren informazioa bistaratu
        System.out.println("\tEmaitza: " + berreketa.trim());
        clientSocket.close();//itxi socket-a
    }
    
}
