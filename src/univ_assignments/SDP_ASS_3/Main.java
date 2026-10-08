package univ_assignments.SDP_ASS_3;

public class Main {

    public static void main(String[] args) {
        demonstrateSwitchingImplementors();
        demonstrateNewImplementorNeedsNoAbstractionChange();
        demonstrateInvalidUsageIsRejected();
    }

    private static void demonstrateSwitchingImplementors() {
        System.out.println("---- Same abstraction, different gateways ----\n");

        Payment subscriptionByStripe = new SubscriptionPayment(new StripeGateway());
        Payment subscriptionByPayPal = new SubscriptionPayment(new PayPalGateway());

        subscriptionByStripe.process("user-101", 50.00);
        subscriptionByPayPal.process("user-101", 50.00);

        System.out.println();
    }

    private static void demonstrateNewImplementorNeedsNoAbstractionChange() {
        System.out.println("---- A brand new gateway, zero changes to Payment ----\n");

        Payment oneTimeByCrypto = new OneTimePayment(new CryptoGateway());
        oneTimeByCrypto.process("wallet-0xA1B2", 25.00);

        System.out.println();
    }

    private static void demonstrateInvalidUsageIsRejected() {
        System.out.println("---- Invalid input is rejected ----\n");

        try {
            new OneTimePayment(new StripeGateway()).process("user-101", -10.00);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}