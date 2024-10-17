
package ipc12023.juegopokemon_proyecto2.backend.articulosTienda;

import ipc12023.juegopokemon_proyecto2.backend.AdminJuego;
import ipc12023.juegopokemon_proyecto2.backend.JuegoPokemonException;
import ipc12023.juegopokemon_proyecto2.backend.Jugador;
import ipc12023.juegopokemon_proyecto2.frontend.pokemon.Pokemon;
import ipc12023.juegopokemon_proyecto2.frontend.*;
import ipc12023.juegopokemon_proyecto2.frontend.Batalla.JInternalFrameBatalla;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Pocion extends ArticuloTienda {
    
    protected double cantSanacion;

    @Override
    public void usar(Pokemon pokemon, Jugador jugador, JuegoPokemonApp ventana, JInternalFrameBatalla batalla) throws JuegoPokemonException {
    
        double vidaSanada = pokemon.getVida() + cantSanacion;
        vidaSanada = AdminJuego.dosDecimales(vidaSanada);
        
             if (vidaSanada > pokemon.getVidaBase()) {
                
                cantSanacion = pokemon.getVidaBase() - pokemon.getVida();
                cantSanacion = AdminJuego.dosDecimales(cantSanacion);
                pokemon.setVida(pokemon.getVidaBase());
            }
             else{
                  pokemon.setVida(vidaSanada);
             }
     batalla.actualizarDatos();
     JOptionPane.showMessageDialog(ventana, pokemon.getNombre()+" ha recuperado "+ String.valueOf(cantSanacion) +" puntos de salud",
                         "Pocion "+nombre+" usada", JOptionPane.PLAIN_MESSAGE, new ImageIcon(getClass().getResource(ArticuloTienda.PATH_POCION))); 
      jugador.actualizar();
    }
    
}
