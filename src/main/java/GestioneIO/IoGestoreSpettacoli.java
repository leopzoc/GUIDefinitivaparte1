package GestioneIO;

import Cinema.cinema_infrastructure.Spettacolo;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IoGestoreSpettacoli {

    private static final String FILE_SPETTACOLI = "Spettacoli.bin"; // Nome del file dove saranno salvati gli spettacoli

    // Metodo per caricare la lista degli spettacoli da file
    public static List<Spettacolo> caricaSpettacoliDaFile() {
        File file = new File(FILE_SPETTACOLI);
        if (!file.exists()) {
            salvaSpettacoliSuFile(new ArrayList<>()); // Crea un file vuoto se non esiste
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Spettacolo>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Metodo per salvare la lista degli spettacoli su file
    public static void salvaSpettacoliSuFile(List<Spettacolo> programmazione) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_SPETTACOLI))) {
            oos.writeObject(programmazione);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
