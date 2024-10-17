
package ipc12023.juegopokemon_proyecto2.backend.articulosTienda;

public class CatchballNormal extends Catchball {
    
    private final static int PROBABILIDAD_CAPTURA = 15;
   // final static int PROBABILIDAD_CAPTURA=50;
    private final static double PORCENTAJE_NECESARIO = 0.15;
    //final static double PORCENTAJE_NECESARIO=0.80;
    
    public final static String NOMBRE = "Catchball Normal";
    public final static int PRECIO = 2;

    public CatchballNormal(){
        nombre = NOMBRE;
        precio = PRECIO;
        probabilidadCaptura = PROBABILIDAD_CAPTURA;
        porcentajeNecesario = PORCENTAJE_NECESARIO;
        
    }
}
