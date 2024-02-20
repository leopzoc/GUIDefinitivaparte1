package Cinema;


import Cinema.admin_commands.*;
import Cinema.cinema_infrastructure.Film;
import Cinema.cinema_infrastructure.Sala;
import Cinema.cinema_infrastructure.Spettacolo;
import Cinema.domain.Amministratore;
import Cinema.domain.Ruolo;
import Cinema.domain.Utente;

import java.time.LocalDateTime;

import Cinema.memento.AcquistoMemento;
import Cinema.memento.Caretaker;
import Cinema.payment_strategy.*;
import Cinema.ticket.Biglietto;
import Cinema.ticket.BigliettoFactory;
import Cinema.singleton.Cinema;
import Cinema.ticket.GestoreStampa;
import Cinema.user_service.ServizioAcquistoBiglietto;


public class main {
 public static void main(String[] args) {

  //Prova Modifica 2

  // Inizializzazione del singleton Cinema
  Cinema cinema = Cinema.getInstance();

  double sovrapprezzoWeekend = 20; // Sovrapprezzo del 20%
  cinema.getGestorePrezzi().setSovrapprezzoWeekend(sovrapprezzoWeekend);


  // Creazione e configurazione di un amministratore
  Amministratore amministratore = new Amministratore("NomeAdmin", "CognomeAdmin", Ruolo.AMMINISTRATORE);

  // Aggiunta di una sala
  Sala sala = new Sala(1, 0);
  amministratore.eseguiComando(new AggiungiSalaCommand(sala));

  //Aggiunta di una seconda sala
  Sala sala2 = new Sala(1, 100);
  amministratore.eseguiComando(new AggiungiSalaCommand(sala2));

  // Aggiunta di un film
  Film filmInterstellar = new Film("Interstellar", 169);
  amministratore.eseguiComando(new AggiungiFilmCommand(filmInterstellar));

  // Aggiunta di un secondo film
  Film filmFastAndFurious = new Film("Fast and Furious", 130);
  amministratore.eseguiComando(new AggiungiFilmCommand(filmFastAndFurious));


  //Aggiunta dello stesso film (ERRORE)
  Film filmFastAndFurious2 = new Film("Fast and Furious", 130);
  amministratore.eseguiComando(new AggiungiFilmCommand(filmFastAndFurious2));


  // Programmazione di uno spettacolo per "Interstellar"
  LocalDateTime orarioProiezioneInterstellar = LocalDateTime.of(2024, 2, 17, 21, 0);
  amministratore.eseguiComando(new CreateOrUpdateSpettacoloCommand(filmInterstellar, 1, orarioProiezioneInterstellar));

  // Programmazione di uno spettacolo per "Fast and Furious"
  LocalDateTime orarioProiezionefast = LocalDateTime.of(2024, 2, 17, 18, 0);
  amministratore.eseguiComando(new CreateOrUpdateSpettacoloCommand(filmFastAndFurious, 1, orarioProiezionefast));

  // Programmazione di un secondo spettacolo per "Fast and Furious".
  LocalDateTime orarioProiezionefast2 = LocalDateTime.of(2024, 2, 18, 20, 30);
  amministratore.eseguiComando(new CreateOrUpdateSpettacoloCommand(filmFastAndFurious, 1, orarioProiezionefast2));

  // Impostazione dei prezzi dei biglietti
  amministratore.eseguiComando(new ImpostaPrezziBigliettiCommand(10.0, 10.0));

  // Aumento dei prezzi dei biglietti
  amministratore.eseguiComando(new IncreaseTicketPriceCommand(0, 0));

  // Diminuzione dei prezzi dei biglietti
  amministratore.eseguiComando(new DecreaseTicketPriceCommand(0,0));

  // Diminuzione dei prezzi dei biglietti
  //amministratore.eseguiComando(new DecreaseTicketPriceCommand(0.5, 0.2));

  // Creazione di un utente
  Utente utente = new Utente("Mario", "Rossi", Ruolo.UTENTE);

  // Ricerca dello spettacolo programmato per "Interstellar"
  Spettacolo spettacoloInterstellar = cinema.getGestioneCinema().trovaSpettacolo(filmInterstellar, sala.getNumeroSala(), orarioProiezioneInterstellar);

  // Verifica che lo spettacolo sia stato trovato prima di procedere
  if (spettacoloInterstellar == null) {
   System.out.println("Spettacolo di 'Interstellar' non trovato.");
   return;
  }

  // Ricerca dello spettacolo programmato per "Fast and Furious"
  Spettacolo spettacolofastandfurious = cinema.getGestioneCinema().trovaSpettacolo(filmFastAndFurious, sala.getNumeroSala(), orarioProiezionefast);

  // Verifica che lo spettacolo sia stato trovato prima di procedere
  if (spettacolofastandfurious == null) {
   System.out.println("Spettacolo di 'Fast and Furious' non trovato.");
   return;
  }

  // Creazione del biglietto Interstellar
  Biglietto bigliettoInterstellar = BigliettoFactory.creaBiglietto(spettacoloInterstellar, utente, "intero");

  //Creazione del biglietto Interstellar Ridotto
  Biglietto bigliettoInterstellarRidotto = BigliettoFactory.creaBiglietto(spettacoloInterstellar, utente, "ridotto");

  // Creazione del biglietto Fast and Furious
  Biglietto bigliettoFastAndFurious = BigliettoFactory.creaBiglietto(spettacolofastandfurious, utente, "intero");

  //Creazione del secondo biglietto Fast and Furious
  Biglietto bigliettoFastAndFuriousRidotto = BigliettoFactory.creaBiglietto(spettacolofastandfurious, utente, "ridotto");



  // Configurazione del metodo di pagamento Carta di Credito
  IPagamentoStrategy metodoPagamento = new PagamentoCartaDiCreditoStrategy();
  GestorePagamenti gestorePagamenti = new GestorePagamenti(metodoPagamento);

 // Configurazione del metodo di pagamento Contanti
  IPagamentoStrategy metodoPagamentoContanti = new PagamentoContantiStrategy();
  GestorePagamenti gestorePagamentiContanti = new GestorePagamenti(metodoPagamentoContanti);

  // Configurazione del metodo di pagamento Bancomat
  IPagamentoStrategy metodoPagamentoBancomat = new PagamentoBancomatStrategy();
  GestorePagamenti gestorePagamentiBancomat = new GestorePagamenti(metodoPagamentoBancomat);


  // Creazione del servizio di acquisto biglietto con Carta di Credito
  ServizioAcquistoBiglietto servizioAcquisto = new ServizioAcquistoBiglietto(gestorePagamenti);

  //Creazione del servizio di acquisto biglietto con Contanti
  ServizioAcquistoBiglietto servizioAcquistoContanti = new ServizioAcquistoBiglietto(gestorePagamentiContanti);

  //Creazione del servizio di acquisto biglietto con Bancomat
  ServizioAcquistoBiglietto servizioAcquistoBancomat = new ServizioAcquistoBiglietto(gestorePagamentiBancomat);


  // Acquisto del biglietto Interstellar Carta di Credito
  servizioAcquisto.acquistaBiglietto(bigliettoInterstellar, metodoPagamento);

  GestoreStampa.stampaDettagliBiglietto(bigliettoInterstellar);


  //Acquisto del biglietto Interstellar Ridotto Contanti
  servizioAcquisto.acquistaBiglietto(bigliettoInterstellarRidotto, metodoPagamentoContanti);

  GestoreStampa.stampaDettagliBiglietto(bigliettoInterstellarRidotto);



  //Acquisto del biglietto Fast and Furious Ridotto Carta di Credito
  servizioAcquisto.acquistaBiglietto(bigliettoFastAndFuriousRidotto, metodoPagamento);

  GestoreStampa.stampaDettagliBiglietto(bigliettoFastAndFuriousRidotto);

  // Acquisto del biglietto Fast and Furious Bancomat
  servizioAcquisto.acquistaBiglietto(bigliettoFastAndFurious, metodoPagamentoBancomat);

  GestoreStampa.stampaDettagliBiglietto(bigliettoFastAndFurious);


  // Tentativo di annullare l'ultimo acquisto immediatamente
  Caretaker caretaker = cinema.getCaretaker();
  if (caretaker.canUndo()) {
   AcquistoMemento ultimoAcquistoAnnullato = caretaker.undoLastAcquisto();
   System.out.println("L'ultimo acquisto è stato annullato con successo.");
  } else {
   System.out.println("Non è possibile annullare l'ultimo acquisto.");
  }

  GestoreStampa.stampaDettagliBiglietto(bigliettoFastAndFurious);

  System.out.println("Acquisto biglietto completato per l'utente: " + utente.getNome() + " " + utente.getCognome());

  // Generazione del report dei ricavi
  amministratore.eseguiComando(new GeneraReportRicaviCommand());


 }
}

















