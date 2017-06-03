/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

/**
 *
 * @author Julio
 */
public class Agenda {
    
    ListaActividades listaActividad;
   
    public Agenda(int tamanio){
        
        this.listaActividad = new ListaActividades(tamanio);
        
    }
        
    public void crearActividad(String nombre, String dia, int hora, String descripcion){
        
        Actividad nuevo = new Actividad(nombre, dia, hora, descripcion);
        listaActividad.addActividad(nuevo);
        
    }
    
    public Actividad buscarActividad(int index){
        
        return listaActividad.retornarActividad(index);

    }
    
}
