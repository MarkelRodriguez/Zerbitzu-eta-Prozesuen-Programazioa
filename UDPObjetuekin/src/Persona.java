
import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aitzol
 */
public class Persona implements Serializable{
    public String izena;
    public String abizena;
    
    public Persona(String izena,String abizena){
        super();
        this.izena = izena;
        this.abizena = abizena;
    }

}
