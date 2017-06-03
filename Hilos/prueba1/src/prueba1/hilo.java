/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IvanAlfonso
 */
public class hilo extends Thread{
    
    public hilo(String nombre, int tiempo){
        
        this.nombre = nombre;
        this.tiempo = tiempo;
    }
    
    public String nombre;
    int tiempo;
    int numV = 0 ;
    @Override
    public void run(){
        Date now = null;
        String dateString = "2015-09-14 16:03:028";
        for(int i = 0; i<10 ;i++){
            
            try {
                
                sleep(tiempo);
               
                System.out.println("este preceso " + nombre);
                numV+=1;
            } catch (InterruptedException ex) {
                Logger.getLogger(hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
