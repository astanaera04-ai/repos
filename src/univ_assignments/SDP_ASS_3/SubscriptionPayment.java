package univ_assignments.SDP_ASS_3;

public class SubscriptionPayment extends Payment {

    private static final double RECURRING_FEE_RATE = 0.02; // 2% processing fee

    public SubscriptionPayment(PaymentGateway gateway) {
        super(gateway);
    }

    @Override
    protected double computeFinalAmount(double baseAmount) {
        return baseAmount + (baseAmount * RECURRING_FEE_RATE);
    }
}
