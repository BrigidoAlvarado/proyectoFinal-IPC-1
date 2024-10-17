/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipc12023.juegopokemon_proyecto2.frontend.pokemon;

import ipc12023.juegopokemon_proyecto2.backend.AdminJuego;
import ipc12023.juegopokemon_proyecto2.frontend.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Pokemon extends JLabel {
    
    private static final int NO_POKEMONES = 8;
    
    protected final static int DANIO_MIN = 50;
    protected final static int DANIO_MAX = 75;
    protected final static int DEFENZA_MIN = 25;
    protected final static int DEFENZA_MAX = 5;
    protected final static double SE = 1.6;
    protected final static double NE = 0.6;
    protected static double N = 1;
    protected static double DR = 0.4;
    
    protected int nivel = 1;
    protected double vidaBase;
    protected double vida;
    protected double dañoBasico;
    protected double dañoFinal;
    protected double defenzaBasica;
    protected double defenzaFinal;
    protected boolean debilitado = false;
    protected boolean aumentoNivel;
    protected String pathImagen;
    protected String tipo;
    protected String nombre;

    public abstract double calcularDañoPorSinergia(Pokemon oponente);
    
    public double calcularDañoAtaque(){

       int calc = AdminJuego.random(DANIO_MIN, DANIO_MAX);
      
       dañoFinal = dañoBasico*Double.valueOf(calc)/100;
       dañoFinal = AdminJuego.dosDecimales(dañoFinal);
       
       return dañoFinal;
   }

    public void setNivel(int nivel){
       
       this.nivel = nivel;
       //aumento de vida
       vidaBase += AdminJuego.random(15, 25);
       vida = vidaBase;
       //aumento dañoFinal
       dañoBasico += Double.valueOf(AdminJuego.random(5, 10));
       //aumento defenza
       defenzaBasica += Double.valueOf(AdminJuego.random(1, 5));
   }
    
    public int calcNivelPokemon(int nivelJugador){
        int nuevoNivel = 1;
        
        if (nivelJugador - 2 > 0) {
            
            nuevoNivel = AdminJuego.random(nivelJugador - 2, nivelJugador + 2);
        }
        else{
            nuevoNivel = AdminJuego.random(1, nivelJugador + 2);
        }
        
        return nuevoNivel;
    }
    
    public double defender(double dañoRecibido, JuegoPokemonApp ventana) {

        dañoRecibido -= defenzaFinal;

         if (dañoRecibido < 0) {
             dañoRecibido = 0;
         }

        dañoRecibido = AdminJuego.dosDecimales(dañoRecibido);

        vida -= dañoRecibido;
        vida = AdminJuego.dosDecimales(vida);
        calPokemonDebilitado();
        return dañoRecibido;

     }
   
    public double calcularDefenza(){
       
       int calc = AdminJuego.random(DEFENZA_MIN, DEFENZA_MAX);
       defenzaFinal = defenzaBasica * Double.valueOf(calc)/100;
       
       return defenzaFinal;
       
   }
    
    protected void calPokemonDebilitado(){
       
        if (vida <= 0) {
            vida = 0;
            debilitado = true;
        }
     }
    
    public void sanarPokemon (){
        vida = vidaBase;
        debilitado = false;
    }
    
    public double getVida() {
        vida = AdminJuego.dosDecimales(vida);
        return vida;
    }
    
    public int getNivel() {
        return nivel;
    }

    public String getTipo() {
        return tipo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getPath(){
        return pathImagen;
    }
    
    public void setVida(double vida) {
       
       if (vida > vidaBase) {
           
           vida = vidaBase;
       }
       else{
           
           this.vida = vida;
       }
    }
    
    public boolean isDebilitado() {
        return debilitado;
    }
    
    public void calcularNivel(JuegoPokemonApp ventana){
       
       if (dañoFinal >= nivel * 50) {
           //aumentar nivel
           nivel++;
           //aumento de vida
            double incremento = AdminJuego.random(15, 25);
            vidaBase += incremento;
            vidaBase = AdminJuego.dosDecimales(vidaBase);
            vida += incremento;
            vida = AdminJuego.dosDecimales(vida);
           //aumento daño
             dañoBasico+=Double.valueOf(AdminJuego.random(5, 10));
           //aumento defenza
             defenzaBasica += Double.valueOf(AdminJuego.random(1, 5));
             
             JDlgAumentoNivelPokemon mostrarAumento  = new JDlgAumentoNivelPokemon(ventana, true, this);
             mostrarAumento.setVisible(true);
       } 
   }
    
    public double getVidaBase(){
        return vidaBase;
    }
    
    public double getAtaqueBasico(){
        return dañoBasico;
    }
    
    public double  getDefenzaBasica(){
        return defenzaBasica;
    }
    
    public void agregarImagenYMarco (){
        String datos = nombre + "  VIDA: " + vida;
        setIcon(new ImageIcon(getClass().getResource(pathImagen)));
        this.setBorder(javax.swing.BorderFactory.createTitledBorder(datos));
    }
    
    public double getPorcentajeVida(){
        return AdminJuego.dosDecimales((vida / vidaBase) * (100));
    }
    
    public static Pokemon random(){
        int opcion = AdminJuego.random(0, (NO_POKEMONES - 1));
        
        switch (opcion) {
            case 0: return new Groudon();
            case 1: return new Garchomp();
            case 2: return new Reshiram();
            case 3: return new HoOh();
            case 4: return new Gyarados();
            case 5: return new Kyogre();
            case 6: return new Pikachu();
            case 7: return new Jolteon();
            default: return null;
        }
    }
    
    public static Pokemon[] pokemonesJuego(){
        Pokemon[] pokemonesJuego = {new Groudon(), new Garchomp(), new Gyarados(), new Pikachu(), new Kyogre(), new Jolteon(), new Reshiram(), new HoOh()};
        return pokemonesJuego;
    }
}


