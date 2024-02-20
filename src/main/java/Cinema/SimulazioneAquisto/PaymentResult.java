package Cinema.SimulazioneAquisto;

public class PaymentResult {
    private boolean success;
    private String message;

    public PaymentResult(boolean b, String pagamentoFallito) {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}