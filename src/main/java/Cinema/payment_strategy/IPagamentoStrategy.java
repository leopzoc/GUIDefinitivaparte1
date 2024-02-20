package Cinema.payment_strategy;



//public interface IPagamentoStrategy {
//    void paga(double importo);
//}

import Cinema.exception.PagamentoFallitoException;

public interface IPagamentoStrategy {
    void paga(double importo) throws PagamentoFallitoException;
}