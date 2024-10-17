
package ipc12023.juegopokemon_proyecto2.frontend.pokemon;

public class Gyarados extends PokemonTipoAgua {
    
    private static final String PATH_IMAGEN = "/Pokemon/gyarados.png";
    public final static String NOMBRE = "Gyarados";
    private final static double VIDA = 285;
    private final static double DANIO = 155;
    private final static double DEFENZA = 109;
    
    public Gyarados (){
        super.pathImagen = PATH_IMAGEN;
        super.nombre = NOMBRE;
        super.vidaBase = VIDA;
        super.vida = vidaBase;
        super.dañoBasico = DANIO;
        super.defenzaBasica = DEFENZA;
        super.agregarImagenYMarco();
    }
}
