
package ipc12023.juegopokemon_proyecto2.frontend.CasillaMapa;

import ipc12023.juegopokemon_proyecto2.backend.MapaAleatorio;
import ipc12023.juegopokemon_proyecto2.frontend.*;


public class Puerta extends Edificio {
 
    private String PATH_IMAGEN="/casillas/puerta.png";

    public Puerta(){

     pathImagen = PATH_IMAGEN;
     super.agregarImagen();
    }

    @Override
    public void iniciar(String contraseña, JuegoPokemonApp ventanaApp) {
    
        this.ventanaApp = ventanaApp;
        this.contraseña = contraseña;
        this.ventanaApp.setMapa(new MapaAleatorio(contraseña, ventanaApp));
        this.ventanaApp.refrescar();
    }
    
}
