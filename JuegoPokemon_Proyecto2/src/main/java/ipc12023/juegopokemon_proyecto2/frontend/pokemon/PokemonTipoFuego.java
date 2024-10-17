
package ipc12023.juegopokemon_proyecto2.frontend.pokemon;

import ipc12023.juegopokemon_proyecto2.backend.AdminJuego;

public class PokemonTipoFuego extends Pokemon {
    
    private static final  String TIPO = "Fuego";

    public PokemonTipoFuego() {
        super.tipo = TIPO;
    }

    @Override
    public double calcularDañoPorSinergia(Pokemon oponente) {

         if (oponente instanceof PokemonTipoFuego) {
            dañoFinal *= NE;
            dañoFinal = AdminJuego.dosDecimales(dañoFinal);
            
        }
        else if (oponente instanceof PokemonTipoAgua) {
            dañoFinal *= NE;
            dañoFinal = AdminJuego.dosDecimales(dañoFinal);
            
        }
        else if (oponente instanceof PokemonTipoTierra) {
            dañoFinal *= N;
            dañoFinal = AdminJuego.dosDecimales(dañoFinal);
        }
        else if (oponente instanceof PokemonTipoElectrico) {
            dañoFinal*=N;
            dañoFinal = AdminJuego.dosDecimales(dañoFinal);
           
        }
        
        return super.dañoFinal;
    }
    
    
}
