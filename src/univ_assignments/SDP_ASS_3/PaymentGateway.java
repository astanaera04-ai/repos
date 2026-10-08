package univ_assignments.SDP_ASS_3;

public interface PaymentGateway {

    /**
     * Charges the payer the given amount through this gateway.
     *
     * @throws IllegalArgumentException if payerId is blank or amount is not positive
     */
    void charge(String payerId, double amount);
}