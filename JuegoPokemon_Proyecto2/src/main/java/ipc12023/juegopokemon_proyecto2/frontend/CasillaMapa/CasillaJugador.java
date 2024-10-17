
package ipc12023.juegopokemon_proyecto2.frontend.CasillaMapa;

import ipc12023.juegopokemon_proyecto2.backend.*;

public class CasillaJugador extends CasillaCaminante{
   
    private final static String IMAGEN = "/casillas/jugador.png";
    public static final String PATH_POKEMON = "/casillas/pokemonJugador.png"; 
    private final static int MAX_CASILLAS_GENERADAS = 1;
    public final static int CATCHBALL_INICIALES = 10;
    
    //poscion en el mapa principal para regresar al mismo punto.
    private int posMapaPricipal_i;
    private int posMapaPrincipal_j;
    private boolean enElMapaPrincipal;
    
    private boolean paradoSobreHierba = false;
    private boolean estaraSobreHierba = false;
    private String nombre;
    private String contraseña;

    public CasillaJugador(){
            pathImagen = IMAGEN;
            casillasMax = MAX_CASILLAS_GENERADAS;
            super.agregarImagen();
            
    }
    
       @Override
    public void generarCasilla(JLblCasillaMapa[][] mapa) {

        casillasGeneradas = 0;
        
         //llenar con la casilla
            while(casillasMax != casillasGeneradas){
               
                i=AdminJuego.random(0, mapa.length-1);
                j=AdminJuego.random(0, mapa.length-1);

             if(mapa[i][j] instanceof Espacio){
                    
                mapa[i][j] = this; 
                    
                       posicion_i = i;
                       posicion_j = j;
                       casillasGeneradas++;
                       
              } 
                
         }

    }
    
    public void cambiarAPokemon(){
        removeAll();
        pathImagen = PATH_POKEMON;
        agregarImagen();
        repaint();
        revalidate();
    }
    
    public void setContraseña (String contraseña){
        this.contraseña = contraseña;
    }
    
    public String getContraseña (){
        return contraseña;
    }
    
    public boolean isEnElMapaPrincipal(){
        return enElMapaPrincipal;
    }
    
    public void estaEnElMapaPrincipal(){
        enElMapaPrincipal=true;
    }
    
    public void noEstaEnElMapaPrincipal(){
        enElMapaPrincipal=false;
    }
    
   
    public void setPosicionMapa(int i,int j){
      posMapaPricipal_i=i;
      posMapaPrincipal_j=j;
      
    }
    
    public int getPosMapaPricipal_i() {
        return posMapaPricipal_i;
    }

    public int getPosMapaPrincipal_j() {
        return posMapaPrincipal_j;
    }
    
    public String getNombre(){
        return nombre;
    }
    
     public boolean isParadoSobreHierba() {
        return paradoSobreHierba;
    }

    public void setParadoSobreHierba(boolean paradoSobreHierba) {
        this.paradoSobreHierba = paradoSobreHierba;
    }

    public boolean isEstaraSobreHierba() {
        return estaraSobreHierba;
    }

    public void setEstaraSobreHierba(boolean estabaSobreHierba) {
        this.estaraSobreHierba = estabaSobreHierba;
    }

}
