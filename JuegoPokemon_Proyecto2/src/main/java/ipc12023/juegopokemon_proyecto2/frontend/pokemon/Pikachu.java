
package ipc12023.juegopokemon_proyecto2.frontend.pokemon;

public class Pikachu extends PokemonTipoElectrico{
    
    private static final String PATH_IMAGEN = "/Pokemon/pikachu.png";
    public final static String NOMBRE = "Pikachu";
    private final static double VIDA = 135;
    private final static double DANIO = 80;
    private final static double DEFENZA = 50;
    
    public Pikachu (){
        super.pathImagen = PATH_IMAGEN;
        super.nombre = NOMBRE;
        super.vidaBase = VIDA;
        super.vida = vidaBase;
        super.dañoBasico = DANIO;
        super.defenzaBasica = DEFENZA;
        super.agregarImagenYMarco();
    }
}
