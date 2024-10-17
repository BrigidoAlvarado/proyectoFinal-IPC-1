
package ipc12023.juegopokemon_proyecto2.backend.articulosTienda;

public class CatchballSemiprofesional extends Catchball{
    
    private static int PROBABILIDAD_CAPTURA = 30;
    private static double PORCENTAJE_NECESARIO = 0.3;
    
     public final static int PRECIO = 5;
     public static final String NOMBRE = "Catchball Semiprofesional";
    
    public CatchballSemiprofesional(){
        nombre=NOMBRE;
        precio=PRECIO;
        probabilidadCaptura=PROBABILIDAD_CAPTURA;
        porcentajeNecesario=PORCENTAJE_NECESARIO;
        
    }
}
