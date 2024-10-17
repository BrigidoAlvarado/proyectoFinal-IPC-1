
package ipc12023.juegopokemon_proyecto2.frontend.pokemon;

public class Jolteon extends PokemonTipoElectrico{
    
    private static final String PATH_IMAGEN = "/Pokemon/jolteon.png";
    public final static String NOMBRE = "Jolteon";
    private final static double VIDA = 195;
    private final static double DANIO = 65;
    private final static double DEFENZA = 60;
    
    public Jolteon (){
        super.pathImagen = PATH_IMAGEN;
        super.nombre = NOMBRE;
        super.vidaBase = VIDA;
        super.vida = vidaBase;
        super.dañoBasico = DANIO;
        super.defenzaBasica = DEFENZA;
        super.agregarImagenYMarco();
    }
}
