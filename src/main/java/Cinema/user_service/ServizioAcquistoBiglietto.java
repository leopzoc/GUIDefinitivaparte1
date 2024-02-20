package Cinema.user_service;



import Cinema.cinema_infrastructure.Sala;
import Cinema.cinema_infrastructure.Spettacolo;
import Cinema.memento.Acquisto;
import Cinema.user_interfaces.AcquistoBiglietto;
import Cinema.payment_strategy.GestorePagamenti;
import Cinema.payment_strategy.IPagamentoStrategy;
import Cinema.ticket.Biglietto;

import Cinema.singleton.*;

import java.time.LocalDateTime;
import Cinema.memento.*;

public class ServizioAcquistoBiglietto implements AcquistoBiglietto {
    private GestorePagamenti gestorePagamenti;

    public ServizioAcquistoBiglietto(GestorePagamenti gestorePagamenti) {
        this.gestorePagamenti = gestorePagamenti;
    }

    @Override
    public void acquistaBiglietto(Biglietto biglietto, IPagamentoStrategy metodoPagamento) {
        Spettacolo spettacolo = biglietto.getSpettacolo();
        Sala sala = spettacolo.getSala();

        if (sala.occupaPosto()) { // Verifica la disponibilità di posti prima dell'acquisto
            gestorePagamenti.setMetodoPagamento(metodoPagamento);
            gestorePagamenti.effettuaPagamento(biglietto.getCosto());

            Cinema.getInstance().getGestoreRicavi().registraVenditaBiglietto(biglietto);

            Caretaker caretaker = Cinema.getInstance().getCaretaker();
            caretaker.addMemento(new Acquisto(biglietto, LocalDateTime.now()));

            System.out.println("Biglietto acquistato con successo per lo spettacolo: "
                    + biglietto.getSpettacolo().getFilm().getTitolo() + " al costo di: " + biglietto.getCosto());
        } else {
            System.out.println("Non è stato possibile acquistare il biglietto: posti esauriti.");
        }
    }
}

