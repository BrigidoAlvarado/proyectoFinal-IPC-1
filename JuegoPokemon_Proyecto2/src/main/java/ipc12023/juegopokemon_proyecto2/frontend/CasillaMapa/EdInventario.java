
package ipc12023.juegopokemon_proyecto2.frontend.CasillaMapa;

import ipc12023.juegopokemon_proyecto2.backend.AdminJuego;
import ipc12023.juegopokemon_proyecto2.backend.JuegoPokemonException;
import ipc12023.juegopokemon_proyecto2.backend.Jugador;
import ipc12023.juegopokemon_proyecto2.frontend.JuegoPokemonApp;
import ipc12023.juegopokemon_proyecto2.frontend.JDialogEdificios.JDlgEdIventario;
import javax.swing.JOptionPane;

public class EdInventario extends Edificio {
    
    private String PATH_IMAGEN = "/casillas/inventario.png";

    public EdInventario(){

     pathImagen = PATH_IMAGEN;
     super.agregarImagen();
    }

    @Override
    public void iniciar(String contraseña, JuegoPokemonApp ventanaApp) {
        try {
            Jugador jugador = AdminJuego.cargar(contraseña);
            JDlgEdIventario inventario = new JDlgEdIventario(ventanaApp, true, jugador, ventanaApp);
            inventario.setVisible(true);
        } catch (JuegoPokemonException e) {
            JOptionPane.showMessageDialog(ventanaApp,e.getMessage() , "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
   
}
