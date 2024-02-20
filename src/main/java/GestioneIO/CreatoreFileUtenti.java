package GestioneIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import Cinema.domain.*;

public class CreatoreFileUtenti {
    public static void CreatoreFile() {
        try {
            FileOutputStream streamUtenti = new FileOutputStream("UtentidelCinema.bin");
            ObjectOutputStream fileInizio = new ObjectOutputStream(streamUtenti);

            Persona a1 = new Amministratore("admin", "admin", Ruolo.AMMINISTRATORE);
            fileInizio.writeObject(a1);

            fileInizio.close();
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Errore di I/O: " + e.getMessage());
        }
    }
}
