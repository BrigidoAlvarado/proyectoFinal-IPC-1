
package ipc12023.juegopokemon_proyecto2.frontend.CasillaMapa;

public abstract class CasillaCaminante extends CasillaGenerada {
    
    protected int posicion_i;
    protected int posicion_j;

    public int getPosicion_i() {
        return posicion_i;
    }

    public int getPosicion_j() {
        return posicion_j;
    }

    public void setPosicion(int posicion_i, int posicion_j) {
        this.posicion_j = posicion_j;
        this.posicion_i = posicion_i;
    }

}
