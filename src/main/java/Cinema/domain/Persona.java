package Cinema.domain;

import java.io.Serializable;

public  class Persona implements Serializable {
    private String nome;
    private String cognome;
    private static final long serialVersionUID = -6564252117861956055L; // Usa il serialVersionUID dal messaggio di errore

    private Ruolo ruolo; // Aggiunto il campo ruolo

    // Costruttore modificato per includere il ruolo
    public Persona(String nome, String cognome, Ruolo ruolo) {
        this.nome = nome;
        this.cognome = cognome;
        this.ruolo = ruolo;
    }

    // Getter e setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }
}
