
package ipc12023.juegopokemon_proyecto2.frontend.pokemon;

public class Garchomp extends PokemonTipoTierra {
    
    private static final String PATH_IMAGEN = "/Pokemon/garchomp.png";
    public final static String NOMBRE = "Garchomp";
    private final static double VIDA = 324;
    private final static double DANIO = 108;
    private final static double DEFENZA = 115;
    
    public Garchomp (){
        super.pathImagen = PATH_IMAGEN;
        super.nombre = NOMBRE;
        super.vidaBase = VIDA;
        super.vida = vidaBase;
        super.dañoBasico = DANIO;
        super.defenzaBasica = DEFENZA;
        super.agregarImagenYMarco();
    }
}
