
package ipc12023.juegopokemon_proyecto2.backend.articulosTienda;

public class PocionFuerte extends Pocion {
    
    private final static double CANT_SANACION = 100;
    
    public final static String NOMBRE = "Pocion Fuerte";
    public final static int PRECIO = 100;
    
    public PocionFuerte(){
        nombre = NOMBRE;
        precio = PRECIO;
        cantSanacion = CANT_SANACION;
    }
}
