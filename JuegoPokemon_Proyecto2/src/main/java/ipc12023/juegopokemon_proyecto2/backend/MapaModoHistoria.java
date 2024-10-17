
package ipc12023.juegopokemon_proyecto2.backend;

import ipc12023.juegopokemon_proyecto2.frontend.CasillaMapa.*;
import ipc12023.juegopokemon_proyecto2.frontend.JuegoPokemonApp;
import java.io.Serializable;

public class MapaModoHistoria extends Mapa implements Serializable{
    
    private static final long serialVersionUID = 0271237L;
    private static final int TAMANIO = 9;
    private static final String NOMBRE = "MAPA PRINCIPAL";
    
    public MapaModoHistoria (String contraseña, JuegoPokemonApp ventanaApp){
        
        super.tamaño = TAMANIO;
        this.nombre = NOMBRE;
        this.ventanaApp = ventanaApp;
        this.contraseña = contraseña;
        generarMapaPrincipal();
        super.casillaJugador = new CasillaJugador();
        casillaJugador.generarCasilla(this.mapaVisible);
        super.ventanaApp.agregarGridLayaut(tamaño);
        super.ventanaApp.mostrarComponentesTablero(true);
        super.ventanaApp.ocultarBttnSalir();
    }

    @Override
    public void moverPieza(String direccion) {

        super.validarDireccionDelMovimiento(casillaJugador, mapaVisible, direccion);
        super.validarPosicion(mapaVisible);
        super.validarArbol(mapaVisible);
        validarEdificio();
    }
    
    private void validarEdificio(){
        if (mapaVisible[paso_i][paso_j] instanceof Edificio) {
           
            ((Edificio)mapaVisible[paso_i][paso_j]).iniciar(contraseña, ventanaApp);
        }
    }
    
     private void generarMapaPrincipal(){
        
         JLblCasillaMapa[][] mapaPintado = {
            {new Arbol(),new Arbol(),new Arbol(),new Arbol(),new Casino(),new Arbol(),new Arbol(),new Arbol(),new Arbol(),},
            {new Arbol(),new Arbol(),new Arbol(),new Espacio(),new Espacio(),new Arbol(),new Arbol(),new Arbol(),new Arbol(),},
            {new Arbol(),new Arbol(),new Espacio(),new Espacio(),new Espacio(),new Espacio(),new Espacio(),new Arbol(),new Arbol(),},
            {new Arbol(),new Arbol(),new Espacio(),new Agua(),new Agua(),new Arbol(),new Espacio(),new Espacio(),new Arbol()},
            {new EdInventario(),new Espacio(),new Espacio(),new Agua(),new Agua(),new Agua(),new Espacio(),new Espacio(),new Hospital()},
            {new Arbol(),new Espacio(),new Espacio(),new Agua(),new Agua(),new Agua(),new Arbol(),new Espacio(),new Arbol()},
            {new Arbol(),new Arbol(),new Espacio(),new Espacio(),new Arbol(),new Espacio(),new Espacio(),new Espacio(),new Arbol()},
            {new Arbol(),new Arbol(),new Arbol(),new Espacio(),new Espacio(),new Espacio(),new Espacio(),new Espacio(),new Espacio()},
            {new Arbol(),new Arbol(),new Arbol(),new Arbol(),new Tienda(),new Espacio(),new Arbol(),new Arbol(),new Puerta()}
        };
         
         this.mapaVisible = mapaPintado;
     }
     
}
