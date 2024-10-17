
package ipc12023.juegopokemon_proyecto2.backend.articulosTienda;

import ipc12023.juegopokemon_proyecto2.backend.AdminJuego;
import ipc12023.juegopokemon_proyecto2.backend.Jugador;
import ipc12023.juegopokemon_proyecto2.backend.*;
import ipc12023.juegopokemon_proyecto2.frontend.pokemon.Pokemon;
import ipc12023.juegopokemon_proyecto2.frontend.JuegoPokemonApp;
import ipc12023.juegopokemon_proyecto2.frontend.Batalla.*;
        

public class Catchball extends ArticuloTienda {
    
    protected  int probabilidadCaptura;
    protected  int cantCatchBall;
    protected  double porcentajeNecesario;

    @Override
    public void usar(Pokemon pokemon, Jugador jugador, JuegoPokemonApp ventana, JInternalFrameBatalla batalla) throws JuegoPokemonException{

        double porcentaje = pokemon.getVidaBase() * porcentajeNecesario;
        
        porcentaje = AdminJuego.dosDecimales(porcentaje);
           
            if ( pokemon.getVida() <= porcentaje) {
                
                if (AdminJuego.probabilidad(probabilidadCaptura)) {
                        jugador.añadirPokemon(pokemon, ventana);
                        batalla.cerrar();
                    }
                else {
                    throw new JuegoPokemonException("Mala suerte no has podido capturar al pokemon");
                }
                    
             }
               else{
                    throw new JuegoPokemonException("Este catchball necesita del "+porcentajeNecesario*100+"% para funcionar");
                }
            jugador.vecesCatchball();
    }
   
}
