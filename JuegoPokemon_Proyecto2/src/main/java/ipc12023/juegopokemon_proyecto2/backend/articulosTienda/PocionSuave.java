
package ipc12023.juegopokemon_proyecto2.backend.articulosTienda;

public class PocionSuave extends Pocion {
    
    private final static double CANT_SANACION = 40;
    
    public final static String NOMBRE="Pocion Suave";
    public final static int PRECIO = 20;
    
    public PocionSuave (){
        nombre = NOMBRE;
        precio = PRECIO;
        cantSanacion = CANT_SANACION;
    } 
}
