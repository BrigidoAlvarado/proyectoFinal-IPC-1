
package ipc12023.juegopokemon_proyecto2.backend;

import java.io.File;
import ipc12023.juegopokemon_proyecto2.backend.JuegoPokemonException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AdminJuego {
    
    private static final String PATH_PRINCIPAL = "jugadores";
    public static final String PATH_ORO = "/icons/oro.png";
    public static final int COLUMNA = 0;
    public static final int FILA = 1;
            
    public static int random(int limInferior,int limSuperior){
        
        limSuperior++;
        int diferencia=limSuperior-limInferior;
        int resultado= (int) (Math.random()*diferencia+limInferior);

        return resultado;
  }

    public static boolean probabilidad  (int porcentaje){
        
        int numeroRandom = random(0,100);
        return (numeroRandom <= porcentaje); 

    }
    
    public static double dosDecimales(double decimal){
       return Math.round(decimal*100.0)/100.0;
   }
     
    public static void guardar( Jugador jugador) throws JuegoPokemonException{
        
        File archivoJugador = new File(PATH_PRINCIPAL + File.separatorChar + jugador.getContraseña());
        
        try ( FileOutputStream fileOutputStream = new FileOutputStream(archivoJugador);
              ObjectOutputStream binarioJugador = new ObjectOutputStream(fileOutputStream);
        ){
            binarioJugador.writeObject(jugador);
            
        } catch (IOException e) {
            e.printStackTrace();
            throw new JuegoPokemonException("Error al guardar los datos del jugador");
            
        }
    }
    
    public static Jugador cargar( String contraseña) throws JuegoPokemonException{
        
        File archivoJugador = new File(PATH_PRINCIPAL + File.separatorChar + contraseña);
        
        try ( FileInputStream fileInput = new FileInputStream(archivoJugador);
              ObjectInputStream binarioJugador = new ObjectInputStream(fileInput);
                ){
            
            Jugador jugador = (Jugador) binarioJugador.readObject();
            
            return jugador;
            
        } catch(IOException | ClassNotFoundException e) {
        
            throw new JuegoPokemonException("Error al cargar los datos del jugador");
            
        }
    }
    
    public static  void inicarCarpetaYValidarContraseña (String contraseña) throws JuegoPokemonException{
        
        File carpetaJugadores = new File(PATH_PRINCIPAL);
        
        if (!carpetaJugadores.exists()) {
            
            carpetaJugadores.mkdir();
        }
        
        File archivoJugador = new File (PATH_PRINCIPAL + File.separatorChar + contraseña); 
        
        if (archivoJugador.exists()) {
            
            throw new JuegoPokemonException("Contraseña inválida porfavor intente con otra contraseña");
        }
    }
    
    public static void eliminarJugador(String contraseña){
        
        File archivoJugador = new File(PATH_PRINCIPAL + File.pathSeparatorChar + contraseña);
        archivoJugador.deleteOnExit();
    }
    
    public static int[] tamañoMenu(int tamaño){
        int columnas = 1, filas = 1;
        
        switch (tamaño) {
            case 1:
                columnas = filas = 1;
                break;
            case 2:
                columnas = 1;
                filas = 2;
                break;
            case 3:
                columnas = filas = 2;
                break;
            case 4:
                columnas = filas = 2;
                break;
            case 5:
                columnas = 2;
                filas = 3;
                break;
        }
        int[] size = {columnas, filas};
        return size;
    }
    
}

 