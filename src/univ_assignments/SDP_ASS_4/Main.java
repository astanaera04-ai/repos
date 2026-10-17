package univ_assignments.SDP_ASS_4;

public class Main {

    public static void main(String[] args) {
        BookingSystem system = FlightBookingFacadeFactory.createDemoSystem();
        FlightBookingFacade booking = system.booking();
        BookingReportFacade reports = system.reports();

        System.out.println("---- 1. Successful booking (adult, economy, promo) ----");
        Ticket ticket = booking.bookFlight(new BookingRequest("Aigerim", "aigerim@mail.kz",
                "KC-101", SeatClass.ECONOMY, PassengerType.ADULT, "WELCOME10", "card-ok"));
        System.out.printf(java.util.Locale.US, "Got %s for %.2f, economy seats left: %d, miles: %d%n",
                ticket.ticketId(), ticket.amountPaid(),
                booking.availableSeats("KC-101", SeatClass.ECONOMY),
                booking.milesBalance("aigerim@mail.kz"));

        System.out.println("\n---- 2. Payment declined: everything is undone ----");
        tryBooking(booking, new BookingRequest("Dana", "dana@mail.kz",
                "KC-101", SeatClass.BUSINESS, PassengerType.ADULT, null, "declined-card"));
        System.out.println("Business seats left: " + booking.availableSeats("KC-101", SeatClass.BUSINESS));

        System.out.println("\n---- 3. Bad promo code: seat is released ----");
        tryBooking(booking, new BookingRequest("Ali", "ali@mail.kz",
                "KC-101", SeatClass.BUSINESS, PassengerType.CHILD, "FAKE50", "card-ok"));
        System.out.println("Business seats left: " + booking.availableSeats("KC-101", SeatClass.BUSINESS));

        System.out.println("\n---- 4. Sold-out flight ----");
        tryBooking(booking, new BookingRequest("Sara", "sara@mail.kz",
                "KC-999", SeatClass.ECONOMY, PassengerType.ADULT, null, "card-ok"));

        System.out.println("\n---- 5. Report (second Facade) ----");
        System.out.println(reports.occupancyReport("KC-101"));

        System.out.println("\n---- 6. Cancellation ----");
        booking.cancelBooking(ticket.ticketId(), "aigerim@mail.kz");
        System.out.println("Economy seats left: " + booking.availableSeats("KC-101", SeatClass.ECONOMY)
                + ", miles: " + booking.milesBalance("aigerim@mail.kz"));
        System.out.println(reports.occupancyReport("KC-101"));
    }

    private static void tryBooking(FlightBookingFacade booking, BookingRequest request) {
        try {
            booking.bookFlight(request);
        } catch (BookingException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}