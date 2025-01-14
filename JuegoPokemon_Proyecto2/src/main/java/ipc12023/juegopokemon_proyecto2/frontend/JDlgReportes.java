/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ipc12023.juegopokemon_proyecto2.frontend;

import ipc12023.juegopokemon_proyecto2.backend.Jugador;

/**
 *
 * @author Personal
 */
public class JDlgReportes extends javax.swing.JDialog {

    /**
     * Creates new form JDlgReportes
     */
    public JDlgReportes(java.awt.Frame parent, boolean modal, Jugador jugador) {
        super(parent, modal);
        initComponents();
        jLblNombreJugador.setText(jugador.getNombre());
        jLblNoBatallas.setText(jugador.getReportes()[Jugador.VECES_BATALLA]);
        jLblNoCatchballs.setText(jugador.getReportes()[Jugador.VECES_CATCHBALL]);
        jLblNoMiniJuego.setText(jugador.getReportes()[Jugador.VECES_MINIJUEGO]);
        this.setLocation(300, 300);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnlContenido = new javax.swing.JPanel();
        jLblNombreJugador = new javax.swing.JLabel();
        jLblTxElJugador = new javax.swing.JLabel();
        jLblTxBatalla = new javax.swing.JLabel();
        jLblNoBatallas = new javax.swing.JLabel();
        jLblTxbatalla = new javax.swing.JLabel();
        jLblTxCatcballgastadas = new javax.swing.JLabel();
        jLblNoCatchballs = new javax.swing.JLabel();
        jLblTxCatchball = new javax.swing.JLabel();
        jLblTxVecesMiniJuego = new javax.swing.JLabel();
        jLblNoMiniJuego = new javax.swing.JLabel();
        jLblTxMiniJuego = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REPORTES");
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        jPnlContenido.setBackground(new java.awt.Color(204, 204, 255));

        jLblNombreJugador.setForeground(new java.awt.Color(0, 0, 0));
        jLblNombreJugador.setText("nombre");

        jLblTxElJugador.setForeground(new java.awt.Color(0, 0, 0));
        jLblTxElJugador.setText("El jugador");

        jLblTxBatalla.setForeground(new java.awt.Color(0, 0, 0));
        jLblTxBatalla.setText("Ha participado en un total de: ");

        jLblNoBatallas.setForeground(new java.awt.Color(0, 0, 0));
        jLblNoBatallas.setText("000");

        jLblTxbatalla.setForeground(new java.awt.Color(0, 0, 0));
        jLblTxbatalla.setText("batallas");

        jLblTxCatcballgastadas.setForeground(new java.awt.Color(0, 0, 0));
        jLblTxCatcballgastadas.setText("Has gastado un total de: ");

        jLblNoCatchballs.setForeground(new java.awt.Color(0, 0, 0));
        jLblNoCatchballs.setText("000");

        jLblTxCatchball.setForeground(new java.awt.Color(0, 0, 0));
        jLblTxCatchball.setText("catchballs");

        jLblTxVecesMiniJuego.setForeground(new java.awt.Color(0, 0, 0));
        jLblTxVecesMiniJuego.setText("Ha jugado un total de  ");

        jLblNoMiniJuego.setForeground(new java.awt.Color(0, 0, 0));
        jLblNoMiniJuego.setText("000");

        jLblTxMiniJuego.setForeground(new java.awt.Color(0, 0, 0));
        jLblTxMiniJuego.setText("veces el mini juego");

        javax.swing.GroupLayout jPnlContenidoLayout = new javax.swing.GroupLayout(jPnlContenido);
        jPnlContenido.setLayout(jPnlContenidoLayout);
        jPnlContenidoLayout.setHorizontalGroup(
            jPnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlContenidoLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnlContenidoLayout.createSequentialGroup()
                        .addComponent(jLblTxVecesMiniJuego)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLblNoMiniJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLblTxMiniJuego)
                        .addGap(0, 27, Short.MAX_VALUE))
                    .addGroup(jPnlContenidoLayout.createSequentialGroup()
                        .addGroup(jPnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPnlContenidoLayout.createSequentialGroup()
                                .addComponent(jLblTxBatalla)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLblNoBatallas, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLblTxbatalla))
                            .addGroup(jPnlContenidoLayout.createSequentialGroup()
                                .addComponent(jLblTxElJugador)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLblNombreJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPnlContenidoLayout.createSequentialGroup()
                                .addComponent(jLblTxCatcballgastadas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLblNoCatchballs, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLblTxCatchball)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPnlContenidoLayout.setVerticalGroup(
            jPnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlContenidoLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblNombreJugador)
                    .addComponent(jLblTxElJugador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblTxBatalla, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblNoBatallas)
                    .addComponent(jLblTxbatalla, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblNoCatchballs)
                    .addComponent(jLblTxCatcballgastadas, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblTxCatchball, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblTxVecesMiniJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblNoMiniJuego)
                    .addComponent(jLblTxMiniJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPnlContenido);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLblNoBatallas;
    private javax.swing.JLabel jLblNoCatchballs;
    private javax.swing.JLabel jLblNoMiniJuego;
    private javax.swing.JLabel jLblNombreJugador;
    private javax.swing.JLabel jLblTxBatalla;
    private javax.swing.JLabel jLblTxCatcballgastadas;
    private javax.swing.JLabel jLblTxCatchball;
    private javax.swing.JLabel jLblTxElJugador;
    private javax.swing.JLabel jLblTxMiniJuego;
    private javax.swing.JLabel jLblTxVecesMiniJuego;
    private javax.swing.JLabel jLblTxbatalla;
    private javax.swing.JPanel jPnlContenido;
    // End of variables declaration//GEN-END:variables
}
