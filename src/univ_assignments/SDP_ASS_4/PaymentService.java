package univ_assignments.SDP_ASS_4;

import java.util.Locale;

/** Subsystem class 3: moves money. Rejects tokens that start with "declined". */
public class PaymentService {

    private int nextTransactionId = 1;

    public String charge(String cardToken, double amount) {
        if (cardToken == null || cardToken.startsWith("declined")) {
            throw new IllegalStateException("Card was declined");
        }
        String transactionId = "TX-" + nextTransactionId++;
        System.out.printf(Locale.US, "  [payment] charged %.2f (%s)%n", amount, transactionId);
        return transactionId;
    }

    public void refund(String transactionId) {
        System.out.println("  [payment] refunded " + transactionId);
    }
}
