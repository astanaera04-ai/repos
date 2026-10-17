package univ_assignments.SDP_ASS_4;

import java.util.Map;

/** Subsystem class 2: class fare x passenger type x promo discount + tax. */
public class PricingEngine {

    private static final double BASE_FARE = 100.00;
    private static final double BUSINESS_MULTIPLIER = 2.5;
    private static final double TAX_RATE = 0.12;
    private static final Map<String, Double> PROMO_DISCOUNTS = Map.of("WELCOME10", 0.10);

    public double priceFor(SeatClass seatClass, PassengerType passengerType, String promoCode) {
        double fare = BASE_FARE
                * (seatClass == SeatClass.BUSINESS ? BUSINESS_MULTIPLIER : 1.0)
                * passengerType.fareMultiplier();
        double discounted = fare * (1 - discountFor(promoCode));
        return discounted * (1 + TAX_RATE);
    }

    private double discountFor(String promoCode) {
        if (promoCode == null || promoCode.isBlank()) {
            return 0.0;
        }
        Double discount = PROMO_DISCOUNTS.get(promoCode);
        if (discount == null) {
            throw new IllegalArgumentException("Unknown promo code " + promoCode);
        }
        return discount;
    }
}