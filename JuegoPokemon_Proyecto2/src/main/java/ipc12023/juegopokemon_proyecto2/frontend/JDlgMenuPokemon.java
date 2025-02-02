
package ipc12023.juegopokemon_proyecto2.frontend;

import ipc12023.juegopokemon_proyecto2.frontend.pokemon.Pokemon;
import ipc12023.juegopokemon_proyecto2.backend.JuegoPokemonException;
import java.awt.Dimension;
public class JDlgMenuPokemon extends javax.swing.JDialog {

    
    public static final int MENU_TIPO_POKEMON = 0;
    public static final int MENU_TIPO_POKEMONES = 1;
    
    private Pokemon [] pokemones;
    private Pokemon [] pokemonesElegidos;
    private Pokemon pokemon;
    private String instrucciones;
    private int maximo;
    private int contElegidos;
    private int columnas;
    private int filas;
    private int altura;
    private int ancho;
    
    
    
    /**
     * Creates new form JDlgMenuPokemon
     */
    public JDlgMenuPokemon(java.awt.Frame parent, boolean modal, Pokemon [] pokemones, int maximo, String instrucciones, int columnas, int filas)   {
        super(parent, modal);
        initComponents();
        this.maximo = maximo;
        this.contElegidos = 0;
        this.pokemones = pokemones;
        this.instrucciones = instrucciones;
        this.columnas = columnas;
        this.filas = filas;
        this.pokemonesElegidos = new Pokemon[this.maximo];
        this.altura = (200 * this.filas) + (50 * this.filas);
        this.ancho = (200 * this.columnas) + (25 * this.columnas);
        
        iniciarMenu();
        refrescarJpnlOpcionesPokemon();
        super.setLocation(500, 50);
    }

    public Pokemon[] getPokemonesElegidos(){
        return pokemonesElegidos;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnlOpcionesPokemon = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(altura, ancho);
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        jPnlOpcionesPokemon.setBackground(new java.awt.Color(204, 204, 255));
        jPnlOpcionesPokemon.setLayout(new java.awt.GridLayout(1, 2, 5, 5));
        getContentPane().add(jPnlOpcionesPokemon);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refrescarJpnlOpcionesPokemon( ){
        
        jPnlOpcionesPokemon.removeAll();
        jPnlOpcionesPokemon.setBackground(new java.awt.Color(204, 204, 255));
        jPnlOpcionesPokemon.setLayout(new java.awt.GridLayout(filas, columnas, 5, 5));
        
        for (int i = 0; i < pokemones.length; i++) {
           
            if (pokemones[i] != null) {
                
                jPnlOpcionesPokemon.add(pokemones[i]);
            }
        }
        
        jPnlOpcionesPokemon.repaint();
        jPnlOpcionesPokemon.revalidate();
    }
    
    private void agregarListener(Pokemon pokemon){
        
        pokemon.addMouseListener(new java.awt.event.MouseAdapter() {
           
           @Override
           public void mouseClicked (java.awt.event.MouseEvent evt){
               //código ¿Que sucede cuando le doy click?
               if ( contElegidos < maximo ) {
                   
                   pokemonesElegidos[contElegidos] = pokemon;
                   //System.out.println("indice llenado "+lugar+" con "+pokemon.getNombre());
                   pokemon.setVisible(false);
                   contElegidos ++;
                   refrescarJpnlOpcionesPokemon();
                   if ( contElegidos == maximo) {
                        setearVisible();
                   }
               }
           }
       }); 
    }
    
    private void setearVisible(){
        
        for (int i = 0; i < pokemones.length; i++) {
             pokemones[i].setVisible(true);
            
        }
        super.setVisible(false);
    }
    
    private void iniciarMenu( ){
        
        this.setSize(ancho, altura);
        this.setTitle(instrucciones);
        jPnlOpcionesPokemon.setSize(ancho,altura);
        jPnlOpcionesPokemon.setPreferredSize(new Dimension(ancho, altura));
        
        for (int i = 0; i < pokemones.length; i++) {
           agregarListener(pokemones[i]);
           pokemones[i].agregarImagenYMarco();
         }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPnlOpcionesPokemon;
    // End of variables declaration//GEN-END:variables
}
