
package ipc12023.juegopokemon_proyecto2.backend;

import ipc12023.juegopokemon_proyecto2.frontend.Batalla.BatallaEntrenador;
import ipc12023.juegopokemon_proyecto2.frontend.*;
import ipc12023.juegopokemon_proyecto2.frontend.CasillaMapa.*;
import ipc12023.juegopokemon_proyecto2.frontend.CasillaMapa.Espacio;
import ipc12023.juegopokemon_proyecto2.frontend.CasillaMapa.JLblCasillaMapa;
import javax.swing.JOptionPane;


public class MapaAleatorio extends Mapa {
    
    private static final int TAMANIO = 9;
    private static final String NOMBRE = "MAPA DE EXPLORACION";
    
    public MapaAleatorio( String contraseña, JuegoPokemonApp ventanaApp){
        
        super.tamaño = TAMANIO;
        super.nombre = NOMBRE;
        this.ventanaApp = ventanaApp;
        this.contraseña = contraseña;
        this.casillaJugador = new CasillaJugador();
        
        super.mapa = new JLblCasillaMapa[TAMANIO][TAMANIO];
        super.mapaVisible = new JLblCasillaMapa[TAMANIO][TAMANIO];
        
        iniciarMapa();
        super.ventanaApp.mostrarComponentesTablero(true);
        super.ventanaApp.mostrarBttnSalir();
        
    }

    @Override
    public void moverPieza(String direccion) {
        
        super.validarDireccionDelMovimiento(casillaJugador, mapa, direccion);
        super.validarPosicion(mapa);
        super.validarArbol(mapa);
        
        buscarEntrenador(mapa);
        despejarMapa();
    }
    
    private void iniciarMapa(){
        
        Espacio.generar(mapa, Espacio.CESPED);
        
        Agua agua = new Agua();
        agua.generarCasilla(mapa);
        Arbol arbol = new Arbol();
        arbol.generarCasilla(mapa);
        HierbaAlta hierba = new HierbaAlta();
        hierba.generarCasilla(mapa);
        try {
           Entrenador entrenador = new Entrenador(AdminJuego.cargar(contraseña).getNivel());
           entrenador.generarCasilla(mapa);
        } catch (JuegoPokemonException e) {
            JOptionPane.showMessageDialog(ventanaApp, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            ventanaApp.mostrarComponentesTablero(false);
        }
        casillaJugador.generarCasilla(mapa);
        despejarMapa();
    }
   
    private void despejarMapa(){

        //genera un mapa lleno de niebla
        Espacio.generar(mapaVisible, Espacio.NIEBLA);

        //variables de posicion del jugador
            int inicio_i = super.casillaJugador.getPosicion_i() - 2,
            final_i = super.casillaJugador.getPosicion_i() + 3,

            inicio_j = super.casillaJugador.getPosicion_j() - 2,
            final_j = super.casillaJugador.getPosicion_j() + 3;

        for (int t = inicio_i; t < final_i; t++) {
            for (int u = inicio_j; u < final_j; u++) {
                
                if (rangoMapa(t, u, mapa)) {
                   mapaVisible[t][u] = mapa[t][u]; 
                }
            }
        }
    }
    
    private void buscarEntrenador(JLblCasillaMapa [][] mapa){
      //RANGO DE BUSQUESDA
        int inicio_i = casillaJugador.getPosicion_i()-1,
          final_i = casillaJugador.getPosicion_i()+2,
          inicio_j = casillaJugador.getPosicion_j()-1,
          final_j = casillaJugador.getPosicion_j()+2;
      
      for (int t = inicio_i; t < final_i; t++) {
          for (int u = inicio_j; u < final_j; u++) {
              if (super.rangoMapa(t, u,mapa)) {
                  
                  if (mapa[t][u] instanceof Entrenador) {
                      
                      try {
                          BatallaEntrenador batalla = new BatallaEntrenador(ventanaApp,((Entrenador)mapa[t][u]));
                          batalla.iniciarBatalla();
                      } catch (JuegoPokemonException e) {
                          
                          JOptionPane.showMessageDialog(ventanaApp, e.getMessage(), "BATALLA CANCELADA", JOptionPane.INFORMATION_MESSAGE);
                           ventanaApp.regresarMapaPrincipal();
                           ventanaApp.mostrarComponentesTablero(true);
                           ventanaApp.ocultarBttnSalir();
                           ventanaApp.refrescar();
                      }
                      mapa[t][u] = new Espacio(Espacio.CESPED); 
                      
                  }
              }
          }
          
      }
  }
}
