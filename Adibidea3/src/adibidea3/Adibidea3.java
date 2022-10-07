/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package adibidea3;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author rodriguez.markel
 */
public class Adibidea3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Runtime r = Runtime.getRuntime();
        String comando = "java -jar UnSaludo.jar \"Hola Mundo!!\" ";
        Process p = null;
        if (args.length < 1) {
            System.out.println("SE NECESITA UN NOMBRE DE FICHERO...");
            System.exit(1);
        }
        try {
//fichero al que se enviará la salida del programa Unsaludo
            FileOutputStream fos = new FileOutputStream(args[0]);
            PrintWriter pw = new PrintWriter(fos);
            p = r.exec(comando);
            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String linea;
        
        while ((linea = br.readLine()) != null) {
            //lee la salida de Unsaludo

            System.out.println("INSERTO EN " + args[0] + " > " + linea);
            pw.println(linea); //la inserta en el fichero
        }

        br.close();
        pw.close();
    }
    catch (Exception e){ 
            e.printStackTrace();
    }
// COMPROBACION DE ERROR - 0 bien 1 -mal
    int exitVal;

    
        try {
            exitVal = p.waitFor();
        System.out.println("Valor de Salida: " + exitVal);
    }
    catch (InterruptedException e

    
        ) {
            e.printStackTrace();
    }
}

}
