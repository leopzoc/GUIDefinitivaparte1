package Cinema.payment_strategy;



import Cinema.exception.PagamentoFallitoException;

public class GestorePagamenti {
    private IPagamentoStrategy metodoPagamento;

    public GestorePagamenti(IPagamentoStrategy metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public void effettuaPagamento(double importo) {
        try {
            metodoPagamento.paga(importo);
        } catch (PagamentoFallitoException e) {
            System.err.println("Errore nel pagamento: " + e.getMessage());
            // Qui si possono gestire ulteriormente l'errore, come il rollback o la notifica all'utente
        }
    }

    // Metodo per cambiare dinamicamente il metodo di pagamento
    public void setMetodoPagamento(IPagamentoStrategy metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
}