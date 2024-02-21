package GestioneIO;

import Cinema.cinema_infrastructure.Sala;
import Cinema.domain.Persona;
import Cinema.domain.Ruolo;

import javax.swing.*;
import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Map;
import Cinema.cinema_infrastructure.Sala;
public class LetturaSala {
  /*  public static boolean esistenzaFile() {
        File file = new File("Sale.bin");
        if (!file.exists()) {
            IoGestoreSala.CreatoreFile();
            return false;
        }
        return true;
    }

    public static Map RitornaSala(String nome, String cognome) {
        try (FileInputStream file = new FileInputStream("Sale.bin");
             ObjectInputStream lettura = new ObjectInputStream(file)) {

            while (true) {
                try {
                    Map<Integer,Sala> sala = (Map<Integer, Sala>) lettura.readObject();
                    if (sala.getNome().equals(nome) && chisei.getCognome().equals(cognome)) {
                        return chisei;
                    }
                } catch (EOFException e) {
                    break; // Uscita dal ciclo alla fine del file
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File non trovato: " + e);
            JOptionPane.showMessageDialog(null, "File degli utenti non trovato.");
        } catch (EOFException e) {
            // Questa eccezione potrebbe non essere necessaria qui a causa del catch interno
            System.err.println("Raggiunta la fine del file senza trovare l'utente: " + e);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Errore durante la lettura del file: " + e);
        }

        JOptionPane.showMessageDialog(null, "UTENTE NON TROVATO");
        return null;
    }

   */
}
