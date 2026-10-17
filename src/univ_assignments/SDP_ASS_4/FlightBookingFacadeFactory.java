package univ_assignments.SDP_ASS_4;

public final class FlightBookingFacadeFactory {

    private FlightBookingFacadeFactory() {
    }

    public static BookingSystem createDemoSystem() {
        SeatInventory inventory = new SeatInventory();
        inventory.addFlight("KC-101", 2, 1);
        inventory.addFlight("KC-999", 0, 0);
        TicketIssuer tickets = new TicketIssuer();

        FlightBookingFacade booking = new FlightBookingFacade(inventory, new PricingEngine(),
                new PaymentService(), tickets, new LoyaltyProgram(), new NotificationService());
        BookingReportFacade reports = new BookingReportFacade(inventory, tickets);
        return new BookingSystem(booking, reports);
    }
}