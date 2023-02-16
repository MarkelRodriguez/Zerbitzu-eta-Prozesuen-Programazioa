/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcp2strings;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author USUARIO
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Socket socket = new Socket("localhost", 8000);
            System.out.println("Connected to server");

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String string1 = "Hello";
            String string2 = "World";

            out.writeUTF(string1);
            out.writeUTF(string2);
            System.out.println("Sent: " + string1 + " " + string2);

            socket.close();
            System.out.println("Disconnected from server");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
    
}
