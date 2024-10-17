
package ipc12023.juegopokemon_proyecto2.frontend.CasillaMapa;

import ipc12023.juegopokemon_proyecto2.backend.AdminJuego;
import ipc12023.juegopokemon_proyecto2.backend.JuegoPokemonException;
import ipc12023.juegopokemon_proyecto2.backend.Jugador;
import ipc12023.juegopokemon_proyecto2.frontend.JuegoPokemonApp;
import ipc12023.juegopokemon_proyecto2.frontend.JDialogEdificios.*;
import javax.swing.JOptionPane;

public class Hospital extends Edificio {
    
    private String PATH_IMAGEN="/casillas/hospital.png";

    public Hospital(){

     pathImagen = PATH_IMAGEN;
     super.agregarImagen();
    }

    @Override
    public void iniciar(String contraseña, JuegoPokemonApp ventanaApp) {
        
        try {
            Jugador Jugador = AdminJuego.cargar(contraseña);
            JDlgHospital hospital = new JDlgHospital(ventanaApp, true, Jugador, ventanaApp);
            hospital.setVisible(true);
        } catch (JuegoPokemonException e) {
            JOptionPane.showMessageDialog(ventanaApp, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    
}
