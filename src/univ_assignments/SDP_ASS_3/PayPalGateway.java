package univ_assignments.SDP_ASS_3;

public class PayPalGateway extends AbstractPaymentGateway {

    private static final String PROVIDER_LABEL = "PAYPAL";

    @Override
    protected void doCharge(String payerId, double amount) {
        System.out.printf("[%s] Invoiced %.2f to account %s%n", PROVIDER_LABEL, amount, payerId);
    }
}