package Cinema.user_interfaces;
import Cinema.payment_strategy.IPagamentoStrategy;
import Cinema.ticket.Biglietto;

public interface AcquistoBiglietto {
    void acquistaBiglietto(Biglietto biglietto, IPagamentoStrategy metodoPagamento);
}
