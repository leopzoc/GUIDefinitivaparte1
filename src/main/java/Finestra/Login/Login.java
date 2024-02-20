/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Finestra.Login;

import Finestra.Amministratore.GUIadmin;
import Finestra.Utente.FinestraUtente;
import GestioneIO.LetturaUtenti;

import javax.swing.*;

/**
 *
 * @author p_leonardo_c
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelloLogin = new javax.swing.JPanel();
        LoginB2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LoginB1 = new javax.swing.JButton();
        Cognomefild = new javax.swing.JTextField();
        NomeFild = new javax.swing.JTextField();
        LogoCinema = new javax.swing.JLabel();
        Statico1 = new javax.swing.JLabel();
        RegistratiButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1200, 720));
        setMinimumSize(new java.awt.Dimension(1200, 720));
        setPreferredSize(new java.awt.Dimension(1200, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelloLogin.setMaximumSize(new java.awt.Dimension(1200, 720));
        PanelloLogin.setMinimumSize(new java.awt.Dimension(1200, 720));
        PanelloLogin.setPreferredSize(new java.awt.Dimension(1200, 720));
        PanelloLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LoginB2.setBackground(new java.awt.Color(0, 153, 153));
        LoginB2.setFont(new java.awt.Font("Fira Sans", 1, 18)); // NOI18N
        LoginB2.setForeground(new java.awt.Color(255, 255, 255));
        LoginB2.setText("REGISTRATI!");
        LoginB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginB2ActionPerformed(evt);
            }
        });
        PanelloLogin.add(LoginB2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 310, 220, 60));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Fira Sans Compressed SemiBold", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cognome");
        PanelloLogin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 300, 40));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Fira Sans Compressed SemiBold", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nome");
        PanelloLogin.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 300, 40));

        LoginB1.setBackground(new java.awt.Color(0, 153, 153));
        LoginB1.setForeground(new java.awt.Color(255, 255, 255));
        LoginB1.setText("Login");
        LoginB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginB1ActionPerformed(evt);
            }
        });
        PanelloLogin.add(LoginB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, 220, 60));

        Cognomefild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CognomefildActionPerformed(evt);
            }
        });
        PanelloLogin.add(Cognomefild, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 220, -1));

        NomeFild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeFildActionPerformed(evt);
            }
        });
        PanelloLogin.add(NomeFild, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 220, -1));

        LogoCinema.setIcon(new javax.swing.ImageIcon("/home/p_leonardo_c/Scrivania/odio/FULMINES.png")); // NOI18N
        PanelloLogin.add(LogoCinema, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 720, 510));

        Statico1.setFont(new java.awt.Font("Fira Sans Condensed Heavy", 3, 36)); // NOI18N
        Statico1.setForeground(new java.awt.Color(204, 0, 0));
        Statico1.setText("NON HAI UN ACCOUNT?");
        PanelloLogin.add(Statico1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 200, 390, 100));

        RegistratiButton.setIcon(new javax.swing.ImageIcon("/home/p_leonardo_c/Scrivania/odio/cinema.jpg")); // NOI18N
        RegistratiButton.setPreferredSize(new java.awt.Dimension(1200, 650));
        PanelloLogin.add(RegistratiButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 720));

        getContentPane().add(PanelloLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -6, 1200, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginB1ActionPerformed(java.awt.event.ActionEvent evt) {



        if(LetturaUtenti.esistenzaFile()){
            JOptionPane.showMessageDialog(null,"registrati!");
        }

        // Verifica le credenziali dell'utente
        // Questo è un esempio, dovrai implementare la logica di verifica delle credenziali
        boolean isAuthenticated = true; // Assumiamo che l'utente sia autenticato per l'esempio
        boolean AdminAutenicate = true;
        if (isAuthenticated || AdminAutenicate) {
            // Chiudi il JFrame Login
            this.dispose();

            // Apri il JFrame FinestraUtente
            if(isAuthenticated) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new FinestraUtente().setVisible(true);
                    }
                });
            }
            else if(AdminAutenicate){
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new GUIadmin().setVisible(true);
                    }
                });
            }
        } else {
            // Mostra un messaggio di errore se le credenziali non sono corrette
            JOptionPane.showMessageDialog(this, "Username o Password errati.", "Errore di accesso", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void LoginB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginB2ActionPerformed
        // TODO add your handling code here:
        
        REGISTRAZIONE reg = new REGISTRAZIONE(this,true);
        reg.setVisible(true);
        
    }//GEN-LAST:event_LoginB2ActionPerformed

    private void CognomefildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CognomefildActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CognomefildActionPerformed

    private void NomeFildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeFildActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeFildActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cognomefild;
    private javax.swing.JButton LoginB1;
    private javax.swing.JButton LoginB2;
    private javax.swing.JLabel LogoCinema;
    private javax.swing.JTextField NomeFild;
    private javax.swing.JPanel PanelloLogin;
    private javax.swing.JLabel RegistratiButton;
    private javax.swing.JLabel Statico1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}