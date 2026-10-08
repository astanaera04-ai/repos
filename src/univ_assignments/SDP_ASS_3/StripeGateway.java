package univ_assignments.SDP_ASS_3;

public class StripeGateway extends AbstractPaymentGateway {

    private static final String PROVIDER_LABEL = "STRIPE";

    @Override
    protected void doCharge(String payerId, double amount) {
        System.out.printf("[%s] Charged %.2f to payer %s%n", PROVIDER_LABEL, amount, payerId);
    }
}