package univ_assignments.SDP_ASS_4;

public class AdvancedClientDemo {

    public static void main(String[] args) {
        SeatInventory inventory = new SeatInventory();
        inventory.addFlight("KC-202", 1, 1);

        String seat = inventory.reserveSeat("KC-202", SeatClass.BUSINESS);
        double price = new PricingEngine().priceFor(SeatClass.BUSINESS, PassengerType.CHILD, null);
        System.out.println("Direct use: seat " + seat + ", child business price " + price);
    }
}