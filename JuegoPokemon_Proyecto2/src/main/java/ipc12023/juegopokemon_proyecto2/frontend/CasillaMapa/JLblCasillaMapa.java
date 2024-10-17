
package ipc12023.juegopokemon_proyecto2.frontend.CasillaMapa;

import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class JLblCasillaMapa extends JLabel {
    
    protected String pathImagen;
    
    protected void agregarImagen (){
        setIcon(new ImageIcon(getClass().getResource(pathImagen)));
        
    }
}
