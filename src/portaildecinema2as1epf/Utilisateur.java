/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package portaildecinema2as1epf;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Hugo
 */
public class Utilisateur {
    private String id;
    private boolean verification;
    
    public Utilisateur(String valid, boolean valadmin){
        id = valid;
        verification = valadmin;
    }
    
    public boolean getVerification(){
        return verification;
    }
    
    public String getId(){
        return id;
    }
}  
     
        
        
    


