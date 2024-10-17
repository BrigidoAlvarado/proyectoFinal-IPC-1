
package ipc12023.juegopokemon_proyecto2.backend;

import ipc12023.juegopokemon_proyecto2.backend.articulosTienda.*;
import ipc12023.juegopokemon_proyecto2.backend.inventario.*;
import ipc12023.juegopokemon_proyecto2.frontend.pokemon.Pokemon;
import ipc12023.juegopokemon_proyecto2.frontend.*;
import ipc12023.juegopokemon_proyecto2.frontend.Batalla.JInternalFrameBatalla;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Jugador implements Serializable {

    private static final long serialVersionUID = 05022003202320L;
    private static final int ORO_INICIADOR = 50;
    public static final int VECES_BATALLA = 0;
    public static final int VECES_CATCHBALL = 1;
    public static final int VECES_MINIJUEGO = 2;
    
    private Inventario<PocionSuave> pocionesSuaves;
    private Inventario<PocionFuerte> pocionesFuertes;
    private Inventario<CatchballNormal> catchballsNomales;
    private Inventario<CatchballSemiprofesional> catchballsSemiprofesionales;
    private Inventario<CatchballProfesional> catchballsProfesionales;
    private InventarioPokemon inventarioPokemon;
    
    private Mapa mapa;
    private String nombre;
    private String contraseña;
    private int oro;
    private int nivel;
    private int vecesBatalla;
    private int vecesCatchball;
    private int vecesMiniJuego;

    public Jugador (String contraseña,String nombre, JuegoPokemonApp ventana) throws JuegoPokemonException{
        
        oro = ORO_INICIADOR;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.inventarioPokemon = new InventarioPokemon();
        this.pocionesSuaves = new Inventario<>("Pociones Suaves");
        this.pocionesFuertes = new Inventario<>("Pociones Fuertes");
        this.catchballsNomales = new Inventario<>("Catchballs normales");
        this.catchballsSemiprofesionales = new Inventario<>("Catchballs Semiprofesionales");
        this.catchballsProfesionales = new Inventario<>("Catchballs Profesionales");
        
        //this.mapa = new MapaModoHistoria(contraseña, ventana);
        ///AÑADIR PRIMEROS OBJETOS
        int cont = 0;
        while(cont != 10){
            catchballsNomales.agregar(new CatchballNormal());
            cont ++;
            if (cont == 10 ) {
                break;
            }
            catchballsSemiprofesionales.agregar(new CatchballSemiprofesional());
            cont ++;
            catchballsProfesionales.agregar(new CatchballProfesional());
            cont ++;
        }
        
        JDlgIniciarJugador menu = new JDlgIniciarJugador(ventana, true, this);
        menu.setVisible(true);
        Pokemon pokemon = menu.getPokemon();
         
        if (pokemon == null) {
             throw new JuegoPokemonException("Creacion de Pesonaje Cancelada");
         } else {
             this.añadirPokemon(pokemon, ventana);
         }
        
    }
    
    public void setMapa(Mapa mapa) throws JuegoPokemonException{
        this.mapa = mapa;
        actualizar();
    }
    
    public void vecesMiniJuego()throws JuegoPokemonException{
        vecesMiniJuego ++;
        actualizar();
    }
    
    public void vecesCatchball() throws JuegoPokemonException{
        vecesCatchball ++;
        actualizar();
    }
    
    public void vecesBatalla() throws JuegoPokemonException{
        vecesBatalla ++;
        actualizar();
    }
    
    public Mapa getMapaModoHistoria(){
        return mapa;
    }
    
    public String getNombre(){
        return nombre;
    }
     
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }
    
    public Pokemon[] getPokemonesDisponibles(){
        return inventarioPokemon.getPokemonesDisponibles();
    }
    
    public void actualizar() throws JuegoPokemonException{
      
        try {
           AdminJuego.guardar(this); 
        } catch (JuegoPokemonException e) {
           throw new JuegoPokemonException(e.getMessage()+" El juego se reinciciará");
        }
        
    }
    
    public int getNivel(){
        
        nivel = inventarioPokemon.calNivelJugador();
        return nivel;
    }
    
    public void usarObjeto(String articulo, Pokemon pokemonJugador, Pokemon pokemonOponente, JuegoPokemonApp ventana, JInternalFrameBatalla batalla)throws JuegoPokemonException{
        
        switch(articulo){
            
            case(CatchballNormal.NOMBRE):
                catchballsNomales.usarArticulo().usar(pokemonOponente, this, ventana, batalla);
                break;
            case(CatchballSemiprofesional.NOMBRE):
                catchballsSemiprofesionales.usarArticulo().usar(pokemonOponente, this, ventana, batalla);
                break;
            case(CatchballProfesional.NOMBRE):
                catchballsProfesionales.usarArticulo().usar(pokemonOponente, this, ventana, batalla);
                break;
            case(PocionSuave.NOMBRE):
                pocionesSuaves.usarArticulo().usar(pokemonJugador, this, ventana, batalla);
                break;
            case(PocionFuerte.NOMBRE):
                pocionesFuertes.usarArticulo().usar(pokemonJugador, this, ventana, batalla);
                break;
        }
        
    }
    
    public void gastarOro(int monto, JuegoPokemonApp ventana) throws JuegoPokemonException{
        
        if (monto > oro) {
            throw new JuegoPokemonException("No tienes suficiente oro para continuar");
        }
        else{
            oro -= monto;
            JOptionPane.showMessageDialog(ventana,"Se te ha cobrado "+ monto + " monedas, ahora tienes " + oro + " de oro " , "Actualización de ORO", JOptionPane.PLAIN_MESSAGE, new ImageIcon(getClass().getResource(ArticuloTienda.PATH_ORO)));
            actualizar();
        }
    }
    
    public void ganarOro(int oro, JuegoPokemonApp ventana) throws JuegoPokemonException{
        
        this.oro += oro;
        JOptionPane.showMessageDialog(ventana, "Has ganado: "+oro+" de oro, ahora tienes un total de: "+this.oro+" de oro", "Actualización de ORO", JOptionPane.PLAIN_MESSAGE, new ImageIcon(getClass().getResource(ArticuloTienda.PATH_ORO)));
        actualizar();
    }
   
    public void añadirPokemon(Pokemon nuevo, JuegoPokemonApp ventana)throws JuegoPokemonException{
        
        inventarioPokemon.añadirPokemon(nuevo, ventana);
    }
    
    public Pokemon[] getPokemonesHeridos (){
        return inventarioPokemon.getPokemonesHeridos();
    }
    
    public void añadirAInventario(ArticuloTienda articulo) throws JuegoPokemonException{
        
        if (articulo instanceof CatchballNormal) {
            catchballsNomales.agregar(((CatchballNormal)articulo));
        }
        if (articulo instanceof CatchballSemiprofesional) {
            catchballsSemiprofesionales.agregar(((CatchballSemiprofesional)articulo));
        }
        if(articulo instanceof CatchballProfesional){
            catchballsProfesionales.agregar(((CatchballProfesional)articulo));
        }
        if (articulo instanceof PocionSuave) {
            pocionesSuaves.agregar(((PocionSuave)articulo));
        }
        if (articulo instanceof PocionFuerte) {
            pocionesFuertes.agregar(((PocionFuerte)articulo));
        }
        actualizar();
        
    }
    
    public Pokemon[] getPokemones(){
        return inventarioPokemon.getPokemones();
    }
    
    public int getPocionesSuavesDisponibles(){
        return pocionesSuaves.getSize();
    }
    
    public int getPocionesFuertesDisponibles(){
        return pocionesFuertes.getSize();
    }
    
    public int getCatchballlsNormalesDisponibles(){
        return catchballsNomales.getSize();
    }
    
    public int getCatchballlsSemiprofesionalesDisponibles(){
        return catchballsSemiprofesionales.getSize();
    }
    
    public int getCatchballlsProfesionalesDisponibles(){
        return catchballsProfesionales.getSize();
    }
    
    public String[] getReportes(){
        String[] reportes ={String.valueOf(vecesBatalla),String.valueOf(vecesCatchball),String.valueOf(vecesMiniJuego)};
        return reportes;
    }
}
