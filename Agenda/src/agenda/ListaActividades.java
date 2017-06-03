/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

/**
 *
 * @author Ricardo
 */
public class ListaActividades {

    Actividad[] actividades;
    int posLibreActividad = 0;

    public ListaActividades(int numeroActividades) {
        this.actividades = new Actividad[numeroActividades];
    }
   
    public void addActividad(Actividad act){
        actividades[posLibreActividad] = act;
        posLibreActividad++;
    }
    
    public Actividad retornarActividad(int index){
        
        if(index < 0){
            return null;
        }        
        else if (actividades.length < index){
            return null;
        }
        else{
            return actividades[index];
        }
        
    }
    
}
