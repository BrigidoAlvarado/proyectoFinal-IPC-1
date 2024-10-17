
package ipc12023.juegopokemon_proyecto2.frontend.Batalla;

import ipc12023.juegopokemon_proyecto2.backend.JuegoPokemonException;
import ipc12023.juegopokemon_proyecto2.backend.inventario.Inventario;
import ipc12023.juegopokemon_proyecto2.frontend.JuegoPokemonApp;
import ipc12023.juegopokemon_proyecto2.frontend.pokemon.Pokemon;
import ipc12023.juegopokemon_proyecto2.backend.articulosTienda.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class BatallaPokemonSalvaje extends JInternalFrameBatalla {

    public BatallaPokemonSalvaje(JuegoPokemonApp ventana, Pokemon pokemonSalvaje) throws JuegoPokemonException {
        super(ventana, "Has encontrado un "+pokemonSalvaje.getNombre()+" salvaje");
        
        super.jCmbBxUtilizarObjeto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { PocionSuave.NOMBRE, PocionFuerte.NOMBRE, CatchballNormal.NOMBRE,
        CatchballSemiprofesional.NOMBRE, CatchballProfesional.NOMBRE}));
        this.enemigo = pokemonSalvaje.getNombre();
        this.pokemonOponente = pokemonSalvaje;
        this.pokemonOponente.setNivel(pokemonOponente.calcNivelPokemon(this.jugador.getNivel()));
        this.jLblImagenEntrenador.setVisible(false);
        this.jLblEntrenador.setVisible(false);
    }

    @Override
    public void cambiarPokemonEnemigo() {
        
        hayGanador = true;
    }

    @Override
    public void mensajeTurno() {
        JOptionPane.showMessageDialog(ventana, pokemonOponente.getNombre()+" iniciará ", "TURNO DEL POKEMON SALVAJE",
                JOptionPane.PLAIN_MESSAGE, new ImageIcon(getClass().getResource(pokemonOponente.getPath())));
    }
    
}
