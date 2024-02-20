package Cinema.ticket_pricing;

public class PrezziBiglietto {
    private final  double prezzoIntero;
    private final  double prezzoRidotto;

    public PrezziBiglietto(double prezzoIntero, double prezzoRidotto) {
        this.prezzoIntero = prezzoIntero;
        this.prezzoRidotto = prezzoRidotto;
    }

    public double getPrezzoIntero() {
        return prezzoIntero;
    }

    public double getPrezzoRidotto() {
        return prezzoRidotto;
    }
}



