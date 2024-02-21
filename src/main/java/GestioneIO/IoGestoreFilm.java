package GestioneIO;
import Cinema.cinema_infrastructure.Film;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IoGestoreFilm {


        private static final String FILE_FILM = "Film.bin"; // Nome del file dove saranno salvati i film

        // Metodo per caricare la lista dei film da file
        public static List<Film> caricaFilmDaFile() {
            File file = new File(FILE_FILM);
            if (!file.exists()) {
                salvaFilmSuFile(new ArrayList<>()); // Crea un file vuoto se non esiste
            }
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                return (List<Film>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return new ArrayList<>();
            }
        }

        // Metodo per salvare la lista dei film su file
        public static void salvaFilmSuFile(List<Film> filmInProgrammazione) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_FILM))) {
                oos.writeObject(filmInProgrammazione);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
