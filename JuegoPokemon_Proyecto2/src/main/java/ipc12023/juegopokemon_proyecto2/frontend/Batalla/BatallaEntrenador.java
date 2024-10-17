
package ipc12023.juegopokemon_proyecto2.frontend.Batalla;

import ipc12023.juegopokemon_proyecto2.frontend.Batalla.JInternalFrameBatalla;
import ipc12023.juegopokemon_proyecto2.backend.inventario.*;
import ipc12023.juegopokemon_proyecto2.backend.JuegoPokemonException;
import ipc12023.juegopokemon_proyecto2.frontend.CasillaMapa.Entrenador;
import ipc12023.juegopokemon_proyecto2.frontend.JuegoPokemonApp;
import ipc12023.juegopokemon_proyecto2.frontend.pokemon.Pokemon;
import ipc12023.juegopokemon_proyecto2.backend.articulosTienda.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class BatallaEntrenador extends JInternalFrameBatalla {
    
    private static final String ENTRENADOR = "Entrenador";
    
    //ENTRENADOR
    private Entrenador entrenador;
    private Pokemon[] pokemonesEntrenador;

    public BatallaEntrenador(JuegoPokemonApp ventana, Entrenador entrenador) throws JuegoPokemonException {
        super(ventana,"HAS ENCONTRADO UN ENTRENADOR");
        
        this.entrenador = entrenador;
        super.jCmbBxUtilizarObjeto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {PocionSuave.NOMBRE, PocionFuerte.NOMBRE }));
        this.enemigo = ENTRENADOR;
        
        this.pokemonesEntrenador = this.entrenador.generarPokemones(super.pokemonesJugador.length);
        this.pokemonOponente = pokemonesEntrenador[0];
    }

    @Override
    public void mensajeTurno() {
        JOptionPane.showMessageDialog(ventana, "El entrenador iniciará con " + pokemonOponente.getNombre(),
                "TURNO DEL ENTRENADOR", JOptionPane.PLAIN_MESSAGE, new ImageIcon(getClass().getResource(pokemonOponente.getPath())));
        
    }

    @Override
    public void cambiarPokemonEnemigo() {
            for (int i = 0; i < pokemonesEntrenador.length; i++) {
            
                if (!pokemonesEntrenador[i].isDebilitado()) {
                    pokemonOponente = pokemonesEntrenador[i];
                    JOptionPane.showMessageDialog(ventana, enemigo+" cambia de pokemon y elige a "+pokemonOponente.getNombre(), "Cambio de Pokemon"
                            , JOptionPane.PLAIN_MESSAGE, new ImageIcon(getClass().getResource(pokemonOponente.getPath())));
                    hayGanador = false;
                    break;
                }
            
        }
    }
    
    
     
    
}
