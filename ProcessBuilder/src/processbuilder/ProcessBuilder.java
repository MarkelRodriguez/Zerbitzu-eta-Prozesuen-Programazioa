/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package processbuilder;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author rodriguez.markel
 */
public class ProcessBuilder {



    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new ProcessBuilder("CMD");
        
        
    }
    public ProcessBuilder(String cmd){
        try{
            ProcessBuilder pb = new ProcessBuilder("CMD");
            
            File fBat = new File("C:/Users/rodriguez.markel/Documents/GitHub/Zerbitzu-eta-Prozesuen-Programazioa/ProcessBuilder/fitxero1.txt");
            File fOut = new File("C:/Users/rodriguez.markel/Documents/GitHub/Zerbitzu-eta-Prozesuen-Programazioa/ProcessBuilder/output.txt");
            File fErr = new File("C:/Users/rodriguez.markel/Documents/GitHub/Zerbitzu-eta-Prozesuen-Programazioa/ProcessBuilder/error.txt");
            pb.redirectInput(fBat) ;
            pb.redirectOutput(fOut) ;
            pb.redirectError(fErr);
            pb.start(); 
           
        }
        
    }
    
    

   
    
}
