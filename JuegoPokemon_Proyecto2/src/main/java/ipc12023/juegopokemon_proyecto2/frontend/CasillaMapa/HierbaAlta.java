
package ipc12023.juegopokemon_proyecto2.frontend.CasillaMapa;

import ipc12023.juegopokemon_proyecto2.backend.AdminJuego;
import ipc12023.juegopokemon_proyecto2.frontend.pokemon.Pokemon;

public class HierbaAlta extends CasillaGenerada {

    final static int MAX_POKEMONES_SALVAJES = 5;
    final static int MIN_POKEMONES_SALVAJES = 1;
    final static String PATH_IMAGEN = "/casillas/hierbaAlta.png";
    final static int MAX_CASILLAS_GENERADAS = 20;
    
    private Pokemon pokemonSalvaje;
    
    public HierbaAlta (){
        
        casillasMax = MAX_CASILLAS_GENERADAS;
        pathImagen = PATH_IMAGEN;
        super.agregarImagen();
    }
    
    public HierbaAlta (Pokemon pokemonSalvaje){
        
        this.pokemonSalvaje = pokemonSalvaje;
        casillasMax = MAX_CASILLAS_GENERADAS;
        pathImagen = PATH_IMAGEN;
        super.agregarImagen();
    }
    
    @Override
    public void generarCasilla(JLblCasillaMapa[][] mapa) {

         casillasGeneradas = 0;
         int noCasillasConPokemon = AdminJuego.random(MIN_POKEMONES_SALVAJES, MAX_POKEMONES_SALVAJES);
         int contNoCasillasConPokemon = 0;
         
         //llenar con la casilla
            while(casillasMax != casillasGeneradas){
               
                i=AdminJuego.random(0, mapa.length-1);
                j=AdminJuego.random(0, mapa.length-1);

             if(mapa[i][j] instanceof Espacio){
                
                 if (contNoCasillasConPokemon <= noCasillasConPokemon) {
                     
                     mapa[i][j] = new HierbaAlta(Pokemon.random());
                     contNoCasillasConPokemon ++ ;
                 } else{
                     mapa[i][j] = new HierbaAlta(); 
                     casillasGeneradas++;
                 }
                
                       
              } 
           }
    }
    
    public Pokemon getPokemon(){
        return pokemonSalvaje;
    }
    
}
