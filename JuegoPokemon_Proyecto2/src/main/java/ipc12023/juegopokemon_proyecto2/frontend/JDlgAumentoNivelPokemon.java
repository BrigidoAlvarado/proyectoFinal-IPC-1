/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ipc12023.juegopokemon_proyecto2.frontend;

import ipc12023.juegopokemon_proyecto2.frontend.pokemon.Pokemon;

/**
 *
 * @author Personal
 */
public class JDlgAumentoNivelPokemon extends javax.swing.JDialog {

    Pokemon pokemon;
    /**
     * Creates new form JDlgAumentoNivelPokemon
     */
    public JDlgAumentoNivelPokemon(java.awt.Frame parent, boolean modal, Pokemon pokemon) {
        super(parent, modal);
        this.pokemon = pokemon;
        initComponents();
        cambiarComponentes();
        super.setLocation(500, 200);
    }

    private void cambiarComponentes(){
        
        pokemon.agregarImagenYMarco();
        jLblTextoHaSubidodeNivel.setText(pokemon.getNombre());
        jLblNivel.setText(String.valueOf(pokemon.getNivel()));
        jLblVida.setText(String.valueOf(pokemon.getVidaBase()));
        jLblVidaActual.setText(String.valueOf(pokemon.getVida()));
        jLblAtaqueBasico.setText(String.valueOf(pokemon.getAtaqueBasico()));
        jLblDefenzaBasica.setText(String.valueOf(pokemon.getDefenzaBasica()));
        jPnlPokemon.add(pokemon);
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnlDatos = new javax.swing.JPanel();
        jLblTextoHaSubidodeNivel = new javax.swing.JLabel();
        jLblTextoNivel = new javax.swing.JLabel();
        jLblNivel = new javax.swing.JLabel();
        jLblTextoVida = new javax.swing.JLabel();
        jLblVida = new javax.swing.JLabel();
        jLblTextoVidaActual = new javax.swing.JLabel();
        jLblVidaActual = new javax.swing.JLabel();
        jLblTextoAtaqueBasico = new javax.swing.JLabel();
        jLblAtaqueBasico = new javax.swing.JLabel();
        jLblTextoDefenzaBasica = new javax.swing.JLabel();
        jLblDefenzaBasica = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLblPokemon1 = new javax.swing.JLabel();
        jPnlPokemon = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Aumento de Nivel");
        setSize(new java.awt.Dimension(420, 220));
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPnlDatos.setBackground(new java.awt.Color(204, 204, 255));
        jPnlDatos.setForeground(new java.awt.Color(0, 0, 0));
        jPnlDatos.setPreferredSize(new java.awt.Dimension(200, 200));

        jLblTextoHaSubidodeNivel.setForeground(new java.awt.Color(0, 0, 0));
        jLblTextoHaSubidodeNivel.setText("ha subido de nivel");

        jLblTextoNivel.setForeground(new java.awt.Color(0, 0, 0));
        jLblTextoNivel.setText("Nivel:");

        jLblNivel.setForeground(new java.awt.Color(0, 0, 0));
        jLblNivel.setText("00");

        jLblTextoVida.setForeground(new java.awt.Color(0, 0, 0));
        jLblTextoVida.setText("Vida:");

        jLblVida.setForeground(new java.awt.Color(0, 0, 0));
        jLblVida.setText("000.00");

        jLblTextoVidaActual.setForeground(new java.awt.Color(0, 0, 0));
        jLblTextoVidaActual.setText("VidaActual");

        jLblVidaActual.setForeground(new java.awt.Color(0, 0, 0));
        jLblVidaActual.setText("000.00");

        jLblTextoAtaqueBasico.setForeground(new java.awt.Color(0, 0, 0));
        jLblTextoAtaqueBasico.setText("Ataque Básico");

        jLblAtaqueBasico.setForeground(new java.awt.Color(0, 0, 0));
        jLblAtaqueBasico.setText("000.00");

        jLblTextoDefenzaBasica.setForeground(new java.awt.Color(0, 0, 0));
        jLblTextoDefenzaBasica.setText("Defenza Básica");

        jLblDefenzaBasica.setForeground(new java.awt.Color(0, 0, 0));
        jLblDefenzaBasica.setText("000.00");

        jButton1.setBackground(new java.awt.Color(255, 153, 0));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLblPokemon1.setForeground(new java.awt.Color(0, 0, 0));
        jLblPokemon1.setText("Pokemon");

        javax.swing.GroupLayout jPnlDatosLayout = new javax.swing.GroupLayout(jPnlDatos);
        jPnlDatos.setLayout(jPnlDatosLayout);
        jPnlDatosLayout.setHorizontalGroup(
            jPnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlDatosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLblPokemon1)
                .addGap(7, 7, 7)
                .addComponent(jLblTextoHaSubidodeNivel))
            .addGroup(jPnlDatosLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLblTextoNivel)
                .addGap(39, 39, 39)
                .addComponent(jLblNivel))
            .addGroup(jPnlDatosLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLblTextoVida)
                .addGap(43, 43, 43)
                .addComponent(jLblVida))
            .addGroup(jPnlDatosLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLblTextoVidaActual)
                .addGap(13, 13, 13)
                .addComponent(jLblVidaActual))
            .addGroup(jPnlDatosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLblTextoAtaqueBasico)
                .addGap(21, 21, 21)
                .addComponent(jLblAtaqueBasico))
            .addGroup(jPnlDatosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLblTextoDefenzaBasica)
                .addGap(14, 14, 14)
                .addComponent(jLblDefenzaBasica))
            .addGroup(jPnlDatosLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jButton1))
        );
        jPnlDatosLayout.setVerticalGroup(
            jPnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlDatosLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblPokemon1)
                    .addComponent(jLblTextoHaSubidodeNivel))
                .addGap(13, 13, 13)
                .addGroup(jPnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblTextoNivel)
                    .addGroup(jPnlDatosLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLblNivel)))
                .addGap(4, 4, 4)
                .addGroup(jPnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblTextoVida)
                    .addComponent(jLblVida))
                .addGap(4, 4, 4)
                .addGroup(jPnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblTextoVidaActual)
                    .addGroup(jPnlDatosLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLblVidaActual)))
                .addGap(11, 11, 11)
                .addGroup(jPnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblTextoAtaqueBasico)
                    .addComponent(jLblAtaqueBasico))
                .addGap(4, 4, 4)
                .addGroup(jPnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblTextoDefenzaBasica)
                    .addComponent(jLblDefenzaBasica))
                .addGap(9, 9, 9)
                .addComponent(jButton1))
        );

        getContentPane().add(jPnlDatos);

        jPnlPokemon.setBackground(new java.awt.Color(204, 204, 255));
        jPnlPokemon.setPreferredSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout jPnlPokemonLayout = new javax.swing.GroupLayout(jPnlPokemon);
        jPnlPokemon.setLayout(jPnlPokemonLayout);
        jPnlPokemonLayout.setHorizontalGroup(
            jPnlPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPnlPokemonLayout.setVerticalGroup(
            jPnlPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        getContentPane().add(jPnlPokemon);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        super.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLblAtaqueBasico;
    private javax.swing.JLabel jLblDefenzaBasica;
    private javax.swing.JLabel jLblNivel;
    private javax.swing.JLabel jLblPokemon1;
    private javax.swing.JLabel jLblTextoAtaqueBasico;
    private javax.swing.JLabel jLblTextoDefenzaBasica;
    private javax.swing.JLabel jLblTextoHaSubidodeNivel;
    private javax.swing.JLabel jLblTextoNivel;
    private javax.swing.JLabel jLblTextoVida;
    private javax.swing.JLabel jLblTextoVidaActual;
    private javax.swing.JLabel jLblVida;
    private javax.swing.JLabel jLblVidaActual;
    private javax.swing.JPanel jPnlDatos;
    private javax.swing.JPanel jPnlPokemon;
    // End of variables declaration//GEN-END:variables
}
