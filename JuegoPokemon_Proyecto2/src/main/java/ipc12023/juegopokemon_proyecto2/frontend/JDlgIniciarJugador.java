
package ipc12023.juegopokemon_proyecto2.frontend;

import ipc12023.juegopokemon_proyecto2.frontend.pokemon.Pokemon;
import ipc12023.juegopokemon_proyecto2.backend.*;
import java.awt.Frame;
/**
 *
 * @author Personal
 */
public class JDlgIniciarJugador extends javax.swing.JDialog {
    
    private Pokemon pokemon;
    private Jugador jugador;
    private Frame parent;
    
    /**
     * Creates new form JDlgIniciarJugador
     */
    public JDlgIniciarJugador(java.awt.Frame parent, boolean modal, Jugador jugador) {
        super(parent, modal);
        this.parent = parent;
        this.jugador = jugador;
        initComponents();
        super.setLocation(500, 150);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLblTitulo = new javax.swing.JLabel();
        jLblCatchballNormal = new javax.swing.JLabel();
        jLblCatchballSemiprofesional = new javax.swing.JLabel();
        jLblCathballProfesional = new javax.swing.JLabel();
        jLblOro = new javax.swing.JLabel();
        jLblEscogerPokemon = new javax.swing.JLabel();
        jSpltPnElegirPokemon = new javax.swing.JSplitPane();
        jButtonEscoger = new javax.swing.JButton();
        jButtonRandom = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));

        jLblTitulo.setText("Se te ha añadido");

        jLblCatchballNormal.setText("4 Catchball Normales");

        jLblCatchballSemiprofesional.setText("3 Catchball Semiprofesionales");

        jLblCathballProfesional.setText("3 Catchball Profesionales");

        jLblOro.setText("50 de oro");

        jLblEscogerPokemon.setText("Elige como quieres seleccionar tu primer pokemon");

        jButtonEscoger.setBackground(new java.awt.Color(255, 153, 0));
        jButtonEscoger.setForeground(new java.awt.Color(0, 0, 0));
        jButtonEscoger.setText("Escoger");
        jButtonEscoger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEscogerActionPerformed(evt);
            }
        });
        jSpltPnElegirPokemon.setLeftComponent(jButtonEscoger);

        jButtonRandom.setBackground(new java.awt.Color(255, 153, 0));
        jButtonRandom.setForeground(new java.awt.Color(0, 0, 0));
        jButtonRandom.setText("Random");
        jButtonRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRandomActionPerformed(evt);
            }
        });
        jSpltPnElegirPokemon.setRightComponent(jButtonRandom);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblCatchballSemiprofesional)
                    .addComponent(jLblCathballProfesional)
                    .addComponent(jLblOro)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLblTitulo)
                        .addComponent(jLblCatchballNormal)))
                .addGap(99, 99, 99))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLblEscogerPokemon)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSpltPnElegirPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLblOro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLblCatchballNormal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblCatchballSemiprofesional)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLblCathballProfesional)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLblEscogerPokemon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSpltPnElegirPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEscogerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEscogerActionPerformed
        
        JDlgMenuPokemon menu = new JDlgMenuPokemon(parent, true, Pokemon.pokemonesJuego(), 1, "Selecciona un pokemon para tu inventario", 3, 3);
        menu.setVisible(true);
        pokemon = menu.getPokemonesElegidos()[0];
        this.setVisible(false);
       
    }//GEN-LAST:event_jButtonEscogerActionPerformed

    private void jButtonRandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRandomActionPerformed
        pokemon = Pokemon.random();
        this.setVisible(false);
    }//GEN-LAST:event_jButtonRandomActionPerformed

    
    public Pokemon getPokemon(){
        return pokemon;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEscoger;
    private javax.swing.JButton jButtonRandom;
    private javax.swing.JLabel jLblCatchballNormal;
    private javax.swing.JLabel jLblCatchballSemiprofesional;
    private javax.swing.JLabel jLblCathballProfesional;
    private javax.swing.JLabel jLblEscogerPokemon;
    private javax.swing.JLabel jLblOro;
    private javax.swing.JLabel jLblTitulo;
    private javax.swing.JSplitPane jSpltPnElegirPokemon;
    // End of variables declaration//GEN-END:variables
}