
package ipc12023.juegopokemon_proyecto2.frontend.pokemon;

import ipc12023.juegopokemon_proyecto2.backend.AdminJuego;

public class PokemonTipoElectrico extends Pokemon {

    private static final  String TIPO = "Electrico";
    
    public PokemonTipoElectrico (){
        super.tipo = TIPO;
    }
    
    @Override
    public double calcularDañoPorSinergia(Pokemon oponente) {
    
        if (oponente instanceof PokemonTipoFuego) {
            dañoFinal *= N;
            dañoFinal = AdminJuego.dosDecimales(dañoFinal);
        }
        else if (oponente instanceof PokemonTipoAgua) {
            dañoFinal *= SE;
            dañoFinal = AdminJuego.dosDecimales(dañoFinal);
            
        }
        else if (oponente instanceof PokemonTipoTierra) {
            dañoFinal *= DR;
            dañoFinal = AdminJuego.dosDecimales(dañoFinal);
            
        }
        else if (oponente instanceof PokemonTipoElectrico) {
            dañoFinal *= NE;
            dañoFinal = AdminJuego.dosDecimales(dañoFinal);
            
        }
        return super.dañoFinal;
    }
    
}
