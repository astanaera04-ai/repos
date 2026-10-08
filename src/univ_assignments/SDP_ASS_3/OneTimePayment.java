package univ_assignments.SDP_ASS_3;

public class OneTimePayment extends Payment {

    public OneTimePayment(PaymentGateway gateway) {
        super(gateway);
    }

    @Override
    protected double computeFinalAmount(double baseAmount) {
        return baseAmount;
    }
}