package GestioneIO;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendingObjectOutputStream extends ObjectOutputStream {
    public AppendingObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        // Non scrive l'intestazione dello stream per permettere l'append al file esistente.
    }
}