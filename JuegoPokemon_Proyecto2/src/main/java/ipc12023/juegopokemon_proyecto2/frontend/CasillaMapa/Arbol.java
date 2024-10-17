
package ipc12023.juegopokemon_proyecto2.frontend.CasillaMapa;

import ipc12023.juegopokemon_proyecto2.frontend.JDialogEdificios.JDlgConfirmar;
import ipc12023.juegopokemon_proyecto2.frontend.CasillaMapa.*;
import ipc12023.juegopokemon_proyecto2.frontend.*;
import ipc12023.juegopokemon_proyecto2.backend.*;
import javax.swing.JOptionPane;

public class Arbol extends CasillaGenerada {

   private static final int PRECIO_TALA = 5;
   private static int MAX_CASILLAS_GENERADAS = 12;
   private String PATH_IMAGEN = "/casillas/arbol.png";
   
   public Arbol(){
    
    pathImagen = PATH_IMAGEN;
    casillasMax = MAX_CASILLAS_GENERADAS;
    super.agregarImagen();
   }
    
    @Override
    public void generarCasilla(JLblCasillaMapa[][] mapa) {

        
         casillasGeneradas = 0;
        
         //llenar con la casilla
            while(casillasMax != casillasGeneradas){
               
                i = AdminJuego.random(0, mapa.length - 1);
                j = AdminJuego.random(0, mapa.length - 1);

             if(mapa[i][j] instanceof Espacio){
                    
                mapa[i][j] = new Arbol(); 
                casillasGeneradas++;
              } 
           }
    }
    
    public void talar(String contraseña, JLblCasillaMapa[][] mapa, int i, int j, JuegoPokemonApp ventana){
        
        JDlgConfirmar menu = new JDlgConfirmar(ventana, true, "Precio por talar un arbol: " + PRECIO_TALA, "DESEA TALAR EL ARBOL");
        menu.setVisible(true);
        
        if (menu.getOpcion()) {
            try {
                Jugador jugador = AdminJuego.cargar(contraseña);
                jugador.gastarOro(PRECIO_TALA, ventana);
                mapa[i][j] = new Espacio();
            
            } catch (JuegoPokemonException e) {
                JOptionPane.showMessageDialog(ventana, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
}
