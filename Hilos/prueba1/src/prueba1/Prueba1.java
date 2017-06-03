/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba1;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author IvanAlfonso
 */
public class Prueba1 {
 
   
   
    public static void main(String[] args) throws ParseException, InterruptedException {
        
        
        hilo proceso = new hilo("ivan",2000);
        hilo proceso1 = new hilo("alfonso",1000);
        
        
        proceso.start();
        llenar();
        proceso1.start();
        
        
        
        
    }
        
    
    public static void llenar() throws ParseException{
    
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");  
        
        Date nuevaFecha = new Date();
        nuevaFecha = formato.parse("01-11-1987");  
        
        System.out.println(nuevaFecha.toString());
    
    }
    
    
    
   
}
