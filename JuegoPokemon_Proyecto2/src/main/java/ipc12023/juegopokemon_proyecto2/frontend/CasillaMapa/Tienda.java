/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipc12023.juegopokemon_proyecto2.frontend.CasillaMapa;

import ipc12023.juegopokemon_proyecto2.backend.AdminJuego;
import ipc12023.juegopokemon_proyecto2.backend.JuegoPokemonException;
import ipc12023.juegopokemon_proyecto2.backend.Jugador;
import ipc12023.juegopokemon_proyecto2.frontend.JuegoPokemonApp;
import ipc12023.juegopokemon_proyecto2.frontend.JDialogEdificios.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Personal
 */
public class Tienda extends Edificio {
    
    private String PATH_IMAGEN="/casillas/tienda.png";

    public Tienda(){

     pathImagen = PATH_IMAGEN;
     super.agregarImagen();
    }

    @Override
    public void iniciar(String contraseña, JuegoPokemonApp ventanaApp) {
        
        try {
            Jugador jugador = AdminJuego.cargar(contraseña);
            JDlgTienda tienda = new JDlgTienda(ventanaApp, true, jugador, ventanaApp);
            tienda.setVisible(true);
        } catch (JuegoPokemonException e) {
            JOptionPane.showMessageDialog(ventanaApp, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
