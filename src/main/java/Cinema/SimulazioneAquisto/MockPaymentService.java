package Cinema.SimulazioneAquisto;


public class MockPaymentService implements PaymentService {
    @Override
    public PaymentResult processPayment(PaymentRequest request) {
        // Simula la logica di decisione per il successo o il fallimento del pagamento
        if (Math.random() > 0.5) {
            return new PaymentResult(true, "Pagamento riuscito");
        } else {
            return new PaymentResult(false, "Pagamento fallito");
        }
    }
}
