
package ipc12023.juegopokemon_proyecto2.backend.inventario;

import ipc12023.juegopokemon_proyecto2.frontend.*;
import ipc12023.juegopokemon_proyecto2.frontend.pokemon.*;
import ipc12023.juegopokemon_proyecto2.backend.*;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class InventarioPokemon implements Serializable{
   
    private static final long serialVersionUID = 0502200320232011L;
    private final static int MAX_POKEMONES = 5;
    
    private  Pokemon[] pokemon = new Pokemon[MAX_POKEMONES];
    private  int pokemonesDisponibles;
    private  int pokemones;
    private  int casillasDisponibles;
 
    private void calcularPokemonesDisponibles (){
        pokemonesDisponibles = 0;
        for (int i = 0; i < pokemon.length; i++) {
            if (pokemon[i] != null) {
                if (!pokemon[i].isDebilitado()) {
                pokemonesDisponibles ++;
            }
            }
            
        }
    }
    
    public Pokemon[] getPokemones(){
        return pokemon;
    }
    
    /**
     *
     * @return
     */
    public Pokemon[] getPokemonesDisponibles(){
        
        calcularPokemonesDisponibles();
        
        Pokemon[] pokemonsNoDebilitados = new Pokemon[pokemonesDisponibles];
        
        int cont = 0;
        
        for (int i = 0; i < MAX_POKEMONES; i++) {
            
            if (pokemon[i] != null) {
                if (!pokemon[i].isDebilitado()) {
                pokemonsNoDebilitados[cont] = pokemon[i];
                cont++;
             }
            }
            
        }
        return pokemonsNoDebilitados;
    }    
    
    public int calNivelJugador(){
        pokemonesEnInventario();
        int nivel = 0;
        
        for (int i = 0; i < pokemon.length; i++) {
            if (pokemon[i] != null) {
                 nivel += pokemon[i].getNivel();
            }
        }
    //se calcula el promedio
        nivel = (int)nivel/pokemones;
        return nivel;
    }
    
    private  void pokemonesEnInventario(){
        
        pokemones = 0;
         for (int i = 0; i < pokemon.length; i++) {
            if (pokemon[i] != null) {
                pokemones++;
            }
        }
    }
    
    private boolean isLleno(){
        int cont = 0;
        for (int i = 0; i < pokemon.length; i++) {
            if (pokemon[i] != null) {
                cont ++;
            }
        }
        
        return cont == pokemon.length;
    }
    
    public void añadirPokemon(Pokemon nuevo,JuegoPokemonApp ventana) throws JuegoPokemonException{
       
        if (isLleno()) {
            throw new JuegoPokemonException("Tu inventario de pokemones está lleno");
        }
        else{
            for (int i = 0; i < pokemon.length; i++) {
            if (pokemon[i] == null) {
                pokemon[i] = nuevo;
                JOptionPane.showMessageDialog(ventana,nuevo.getNombre()+" ha sido añadido exitosamente al inventario pokemon", "NUEVO POKEMON",
                        JOptionPane.PLAIN_MESSAGE, new ImageIcon(getClass().getResource(nuevo.getPath())) );
                break;
            }
        }
       }
    }
    
    public Pokemon[] getPokemonesHeridos(){
        
        int noPokemonesHeridos = 0;
        for (int i = 0; i < pokemon.length; i++) {
           
            if (pokemon[i] != null) {
                if (pokemon[i].getVida() != pokemon[i].getVidaBase()) {
                noPokemonesHeridos ++;
            }
            }
        }
        Pokemon[] pokemonesHeridos = new Pokemon[noPokemonesHeridos];
        
        int cont = 0;
        for (int i = 0; i < pokemon.length; i++) {

            if (pokemon[i] != null) {
                if (pokemon[i].getVida() != pokemon[i].getVidaBase()) {
                pokemonesHeridos[cont] = pokemon[i];
                cont++;
            }
            }
        }
        return pokemonesHeridos;
    }
}
