
package ipc12023.juegopokemon_proyecto2.frontend.CasillaMapa;

import ipc12023.juegopokemon_proyecto2.frontend.JuegoPokemonApp;
import ipc12023.juegopokemon_proyecto2.frontend.JDialogEdificios.JDlgMiniJuego;
import ipc12023.juegopokemon_proyecto2.backend.AdminJuego;
import ipc12023.juegopokemon_proyecto2.backend.JuegoPokemonException;
import javax.swing.JOptionPane;

public class Casino extends Edificio {

    private String PATH_IMAGEN="/casillas/casino.png";

    public Casino(){

     pathImagen = PATH_IMAGEN;
     super.agregarImagen();
    }

    @Override
    public void iniciar(String contraseña, JuegoPokemonApp ventanaApp) {
        try {
            
            JDlgMiniJuego miniJuego = new JDlgMiniJuego(ventanaApp, true, AdminJuego.cargar(contraseña), ventanaApp);
            miniJuego.setVisible(true);
        } catch (JuegoPokemonException e) {
            JOptionPane.showMessageDialog(ventanaApp, e.getMessage(), "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
   
    
}
