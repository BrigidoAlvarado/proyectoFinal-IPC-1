
package ipc12023.juegopokemon_proyecto2.backend.inventario;

import ipc12023.juegopokemon_proyecto2.backend.JuegoPokemonException;
import java.io.Serializable;

public class Inventario <T> implements Serializable{
    
    private static final long serialVersionUID = 05022003202320223L;
    
    public static final String CATCHBALL_NORMAL = "Catchball Normal";
    public static final String CATCHBALL_SEMIPROFESIONAL = "Catchball Semiprofesional";
    public static final String CATCHBALL_PROFESIONAL = "Catchball Profesional";
    public static final String POCION_SUAVE = "Pocion Suave";
    public static final String POCION_FUERTE = "Pocion Fuerte";
    
    
    private String tipoInventario;
    private Nodo <T> primero;
    private Nodo <T> ultimo;
    private int size = 0;

    public Inventario(String tipoInventario) {
        this.tipoInventario = tipoInventario;
    }

    public void agregar(T contenido) {
        
        Nodo <T> nodoNuevo = new Nodo <>(contenido);
        
        if (esVacia()) {
           
            primero = nodoNuevo;
            ultimo = nodoNuevo;
            
        } 
        else if (size == 1){
            
            nodoNuevo.setAnterior(primero);
            primero.setSiguiente(nodoNuevo);
            ultimo = nodoNuevo;
        }
        else {
            ultimo.setSiguiente(nodoNuevo);
            nodoNuevo.setAnterior(ultimo);
            ultimo = nodoNuevo;
            
        }
        size++;
    }

    public boolean esVacia() {
        return (size == 0);
    }

    public T usarArticulo() throws JuegoPokemonException {
        
        if (esVacia()) {
            throw  new JuegoPokemonException("Ya no tienes " + tipoInventario + " puedes ir a la tienda a comprar más.");
        }
        
        T contenido = ultimo.getContenido();
        
        if (size == 1) {
            
            primero = null;
            ultimo = null;
            size = 0;
        } else {
            
            Nodo penultimo = ultimo.getAnterior();
            penultimo.setSiguiente(null);
            ultimo = penultimo;

            size--;
        }
        
        return contenido;
    } 
   
    public int getSize(){
        return size;
    }
}
