
package ipc12023.juegopokemon_proyecto2.frontend.pokemon;

public class Kyogre extends PokemonTipoAgua {
    
    private static final String PATH_IMAGEN = "/Pokemon/kyogre.png";
    public final static String NOMBRE = "Kyogre";
    private final static double VIDA = 300;
    private final static double DANIO = 150;
    private final static double DEFENZA = 90;
    
    public Kyogre (){
        super.pathImagen = PATH_IMAGEN;
        super.nombre = NOMBRE;
        super.vidaBase = VIDA;
        super.vida = vidaBase;
        super.dañoBasico = DANIO;
        super.defenzaBasica = DEFENZA;
        super.agregarImagenYMarco();
    }
}
