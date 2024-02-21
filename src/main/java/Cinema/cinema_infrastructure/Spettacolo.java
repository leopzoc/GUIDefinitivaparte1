package Cinema.cinema_infrastructure;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Spettacolo implements Serializable {

    // Variabili d'istanza private per memorizzare i dettagli dello spettacolo, inclusi il film, la sala e l'orario di proiezione.
    private Film film;
    private Sala sala;
    private LocalDateTime orarioProiezione;

    // Costruttore che inizializza un nuovo spettacolo con il film, la sala e l'orario di proiezione specificati.
    public Spettacolo(Film film, Sala sala, LocalDateTime orarioProiezione){
        this.film = film;
        this.sala = sala;
        this.orarioProiezione = orarioProiezione;
    }

    // Metodo getter per ottenere il film dello spettacolo.
    public Film getFilm() {
        return film;
    }

    // Metodo setter per impostare il film dello spettacolo.
    public void setFilm(Film film) {
        this.film = film;
    }

    // Metodo getter per ottenere la sala dello spettacolo.
    public Sala getSala() {
        return sala;
    }

    // Metodo setter per impostare la sala dello spettacolo.
    public void setSala(Sala sala) {
        this.sala = sala;
    }

    // Metodo getter per ottenere l'orario di proiezione dello spettacolo.
    public LocalDateTime getOrarioProiezione() {
        return orarioProiezione;
    }

    // Metodo setter per impostare l'orario di proiezione dello spettacolo.
    public void setOrarioProiezione(LocalDateTime orarioProiezione) {
        this.orarioProiezione = orarioProiezione;
    }
}
