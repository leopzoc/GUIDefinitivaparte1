package GestioneIO;

import java.io.*;

import Cinema.domain.*;

public class CreatoreFileUtenti {
    public static void CreatoreFile() {
        try {
            FileOutputStream streamUtenti = new FileOutputStream("UtentidelCinema.bin");
            ObjectOutputStream fileInizio = new ObjectOutputStream(streamUtenti);

            Persona a1 = new Persona("admin", "admin", Ruolo.AMMINISTRATORE);
            fileInizio.writeObject(a1);

            fileInizio.close();
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Errore di I/O: " + e.getMessage());
        }
    }


    public static void AggiungiUtente(String nome, String cognome) {
        try {
            boolean append = new File("UtentidelCinema.bin").exists();
            FileOutputStream streamUtenti = new FileOutputStream("UtentidelCinema.bin", true);
            ObjectOutputStream fileInizio = append ?
                    new AppendingObjectOutputStream(streamUtenti) :
                    new ObjectOutputStream(streamUtenti);

            Persona a1 = new Persona(nome, cognome, Ruolo.UTENTE);
            fileInizio.writeObject(a1);

            fileInizio.close();
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Errore di I/O: " + e.getMessage());
        }
    }


}



