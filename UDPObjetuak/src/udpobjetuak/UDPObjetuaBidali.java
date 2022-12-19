/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package udpobjetuak;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author rodriguez.markel
 */
public class UDPObjetuaBidali {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Pertsona persona = new Pertsona("Maria", 22);
        //CONVERTIMOS OBJETO A BYTES
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bs);
        out.writeObject(persona); //escribir objeto Persona en el stream
        out.close(); //cerrar stream
        byte[] bytes = bs.toByteArray(); // objeto en bytes
    }

}
