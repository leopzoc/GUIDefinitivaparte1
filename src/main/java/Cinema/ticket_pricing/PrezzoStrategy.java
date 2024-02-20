package Cinema.ticket_pricing;

import Cinema.cinema_infrastructure.Spettacolo;

public interface PrezzoStrategy {
  double calcolaPrezzo(Spettacolo spettacolo, String tipoBiglietto, PrezziBiglietto prezziCorrenti);
}

