package univ_assignments.SDP_ASS_3;

public abstract class AbstractPaymentGateway implements PaymentGateway {

    @Override
    public final void charge(String payerId, double amount) {
        validate(payerId, amount);
        doCharge(payerId, amount);
    }

    protected abstract void doCharge(String payerId, double amount);

    private void validate(String payerId, double amount) {
        if (payerId == null || payerId.isBlank()) {
            throw new IllegalArgumentException("Payer id must not be blank");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive, was: " + amount);
        }
    }
}
