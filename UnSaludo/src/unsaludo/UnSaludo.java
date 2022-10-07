/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package unsaludo;



/**
 *
 * @author rodriguez.markel
 */
public class UnSaludo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
           //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if (args.length < 1) {
            System.out.println("SE NECESITA UN SALUDO...");
            System.exit(1);
        }
        //String saludo = args[0];
        for (int i = 0; i < 5; i++) {
            System.out.println(i + 1 +".Agurra "+args[0]);
        }

    }
    
}
