
package ipc12023.juegopokemon_proyecto2.backend.articulosTienda;

import ipc12023.juegopokemon_proyecto2.backend.Jugador;
import ipc12023.juegopokemon_proyecto2.frontend.pokemon.Pokemon;
import ipc12023.juegopokemon_proyecto2.frontend.*;
import ipc12023.juegopokemon_proyecto2.backend.JuegoPokemonException;
import ipc12023.juegopokemon_proyecto2.frontend.Batalla.JInternalFrameBatalla;
import java.io.Serializable;

public abstract class ArticuloTienda implements Serializable{
    private static final long serialVersionUID = 24865L;
    
    public static final String PATH_ORO = "/icons/bolsaOro.png";
    public static final String PATH_POCION = "/icons/pocion50x50.png";
    public static final String PATH_CATCHBALL = "/icons/pocion50x50.png";
    
    protected int precio;
    protected String nombre;
    
    public abstract void usar(Pokemon pokemon, Jugador jugador, JuegoPokemonApp ventana, JInternalFrameBatalla batalla) throws JuegoPokemonException;
}
