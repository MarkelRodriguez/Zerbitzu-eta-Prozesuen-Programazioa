/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package adibidea1;

/**
 *
 * @author rodriguez.markel
 */
public class Adibidea1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Runtime r = Runtime.getRuntime();
        String comando = "NOTEPAD";

        Process p;
        try {
            p = r.exec(comando);
        } catch (Exception e) {
            System.out.println("Error e n : " + comando);
            e.printStackTrace();
        }

    }
}
