package GestioneIO;

import Cinema.domain.Persona;
import Cinema.domain.Ruolo;

import javax.swing.*;
import java.io.*;

public class LetturaUtenti {
    public static boolean esistenzaFile() {
        File file = new File("UtentidelCinema.bin");
        if (!file.exists()) {
            CreatoreFileUtenti.CreatoreFile();
            return false;
        }
        return true;
    }

    public static Persona RitornaPersona(String nome, String cognome) {
        try (FileInputStream file = new FileInputStream("UtentidelCinema.bin");
             ObjectInputStream lettura = new ObjectInputStream(file)) {

            while (true) {
                try {
                    Persona chisei = (Persona) lettura.readObject();
                    if (chisei.getNome().equals(nome) && chisei.getCognome().equals(cognome)) {
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
}
