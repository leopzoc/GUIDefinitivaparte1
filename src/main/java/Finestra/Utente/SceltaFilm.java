/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Finestra.Utente;

import java.awt.*;
import javax.swing.JButton;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 *
 * @author p_leonardo_c
 */
public class SceltaFilm extends javax.swing.JPanel {

    /**
     * Creates new form SceltaFilm
     */
    private List<JButton> botones;
    private int indiceSelezionato=-1;
    private JButton bottoneSelezionato = null;

    public int getIndiceSelezionato() {
        return indiceSelezionato;
    }

    public SceltaFilm() {
        initComponents();
        botones = new ArrayList<>();

        //size che ora è 6 dovra essere inizializzato dipendendo dal numero di film che avremo
        for(int i=0;i<6;i++) {
            AggiungiFilmBottone();
        }
        //adattare l'immagine ai bottoni in modo dinamico
        FilmPanel.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                aggiornaIconeBotoni();
            }
        });

    }





    private void AggiungiFilmBottone() {
        JButton boton = new JButton();
        botones.add(boton); // Aggiungi il bottone alla lista
        FilmPanel.add(boton);

        final int indice = botones.size() - 1; // Indice del bottone appena aggiunto
        boton.addActionListener(e -> {
            if (indiceSelezionato != -1) {
                // Resetta il bordo del bottone precedentemente selezionato
                botones.get(indiceSelezionato).setBorder(null);
                // Opzionale: riabilita il bottone precedentemente selezionato
                botones.get(indiceSelezionato).setEnabled(true);
            }
            // Imposta il bordo del bottone attualmente selezionato a rosso
            boton.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            indiceSelezionato = indice;

            // Disabilita tutti i bottoni tranne quello selezionato
            for (int i = 0; i < botones.size(); i++) {
                if (i != indiceSelezionato) {
                    botones.get(i).setEnabled(false);
                }
            }
        });

        // Altri settaggi del bottone...
    }
    
    //usato dalla pagina pricipale per annullare un op
    public void annullaSelezione() {
    if (indiceSelezionato != -1) {
        JButton bottonePrecedente = botones.get(indiceSelezionato);
        bottonePrecedente.setBorder(null);
        indiceSelezionato = -1;
    }

    for (JButton b : botones) {
        b.setEnabled(true);
    }
}



    //funzione che viene attivato dal evento aggiugni bottone(funzione anonima)
    private void aggiornaIconeBotoni() {
        for(int i = 0; i < botones.size(); i++) {
            JButton boton = botones.get(i);
            Dimension size = boton.getSize();
            if (size.width > 0 && size.height > 0) { // Assicurati che il bottone abbia dimensioni effettive
                String imagePath = "src/main/java/Immagini/" + i + ".png";
                ImageIcon icon = new ImageIcon(imagePath);
                Image image = icon.getImage();
                Image scaledImage = image.getScaledInstance(size.width, size.height, Image.SCALE_SMOOTH);
                boton.setIcon(new ImageIcon(scaledImage));
            }
        }
        FilmPanel.revalidate();
        FilmPanel.repaint();
    }









    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FilmPanel = new javax.swing.JPanel();

        setMinimumSize(new java.awt.Dimension(648, 267));
        setPreferredSize(new java.awt.Dimension(648, 267));
        setLayout(new java.awt.BorderLayout());

        FilmPanel.setBackground(new java.awt.Color(0, 0, 0));
        FilmPanel.setLayout(new java.awt.GridLayout(0, 3, 10, 10));
        add(FilmPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void BAnullaActionPerformed(java.awt.event.ActionEvent evt) {
        // Se un bottone è stato selezionato
        if (indiceSelezionato != -1) {
            // Resetta il bordo del bottone selezionato a nessuno
            JButton bottonePrecedente = botones.get(indiceSelezionato);
            bottonePrecedente.setBorder(null); // Rimuove il bordo rosso

            // Resetta l'indice selezionato a nessuna selezione
            indiceSelezionato = -1;
        }

        // Riabilita tutti i bottoni per permettere nuove selezioni
        for (JButton b : botones) {
            b.setEnabled(true);
        }

        // Opzionale: Potresti voler aggiornare l'interfaccia utente o eseguire altre azioni
        // dopo aver annullato la selezione
    }                                       


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FilmPanel;
    // End of variables declaration//GEN-END:variables
}
