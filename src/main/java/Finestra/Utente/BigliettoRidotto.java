/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Finestra.Utente;

import Finestra.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author p_leonardo_c
 */
public class BigliettoRidotto extends javax.swing.JPanel {

    /**
     * Creates new form BigliettoIntero
     */

    private Font barcodeFont = null;

    public BigliettoRidotto() {
        try {
    barcodeFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/java/FontProgetto/code128.ttf")).deriveFont(48f); // Dimensione font più grande
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    ge.registerFont(barcodeFont);
} catch (IOException|FontFormatException e) {
    e.printStackTrace();
}

        initComponents();
        CodiceFilm.setFont(barcodeFont.deriveFont(100f));
        CodiceFilm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);




    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        FilmNome = new javax.swing.JLabel();
        StaticoTitolo = new javax.swing.JLabel();
        CodiceFilm = new javax.swing.JLabel();
        Nome = new javax.swing.JLabel();
        Cognome = new javax.swing.JLabel();
        Sala = new javax.swing.JLabel();
        Orario = new javax.swing.JLabel();
        fotoCinema = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setBackground(new java.awt.Color(0, 255, 0));
        setMaximumSize(new java.awt.Dimension(341, 541));
        setMinimumSize(new java.awt.Dimension(341, 541));
        setPreferredSize(new java.awt.Dimension(341, 541));

        FilmNome.setFont(new java.awt.Font("Fira Sans", 0, 36)); // NOI18N
        FilmNome.setText("FILM");
        FilmNome.setToolTipText("");
        FilmNome.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        StaticoTitolo.setFont(new java.awt.Font("Fira Sans Condensed ExtraBold", 1, 18)); // NOI18N
        StaticoTitolo.setText("BIGLIETTO RIDOTTO PER LO SPETTACOLO");

        CodiceFilm.setFont(barcodeFont);
        CodiceFilm.setText("prova 1");

        Nome.setText("Nome");

        Cognome.setText("Cognome");

        Sala.setText("SALA");

        Orario.setText("Orario");

        fotoCinema.setIcon(new javax.swing.ImageIcon("/home/p_leonardo_c/Scrivania/odio/FULMINESLogo.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(FilmNome, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(fotoCinema, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Cognome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(130, 130, 130)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Orario)
                            .addComponent(Sala))
                        .addGap(54, 54, 54))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CodiceFilm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(StaticoTitolo)
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(StaticoTitolo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(FilmNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CodiceFilm, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(fotoCinema, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sala))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cognome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Orario))
                .addGap(79, 79, 79))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CodiceFilm;
    private javax.swing.JLabel Cognome;
    private javax.swing.JLabel FilmNome;
    private javax.swing.JLabel Nome;
    private javax.swing.JLabel Orario;
    private javax.swing.JLabel Sala;
    private javax.swing.JLabel StaticoTitolo;
    private javax.swing.JLabel fotoCinema;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
