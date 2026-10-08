package univ_assignments.SDP_ASS_3;

public abstract class Payment {

    private final PaymentGateway gateway;

    protected Payment(PaymentGateway gateway) {
        if (gateway == null) {
            throw new IllegalArgumentException("A Payment requires a PaymentGateway");
        }
        this.gateway = gateway;
    }

    public final void process(String payerId, double baseAmount) {
        gateway.charge(payerId, computeFinalAmount(baseAmount));
    }

    protected abstract double computeFinalAmount(double baseAmount);
}
