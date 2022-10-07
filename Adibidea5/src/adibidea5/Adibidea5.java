/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package adibidea5;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 *
 * @author rodriguez.markel
 */
public class Adibidea5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Runtime r = Runtime.getRuntime();
        String comando = "CMD /C DATE ";
        Process p = null;

        try {
            p = r.exec(comando);
//escritura -- envia entrada a DATE
            OutputStream os = p.getOutputStream();
            os.write("02-12-12".getBytes());
            os.flush(); //vacia el buffer de salida
//lectura -- obtiene la salida de DATE
            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
// COMPROBACION DE ERROR - 0 bien 1 -mal
        int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Valor de Salida: " + exitVal);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


