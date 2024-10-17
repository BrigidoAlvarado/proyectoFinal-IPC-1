
package ipc12023.juegopokemon_proyecto2.frontend.CasillaMapa;

import ipc12023.juegopokemon_proyecto2.frontend.JuegoPokemonApp;

public abstract class Edificio extends JLblCasillaMapa{
    
    protected String contraseña;
    protected JuegoPokemonApp ventanaApp;
    
    public abstract void iniciar(String contraseña, JuegoPokemonApp ventanaApp);
}
