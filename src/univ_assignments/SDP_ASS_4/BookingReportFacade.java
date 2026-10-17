package univ_assignments.SDP_ASS_4;

public class BookingReportFacade {

    private final SeatInventory inventory;
    private final TicketIssuer tickets;

    public BookingReportFacade(SeatInventory inventory, TicketIssuer tickets) {
        this.inventory = inventory;
        this.tickets = tickets;
    }

    public String occupancyReport(String flightNo) {
        int total = inventory.totalSeatsOn(flightNo);
        int sold = total - inventory.freeSeatsOn(flightNo);
        double revenue = tickets.ticketsFor(flightNo).stream().mapToDouble(Ticket::amountPaid).sum();
        int percent = total == 0 ? 0 : Math.round(100f * sold / total);
        return String.format(java.util.Locale.US,
                "%s: %d/%d seats sold (%d%%), revenue %.2f", flightNo, sold, total, percent, revenue);
    }
}
