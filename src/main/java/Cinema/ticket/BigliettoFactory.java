package Cinema.ticket;
import Cinema.cinema_infrastructure.Spettacolo;
import Cinema.domain.Utente;


public class BigliettoFactory {
    // Metodo statico per creare un biglietto in base al tipo (intero o ridotto)
    public static Biglietto creaBiglietto(Spettacolo spettacolo, Utente acquirente, String tipoBiglietto) {
        // Crea un biglietto intero se il tipo è "intero", altrimenti crea un biglietto ridotto
        if (tipoBiglietto.equalsIgnoreCase("intero")) {
            return new BigliettoIntero(spettacolo, acquirente);
        } else { // Assume che qualsiasi altro tipo sia "ridotto"
            return new BigliettoRidotto(spettacolo, acquirente);
        }
    }
}

