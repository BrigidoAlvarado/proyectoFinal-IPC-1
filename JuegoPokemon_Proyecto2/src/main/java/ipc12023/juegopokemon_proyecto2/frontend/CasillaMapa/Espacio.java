
package ipc12023.juegopokemon_proyecto2.frontend.CasillaMapa;

public class Espacio extends JLblCasillaMapa{
    
    private static final String PATH_IMAGEN_CESPED = "/casillas/cesped.png";
    private static final String PATH_IMAGEN_CESPED_MARCADO = "/casillas/cespedMarcado.png";
    private static final String PATH_IMAGEN_NIEBLA = "/casillas/niebla.png";
    private static final String[] PATHS ={PATH_IMAGEN_CESPED,PATH_IMAGEN_NIEBLA,PATH_IMAGEN_CESPED_MARCADO};
    public static final int CESPED = 0;
    public static final int NIEBLA = 1;
    public static final int CESPED_MARCADO = 2;
    
    private boolean marcada;

    public Espacio(int opcion) {
        pathImagen = PATHS[opcion];
        marcada = (opcion == CESPED_MARCADO);
        super.agregarImagen();
    }
    
    public Espacio(){
        pathImagen = PATH_IMAGEN_CESPED;
        super.agregarImagen();
    }
    
    public boolean isMarcada() {
        return marcada;
    }

    public void setMarcada( ) {
        removeAll();
        this.marcada = true;
        super.pathImagen = PATH_IMAGEN_CESPED_MARCADO;
        super.agregarImagen();
        repaint();
        revalidate();
    }
    
    public static void generar(JLblCasillaMapa[][] mapa, int opcion){
        
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa.length; j++) {
               
                mapa[i][j] = new Espacio(opcion);
                
            }
        }
    }
}
