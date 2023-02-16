/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcp2strings;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author USUARIO
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server started");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                DataInputStream in = new DataInputStream(clientSocket.getInputStream());

                String string1 = in.readUTF();
                String string2 = in.readUTF();

                System.out.println("Received: " + string1 + " " + string2);

                clientSocket.close();
                System.out.println("Client disconnected");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
