package Cinema.admin_commands;

import Cinema.cinema_infrastructure.Film;
import Cinema.admin_interface.Command;

import java.time.LocalDateTime;

import Cinema.exception.FilmNonInProgrammazioneException;
import Cinema.exception.SalaNonEsistenteException;
import Cinema.exception.SovrapposizioneSpettacoloException;
import Cinema.singleton.*;

// Definisce un comando per creare o aggiornare uno spettacolo nel sistema di gestione del cinema.
public class CreateOrUpdateSpettacoloCommand implements Command {
    // Campo privato per memorizzare l'istanza del film dello spettacolo.
    private Film film;
    // Campo privato per memorizzare il numero identificativo della sala dove verrà proiettato lo spettacolo.
    private int numeroSala;
    // Campo privato per memorizzare l'orario di proiezione dello spettacolo.
    private LocalDateTime orarioProiezione;

    // Costruttore della classe CreateOrUpdateSpettacoloCommand.
    // @param film Il film da proiettare nello spettacolo.
    // @param numeroSala Il numero della sala dove verrà proiettato il film.
    // @param orarioProiezione L'orario a cui verrà proiettato il film.
    // Se uno degli argomenti non soddisfa i criteri di validità, viene sollevata un'eccezione IllegalArgumentException.
    public CreateOrUpdateSpettacoloCommand(Film film, int numeroSala, LocalDateTime orarioProiezione) {
        if (film == null) {
            throw new IllegalArgumentException("Il film non può essere null");
        }
        if (numeroSala <= 0) {
            throw new IllegalArgumentException("Il numero della sala deve essere maggiore di 0");
        }
        if (orarioProiezione == null) {
            throw new IllegalArgumentException("L'orario di proiezione non può essere null");
        }
        this.film = film;
        this.numeroSala = numeroSala;
        this.orarioProiezione = orarioProiezione;
    }


    @Override
    public void execute() {
        try {
            // Prova a creare o aggiornare lo spettacolo con i dettagli forniti.
            boolean creato = Cinema.getInstance().getGestioneCinema().creaSpettacolo(film, numeroSala, orarioProiezione);
            if (creato) {
                System.out.println("Spettacolo del film \"" + film.getTitolo() + "\" programmato con successo nella sala " + numeroSala + " alle " + orarioProiezione);
            }
        } catch (SalaNonEsistenteException e) {
            // Gestisci il caso in cui la sala non esiste.
            System.err.println(e.getMessage());
        } catch (FilmNonInProgrammazioneException e) {
            // Gestisci il caso in cui il film non è in programmazione.
            System.err.println(e.getMessage());
        } catch (SovrapposizioneSpettacoloException e) {
            // Gestisci il caso di sovrapposizione di orari degli spettacoli.
            System.err.println(e.getMessage());
        }
    }
}