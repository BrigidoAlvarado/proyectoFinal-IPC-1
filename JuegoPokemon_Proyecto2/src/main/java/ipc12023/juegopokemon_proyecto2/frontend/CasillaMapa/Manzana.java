
package ipc12023.juegopokemon_proyecto2.frontend.CasillaMapa;

import ipc12023.juegopokemon_proyecto2.backend.AdminJuego;

public class Manzana extends CasillaCaminante{
    
    private static final String PATH_IMAGEN = "/casillas/manzana.png";
    private static final int MAX_CASILLAS = 1;
    
    public Manzana(){
        
        pathImagen = PATH_IMAGEN;
        casillasMax = MAX_CASILLAS;
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
                    
                 if (!((Espacio)mapa[i][j]).isMarcada()) {
                      
                     mapa[i][j] = this; 
                     posicion_i = i;
                     posicion_j = j;
                     casillasGeneradas++;
                 }
                       
              } 
          }

    
    }
}
