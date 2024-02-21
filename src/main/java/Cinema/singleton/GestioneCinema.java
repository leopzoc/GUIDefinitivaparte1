package Cinema.singleton;
import Cinema.cinema_infrastructure.Film;
import Cinema.cinema_infrastructure.Sala;
import Cinema.cinema_infrastructure.Spettacolo;
import Cinema.exception.*;
import GestioneIO.IoGestoreFilm;
import GestioneIO.IoGestoreSala;
import GestioneIO.IoGestoreSpettacoli;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class GestioneCinema {
    // Mappa che tiene traccia delle sale del cinema, usando come chiave il numero della sala
    private Map<Integer, Sala> sale;
    // Lista dei film attualmente in programmazione nel cinema
    private List<Film> filmInProgrammazione;
    // Lista degli spettacoli programmati nel cinema
    private List<Spettacolo> programmazione;

    // Costruttore della classe che inizializza le strutture dati
    public GestioneCinema() {
        this.sale = IoGestoreSala.caricaSaleDaFile(); // Carica le sale da file
        this.filmInProgrammazione = IoGestoreFilm.caricaFilmDaFile(); // Carica i film da file
        this.programmazione = IoGestoreSpettacoli.caricaSpettacoliDaFile(); // Carica gli spettacoli da file
    }

        public void aggiungiSala(Sala sala) throws SalaGiaEsistenteException {
            if (sale.containsKey(sala.getNumeroSala())) {
                throw new SalaGiaEsistenteException("Sala numero " + sala.getNumeroSala() + " esiste già.");
            }
            sale.put(sala.getNumeroSala(), sala);
            IoGestoreSala.salvaSaleSuFile(sale); // Salva le modifiche sul file
            System.out.println("Sala " + sala.getNumeroSala() + " aggiunta con successo.");
        }


        // Metodo per aggiungere un nuovo film alla lista dei film in programmazione
        public void aggiungiFilm(Film film) throws FilmGiaPresenteException {
            // Verifica che il film non sia già presente nella lista
            if (filmInProgrammazione.stream().noneMatch(f -> f.getTitolo().equalsIgnoreCase(film.getTitolo()))) {
                // Se il film non è presente, lo aggiunge alla lista
                filmInProgrammazione.add(film);
                IoGestoreFilm.salvaFilmSuFile(filmInProgrammazione); // Salva le modifiche sul file
                System.out.println("Film \"" + film.getTitolo() + "\" aggiunto con successo.");
            } else {
                // Se il film è già presente, lancia un'eccezione
                throw new FilmGiaPresenteException("Film \"" + film.getTitolo() + "\" è già presente.");
            }
        }

        // Metodo per creare un nuovo spettacolo
        public boolean creaSpettacolo(Film film, int numeroSala, LocalDateTime orarioProiezione)
                throws SalaNonEsistenteException, FilmNonInProgrammazioneException, SovrapposizioneSpettacoloException {

            // Carica la lista delle sale e dei film in programmazione da file
            this.sale = IoGestoreSala.caricaSaleDaFile();
            this.filmInProgrammazione = IoGestoreFilm.caricaFilmDaFile();
            // Carica gli spettacoli attuali da file
            this.programmazione = IoGestoreSpettacoli.caricaSpettacoliDaFile();

            // Verifica l'esistenza della sala
            Sala sala = sale.get(numeroSala);
            if (sala == null) {
                throw new SalaNonEsistenteException("Sala numero " + numeroSala + " non esiste.");
            }

            // Verifica che il film sia in programmazione
            boolean filmInProgrammazione = this.filmInProgrammazione.stream()
                    .anyMatch(f -> f.getTitolo().equalsIgnoreCase(film.getTitolo()));
            if (!filmInProgrammazione) {
                throw new FilmNonInProgrammazioneException("Film \"" + film.getTitolo() + "\" non è presente nella programmazione.");
            }

            // Controlla la sovrapposizione degli spettacoli
            LocalDateTime orarioFinePrevisto = orarioProiezione.plusMinutes(film.getDurata());
            for (Spettacolo spettacoloEsistente : programmazione) {
                if (spettacoloEsistente.getSala().getNumeroSala() == numeroSala) {
                    LocalDateTime inizioEsistente = spettacoloEsistente.getOrarioProiezione();
                    LocalDateTime fineEsistente = inizioEsistente.plusMinutes(spettacoloEsistente.getFilm().getDurata());
                    if (orarioProiezione.isBefore(fineEsistente) && orarioFinePrevisto.isAfter(inizioEsistente)) {
                        throw new SovrapposizioneSpettacoloException("Impossibile programmare: sovrapposizione con spettacolo esistente.");
                    }
                }
            }
            // Se non ci sono sovrapposizioni, aggiunge lo spettacolo alla lista
            Spettacolo nuovoSpettacolo = new Spettacolo(film, sala, orarioProiezione);
            programmazione.add(nuovoSpettacolo);
            // Salva la lista aggiornata degli spettacoli su file
            IoGestoreSpettacoli.salvaSpettacoliSuFile(programmazione);

            return true; // Indica il successo dell'operazione

        }

        // Metodo per trovare uno spettacolo specifico

    public Spettacolo trovaSpettacolo(Film film, int numeroSala, LocalDateTime orarioProiezione) {
        // Assicurati di avere la lista aggiornata di spettacoli
        this.programmazione = IoGestoreSpettacoli.caricaSpettacoliDaFile();

        for (Spettacolo spettacolo : programmazione) {
            if (spettacolo.getFilm().equals(film) &&
                    spettacolo.getSala().getNumeroSala() == numeroSala &&
                    spettacolo.getOrarioProiezione().equals(orarioProiezione)) {
                return spettacolo; // Ritorna lo spettacolo trovato
            }
        }
        return null; // Nessuno spettacolo trovato che corrisponde ai criteri
    }


        // Metodi getter per accedere alle strutture dati interne dalla classe
        public Map<Integer, Sala> getSale() {
            return sale;
        }

        public List<Film> getFilmInProgrammazione() {
            return filmInProgrammazione;
        }

        public List<Spettacolo> getProgrammazione() {
            return programmazione;
        }

        // Nota: ulteriori metodi potrebbero essere aggiunti per gestire altre funzionalità, come la ricerca di film o la cancellazione di spettacoli.
    }

