package GestioneIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LetturaUtenti {
    public static boolean esistenzaFile() {
        File file = new File("UtentidelCinema.bin");
        if (!file.exists()) {
            CreatoreFileUtenti.CreatoreFile();
            return false;
        }
        return true;
    }
}
