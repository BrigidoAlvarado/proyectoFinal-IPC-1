
package ipc12023.juegopokemon_proyecto2.frontend.CasillaMapa;

import ipc12023.juegopokemon_proyecto2.backend.AdminJuego;
import ipc12023.juegopokemon_proyecto2.frontend.pokemon.Pokemon;

public class Entrenador extends CasillaGenerada {
    
    private static final String PATH_IMAGEN = "/casillas/entrenador.png";
    private final static int MAX_CASILLAS_GENERADAS = 5;
    
    private int nivelJugador;
    private  Pokemon[] pokemones;
    
    public Entrenador(int nivelJugador){
        this.nivelJugador = nivelJugador;
        if (nivelJugador <= MAX_CASILLAS_GENERADAS) {
            
            casillasMax = nivelJugador;
        }
        else{
            casillasMax = MAX_CASILLAS_GENERADAS;
        }
    }
    
    public Entrenador (){
        
        pathImagen = PATH_IMAGEN;
        
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
                    
                mapa[i][j] = new Entrenador(); 
                casillasGeneradas++;
              } 
           }
    }
    
    public Pokemon[] generarPokemones(int noPokemones){
       
        pokemones = new Pokemon[noPokemones];
      //Llenar el arreglo con pokemones
        for (int k = 0; k < pokemones.length; k++) {
            pokemones[k] = Pokemon.random();
        }
      //Setear el nivel a los pokemones
        for (int k = 0; k < pokemones.length; k++) {
            
            pokemones[k].setNivel(pokemones[k].calcNivelPokemon(nivelJugador));
        }
        
        return pokemones;
    }
    
}
