package GestioneIO;

import Cinema.cinema_infrastructure.Sala;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class IoGestoreSala {

    public static Map<Integer, Sala> caricaSaleDaFile() {
        File file = new File("Sale.bin");
        if (!file.exists()) {
            salvaSaleSuFile(new HashMap<>()); // Crea un file vuoto se non esiste
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Map<Integer, Sala>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    public static void salvaSaleSuFile(Map<Integer, Sala> sale) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Sale.bin"))) {
            oos.writeObject(sale);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
