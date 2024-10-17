
package ipc12023.juegopokemon_proyecto2.frontend.CasillaMapa;

import ipc12023.juegopokemon_proyecto2.backend.AdminJuego;

public abstract class CasillaGenerada extends JLblCasillaMapa {
    
    protected int casillasMax;
    protected int casillasGeneradas;
    protected int i = 0;
    protected int j = 0;
    
    public abstract void generarCasilla(JLblCasillaMapa[][] mapa);
    
    public void generarCasillaUniversalmente (JLblCasillaMapa[][] mapa){
        
            //llenar con la casilla
         while(casillasMax != casillasGeneradas){

           i=AdminJuego.random(0, mapa.length-1);
           j=AdminJuego.random(0, mapa.length-1);
           
           if(mapa[i][j] instanceof Espacio){
                  mapa[i][j] = this;
                  casillasGeneradas++;
              }
           }
    }
}
