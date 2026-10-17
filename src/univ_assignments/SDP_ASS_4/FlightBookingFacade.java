package univ_assignments.SDP_ASS_4;

public class FlightBookingFacade {

    private final SeatInventory inventory;
    private final PricingEngine pricing;
    private final PaymentService payments;
    private final TicketIssuer tickets;
    private final LoyaltyProgram loyalty;
    private final NotificationService notifications;

    public FlightBookingFacade(SeatInventory inventory, PricingEngine pricing,
                               PaymentService payments, TicketIssuer tickets,
                               LoyaltyProgram loyalty, NotificationService notifications) {
        this.inventory = inventory;
        this.pricing = pricing;
        this.payments = payments;
        this.tickets = tickets;
        this.loyalty = loyalty;
        this.notifications = notifications;
    }

    public Ticket bookFlight(BookingRequest request) {
        String seatId = reserveSeat(request);
        String transactionId = null;
        Ticket ticket = null;
        int awardedMiles = 0;
        try {
            double price = pricing.priceFor(request.seatClass(), request.passengerType(),
                    request.promoCode());
            transactionId = payments.charge(request.cardToken(), price);
            ticket = tickets.issue(request.passengerName(), request.flightNo(),
                    seatId, price, transactionId);
            awardedMiles = milesFor(price);
            loyalty.addMiles(request.email(), awardedMiles);
            notifications.sendConfirmation(request.email(), ticket);
            return ticket;
        } catch (RuntimeException e) {
            rollback(request.email(), seatId, transactionId, ticket, awardedMiles);
            throw new BookingException("Booking failed: " + e.getMessage(), e);
        }
    }

    public void cancelBooking(String ticketId, String email) {
        try {
            Ticket ticket = tickets.revoke(ticketId);
            payments.refund(ticket.transactionId());
            inventory.releaseSeat(ticket.seatId());
            loyalty.removeMiles(email, milesFor(ticket.amountPaid()));
            notifications.sendCancellation(email, ticket);
        } catch (RuntimeException e) {
            throw new BookingException("Cancellation failed: " + e.getMessage(), e);
        }
    }

    public int availableSeats(String flightNo, SeatClass seatClass) {
        return inventory.freeSeats(flightNo, seatClass);
    }

    public int milesBalance(String email) {
        return loyalty.milesOf(email);
    }

    private String reserveSeat(BookingRequest request) {
        try {
            return inventory.reserveSeat(request.flightNo(), request.seatClass());
        } catch (RuntimeException e) {
            throw new BookingException("Booking failed: " + e.getMessage(), e);
        }
    }

    private int milesFor(double amountPaid) {
        return (int) amountPaid;
    }

    /** Undoes every step that already succeeded, newest first. */
    private void rollback(String email, String seatId, String transactionId,
                          Ticket ticket, int awardedMiles) {
        if (awardedMiles > 0) {
            loyalty.removeMiles(email, awardedMiles);
        }
        if (ticket != null) {
            tickets.revoke(ticket.ticketId());
        }
        if (transactionId != null) {
            payments.refund(transactionId);
        }
        inventory.releaseSeat(seatId);
    }
}