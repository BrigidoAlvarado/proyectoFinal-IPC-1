
package ipc12023.juegopokemon_proyecto2.backend.articulosTienda;

public class CatchballProfesional extends Catchball {
    
    public final static int PRECIO = 10;
    private final static int PROBABILIDAD_CAPTURA = 50;
    private final static double PORCENTAJE_NECESARIO = 0.5;
    public final static String NOMBRE = "catchball Profesional";

    public CatchballProfesional() {
     nombre = NOMBRE;
     precio = PRECIO;
     probabilidadCaptura = PROBABILIDAD_CAPTURA;
     porcentajeNecesario = PORCENTAJE_NECESARIO;
    }
}
