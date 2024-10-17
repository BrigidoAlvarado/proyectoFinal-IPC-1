
package ipc12023.juegopokemon_proyecto2.frontend.CasillaMapa;

public class Bloqueador extends JLblCasillaMapa{
 
    private static final String PATH_IMAGEN = "/casillas/candado.png";
    
    public Bloqueador(){
        
        pathImagen = PATH_IMAGEN;
        super.agregarImagen();
    }
}
