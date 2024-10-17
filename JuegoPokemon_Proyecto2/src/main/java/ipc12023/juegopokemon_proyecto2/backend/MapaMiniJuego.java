
package ipc12023.juegopokemon_proyecto2.backend;

import ipc12023.juegopokemon_proyecto2.frontend.CasillaMapa.*;
import ipc12023.juegopokemon_proyecto2.frontend.JuegoPokemonApp;
import javax.swing.JOptionPane;

public class MapaMiniJuego extends Mapa{
    
    private static final String NOMBRE = "MAPA MINI JUEGO";
    private final static int CASILLAS_PARA_DESBLOQUEAR = 5;
    
    private int pasos;
    private int pasosExtra;
    private int oro;
    
    private Manzana manzana;
    private Jugador jugador;
    
    private int contadorPasos;
    private int contadorManzanas;
    private int contadorCasillasMarcadas;
    
    public MapaMiniJuego(Jugador jugador, JuegoPokemonApp ventanaApp, int tamaño, int pasos, int pasosExtra, int oro) throws JuegoPokemonException{
      
      manzana = new Manzana();
      casillaJugador = new CasillaJugador();
      casillaJugador.cambiarAPokemon();
      
      this.ventanaApp = ventanaApp;
      this.mapaVisible = new JLblCasillaMapa[tamaño][tamaño];
      this.pasos = pasos;
      this.pasosExtra = pasosExtra;
      this.oro = oro;
      this.jugador = jugador;
      setNombre();
      
      iniciarMapa();
      this.ventanaApp.agregarGridLayaut(tamaño);
      this.ventanaApp.redimensionarPanel(tamaño);
      super.ventanaApp.mostrarComponentesTablero(true);
      super.ventanaApp.mostrarBttnSalir();
      this.ventanaApp.refrescar();
      this.jugador.vecesMiniJuego();
    }

    @Override
    public void moverPieza(String direccion) {
        
        validarDireccionDelMovimiento(casillaJugador, mapaVisible, direccion);
        validarPosicion(mapaVisible);
        setNombre();
        if (validarSiPerdio()) {
            ventanaApp.regresarMapaPrincipal();
            ventanaApp.refrescar();
        }
    }
    
    private void iniciarMapa(){
        
        Espacio.generar(mapaVisible, Espacio.CESPED);
        casillaJugador.generarCasilla(mapaVisible);
        manzana.generarCasilla(mapaVisible);
        
    }
    
    @Override
    protected void validarPosicion(JLblCasillaMapa[][] mapa){

        if (mapa [paso_i][paso_j] instanceof Espacio) {
            
            if (((Espacio)mapa [paso_i][paso_j]).isMarcada()) {
                // estará sobre una casilla marcada
                casillaJugador.setEstaraSobreHierba(true);
                moverJugador(mapaVisible);
                   
            } else{
                //no ira a una casilla marcada
                casillaJugador.setEstaraSobreHierba(false);
                moverJugador(mapaVisible);
            }
            
        } else if (mapa [paso_i][paso_j] instanceof Manzana) {
               
            premiar();
            
        }
    }
    
    private void premiar() {
        
        contadorManzanas ++;
        moverJugador(mapaVisible);
        manzana.generarCasilla(mapaVisible);
        contadorPasos -= pasosExtra;
        try {
            jugador.ganarOro(oro, ventanaApp);
            
        } catch (JuegoPokemonException e) {
            JOptionPane.showMessageDialog(ventanaApp, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        
        }
        
        JOptionPane.showMessageDialog(ventanaApp, "Has atrapado la manzana, se  te han añadido " + pasosExtra + " pasos","FELICIDADES" , JOptionPane.INFORMATION_MESSAGE);
        
        if (contadorManzanas == CASILLAS_PARA_DESBLOQUEAR) {
            desbloquearCasillas();
            contadorManzanas = 0;
            JOptionPane.showMessageDialog(ventanaApp, "Se ha desbloqueado la mitad de casillas marcadas por atrapar 5 manzanas", nombre, JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    private void desbloquearCasillas(){
        
       contadorCasillasMarcadas /= 2;
        int casillasDesbloqueadas = 0;
        
        while( casillasDesbloqueadas < contadorCasillasMarcadas){
            
            int i = AdminJuego . random (0, mapaVisible.length - 1);
            int j = AdminJuego . random (0, mapaVisible.length - 1);
            
            if (  mapaVisible[i][j] instanceof Bloqueador ) {
                
                    mapaVisible[i][j] = new Espacio();
                    casillasDesbloqueadas++;
                }
                
            }
        
    }
    
    private void moverJugador(JLblCasillaMapa[][] mapa){
        
        if (casillaJugador.isEstaraSobreHierba()) {
            
            if (casillaJugador.isParadoSobreHierba()) {
                
                mapa[casillaJugador.getPosicion_i()][casillaJugador.getPosicion_j()] = new Bloqueador();
                casillaJugador.setPosicion(paso_i, paso_j);
                mapa[casillaJugador.getPosicion_i()][casillaJugador.getPosicion_j()] = casillaJugador;
                contadorCasillasMarcadas ++;
            }
            else{
                mapa[casillaJugador.getPosicion_i()][casillaJugador.getPosicion_j()] = new Espacio(Espacio.CESPED_MARCADO);
                casillaJugador.setPosicion(paso_i, paso_j);
                mapa[casillaJugador.getPosicion_i()][casillaJugador.getPosicion_j()] = casillaJugador;
                
                }
         // esta sobre una casilla marcada
                casillaJugador.setParadoSobreHierba(true);
                casillaJugador.setEstaraSobreHierba(false);
            
            
        } else{
            //no estara sobre una casilla marcada
            
            if (casillaJugador.isParadoSobreHierba()) {
                
                 mapa[casillaJugador.getPosicion_i()][casillaJugador.getPosicion_j()] = new Bloqueador();
                 casillaJugador.setPosicion(paso_i, paso_j);
                 mapa[casillaJugador.getPosicion_i()][casillaJugador.getPosicion_j()] = casillaJugador;
                 casillaJugador.setParadoSobreHierba(false);
                 contadorCasillasMarcadas ++;
                 
            }
            else{
                 mapa[casillaJugador.getPosicion_i()][casillaJugador.getPosicion_j()] = new Espacio(Espacio.CESPED_MARCADO);
                 casillaJugador.setPosicion(paso_i, paso_j);
                 mapa[casillaJugador.getPosicion_i()][casillaJugador.getPosicion_j()] = casillaJugador;
            }
           
        }
        contadorPasos ++;
        setNombre();
        ventanaApp.refrescar();
    }

    private boolean validarSiPerdio(){
        
        int cont = 0;
        int pos_i = casillaJugador.getPosicion_i();
        int pos_j = casillaJugador.getPosicion_j();
        
        //buscar arriba
        if (rangoMapa((pos_i-1),pos_j,mapaVisible )) {
            
            if (mapaVisible[pos_i-1][pos_j] instanceof Bloqueador ) {
                cont++;
            }
        }
        else{
            cont++;
        }
        //busacar abajo
        
        if (rangoMapa((pos_i+1),pos_j,mapaVisible )) {
            
            if (mapaVisible[pos_i+1][pos_j] instanceof Bloqueador) {
                cont++;
            }
        }
        else{
            cont++;
        }
        //buscar izquierda
       if (rangoMapa((pos_i),(pos_j-1),mapaVisible )) {
            if (mapaVisible[pos_i][pos_j-1] instanceof Bloqueador) {
                cont++;
            }
        }
       else{
           cont++;
       }
        //buscar derecha
        if (rangoMapa((pos_i),(pos_j+1),mapaVisible )) {
            
            if (mapaVisible[pos_i][pos_j+1] instanceof Bloqueador) {
                cont++;
            }
        }
        else{
            cont++;
        }
        
        //validar
        
        if (contadorPasos == pasos) {
            
            JOptionPane.showMessageDialog(ventanaApp, "Te has quedado sin pasos", "HAS PERDIDO", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        
        if (cont == 4) {
            JOptionPane.showMessageDialog(ventanaApp, "Ya no puedes moverte", "HAS PERDIDO", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else{
            return false;
        }
      
        //return cont == 4;
    }
    
    private void setNombre(){
        this.nombre = (NOMBRE + " pasos disponible: "+(pasos - contadorPasos)+" Manzanas: "+contadorManzanas);
    }
     
}
