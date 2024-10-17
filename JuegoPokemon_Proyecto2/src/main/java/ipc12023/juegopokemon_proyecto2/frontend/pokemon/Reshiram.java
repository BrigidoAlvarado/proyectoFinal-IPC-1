
package ipc12023.juegopokemon_proyecto2.frontend.pokemon;

public class Reshiram extends PokemonTipoFuego{
    
    private static final String PATH_IMAGEN = "/Pokemon/reshiram.png";
    public final static String NOMBRE = "Reshiram";
    private final static double VIDA = 300;
    private final static double DANIO = 120;
    private final static double DEFENZA = 100;
    
    public Reshiram (){
        super.pathImagen = PATH_IMAGEN;
        super.nombre = NOMBRE;
        super.vidaBase = VIDA;
        super.vida = vidaBase;
        super.dañoBasico = DANIO;
        super.defenzaBasica = DEFENZA;
        super.agregarImagenYMarco();
    }
}
