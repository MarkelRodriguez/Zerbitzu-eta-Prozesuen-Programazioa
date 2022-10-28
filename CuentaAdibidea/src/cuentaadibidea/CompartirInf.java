/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cuentaadibidea;

/**
 *
 * @author rodriguez.markel
 */
public class CompartirInf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cuenta c = new Cuenta(40);
        SacarDinero hi = new SacarDinero("Ana", c);
        SacarDinero h2 = new SacarDinero("Juan", c);
        hi.start();
        h2.start();
    }

}
