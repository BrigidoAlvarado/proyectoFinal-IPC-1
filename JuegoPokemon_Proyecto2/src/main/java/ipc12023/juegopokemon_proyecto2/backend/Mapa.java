
package ipc12023.juegopokemon_proyecto2.backend;

import ipc12023.juegopokemon_proyecto2.frontend.CasillaMapa.*;
import ipc12023.juegopokemon_proyecto2.frontend.Batalla.BatallaPokemonSalvaje;
import ipc12023.juegopokemon_proyecto2.frontend.JuegoPokemonApp;
import javax.swing.JOptionPane;

public abstract class Mapa {
    
    protected String contraseña;
    protected String nombre;
    protected JuegoPokemonApp ventanaApp;
    protected JLblCasillaMapa[][] mapa;
    protected JLblCasillaMapa[][] mapaVisible;
    protected CasillaJugador casillaJugador;
    protected int tamaño;
   //se usa para validar a donde se quiere dar el paso
    protected boolean opcionValida=true;
    protected int paso_i;
    protected int paso_j;
    
  

    public JLblCasillaMapa[][] getMapaVisible() {
        return mapaVisible;
    }
    
    public String getNombre (){
        return nombre;
    }
    
    public abstract void moverPieza(String direccion);

    protected void validarDireccionDelMovimiento(CasillaJugador personaje, JLblCasillaMapa[][]mapa, String opcion){
      
      paso_i = personaje.getPosicion_i();
      paso_j = personaje.getPosicion_j();
     
       switch(opcion){
           //subir
         case("w"):if (rangoMapa(paso_i-1,paso_j,mapa)) {
                 paso_i--;
             }
         break;
         
         case("W"):if (rangoMapa(paso_i-1,paso_j,mapa)) {
                 paso_i--;
             }
         break;
         //bajar
         case("s"):if (rangoMapa(paso_i+1,paso_j,mapa)) {
                 paso_i++;
             }
         break;
         
         case("S"):if (rangoMapa(paso_i+1,paso_j,mapa)) {
                 paso_i++;
             }
         break;
         //izquierda
         case("a"):if (rangoMapa(paso_i,paso_j-1,mapa)) {
                 paso_j--;
             }
         break;
         
         case("A"):if (rangoMapa(paso_i,paso_j-1,mapa)) {
                 paso_j--;
             }
         break;
         //derecha
         case("d"):if (rangoMapa(paso_i,paso_j+1,mapa)) {
                 paso_j++;   
             }
         break;
         
         case("D"):if (rangoMapa(paso_i,paso_j+1,mapa)) {
                 paso_j++;   
             }
         break;
      
     }     
  }
   
    protected void validarPosicion(JLblCasillaMapa[][] mapa){
    
     if (mapa[paso_i][paso_j] instanceof Espacio) {
              
         moverPersonaje(mapa);
                
      }else if (mapa[paso_i][paso_j] instanceof HierbaAlta){
         HierbaAlta hierbaAlta = ((HierbaAlta)mapa[paso_i][paso_j]);          
          
        casillaJugador.setEstaraSobreHierba(true);
        moverPersonaje(mapa);
        casillaJugador.setParadoSobreHierba(true);
        casillaJugador.setEstaraSobreHierba(false);
        
         if (hierbaAlta.getPokemon() != null) {
             
             try {
                 BatallaPokemonSalvaje batalla = new BatallaPokemonSalvaje(ventanaApp, hierbaAlta.getPokemon());
                 batalla.iniciarBatalla();
             } catch (JuegoPokemonException e) {
                 
                 JOptionPane.showMessageDialog(ventanaApp, e.getMessage(), "BATALLA CANCELADA", JOptionPane.INFORMATION_MESSAGE);
                 ventanaApp.regresarMapaPrincipal();
                 ventanaApp.mostrarComponentesTablero(true);
                 ventanaApp.ocultarBttnSalir();
                 ventanaApp.refrescar();
             }
         }
                
      }
     } 
    
    protected void validarArbol(JLblCasillaMapa[][] mapa){
        
        if (mapa[paso_i][paso_j] instanceof Arbol) {
              
           ((Arbol)mapa[paso_i][paso_j]).talar(contraseña, mapa, paso_i, paso_j, ventanaApp);
           
         }
    }
    
    protected void moverPersonaje(JLblCasillaMapa[][] mapa){
        
        //colocar en la posicion anterior cesped
                
      if (casillaJugador.isParadoSobreHierba()) {
          
          mapa[casillaJugador.getPosicion_i()][casillaJugador.getPosicion_j()] = new HierbaAlta();
          casillaJugador.setPosicion(paso_i, paso_j);
          mapa[casillaJugador.getPosicion_i()][casillaJugador.getPosicion_j()] = casillaJugador;
          casillaJugador.setParadoSobreHierba(false);
      } 
      else{
          
          mapa[casillaJugador.getPosicion_i()][casillaJugador.getPosicion_j()] = new Espacio();
          casillaJugador.setPosicion(paso_i, paso_j);
          mapa[casillaJugador.getPosicion_i()][casillaJugador.getPosicion_j()] = casillaJugador;
          
      }
    }
    
    protected boolean rangoMapa(int i, int j,JLblCasillaMapa[][] mapa){

          return ( i >= 0 && i < mapa.length && j >= 0 && j < mapa.length); 
    }
    
    public int getTamaño(){
        return tamaño;
    }
     
}

