
package ipc12023.juegopokemon_proyecto2.frontend.pokemon;

public class Groudon extends PokemonTipoTierra {
    
    private static final String PATH_IMAGEN = "/Pokemon/groudon.png";
    public final static String NOMBRE = "Groudon";
    private final static double VIDA = 300;
    private final static double DANIO = 180;
    private final static double DEFENZA = 160;
    
    public Groudon (){
        super.pathImagen = PATH_IMAGEN;
        super.nombre = NOMBRE;
        super.vidaBase = VIDA;
        super.vida = vidaBase;
        super.dañoBasico = DANIO;
        super.defenzaBasica = DEFENZA;
        super.agregarImagenYMarco();
    }
}
