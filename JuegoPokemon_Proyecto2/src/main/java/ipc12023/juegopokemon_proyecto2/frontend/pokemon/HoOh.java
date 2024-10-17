
package ipc12023.juegopokemon_proyecto2.frontend.pokemon;

public class HoOh extends PokemonTipoFuego {
    
    private static final String PATH_IMAGEN = "/Pokemon/ho-oh.png";
    public final static String NOMBRE = "Ho-Oh";
    private final static double VIDA = 318;
    private final static double DANIO = 130;
    private final static double DEFENZA = 90;
    
    public HoOh (){
        super.pathImagen = PATH_IMAGEN;
        super.nombre = NOMBRE;
        super.vidaBase = VIDA;
        super.vida = vidaBase;
        super.dañoBasico = DANIO;
        super.defenzaBasica = DEFENZA;
        super.agregarImagenYMarco();
    }
}
