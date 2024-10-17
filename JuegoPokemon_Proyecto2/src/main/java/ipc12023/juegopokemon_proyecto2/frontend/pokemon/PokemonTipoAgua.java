/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipc12023.juegopokemon_proyecto2.frontend.pokemon;

import ipc12023.juegopokemon_proyecto2.backend.AdminJuego;

public class PokemonTipoAgua extends Pokemon {

    private static final String TIPO = "Agua";

    public PokemonTipoAgua() {
        
        super.tipo = TIPO;
    }
    
    @Override
    public double calcularDañoPorSinergia(Pokemon oponente) {
    
        if (oponente instanceof PokemonTipoFuego) {
            dañoFinal *= SE;
            dañoFinal = AdminJuego.dosDecimales(dañoFinal);
        }
        else if (oponente instanceof PokemonTipoAgua) {
            dañoFinal *= NE;
            dañoFinal = AdminJuego.dosDecimales(dañoFinal);
        }
        else if (oponente instanceof PokemonTipoTierra) {
            dañoFinal *= SE;
            dañoFinal = AdminJuego.dosDecimales(dañoFinal);
        }
        else if (oponente instanceof PokemonTipoElectrico) {
            dañoFinal *= N;
            dañoFinal = AdminJuego.dosDecimales(dañoFinal);
        }
        
        return super.dañoFinal;
    }
    
}
