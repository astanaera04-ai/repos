package univ_assignments.SDP_ASS_3;

public class CryptoGateway extends AbstractPaymentGateway {

    private static final String PROVIDER_LABEL = "CRYPTO";

    @Override
    protected void doCharge(String payerId, double amount) {
        System.out.printf("[%s] Transferred %.6f BTC-equivalent from wallet %s%n",
                PROVIDER_LABEL, amount, payerId);
    }
}