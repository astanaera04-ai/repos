package univ_assignments.SDP_ASS_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Subsystem class 5: creates and revokes tickets, and can list them per flight. */
public class TicketIssuer {

    private final Map<String, Ticket> issued = new HashMap<>();
    private int nextTicketId = 1;

    public Ticket issue(String passengerName, String flightNo, String seatId,
                        double amountPaid, String transactionId) {
        Ticket ticket = new Ticket("T-" + nextTicketId++, passengerName, flightNo,
                seatId, amountPaid, transactionId);
        issued.put(ticket.ticketId(), ticket);
        System.out.println("  [tickets] issued " + ticket.ticketId());
        return ticket;
    }

    public Ticket revoke(String ticketId) {
        Ticket ticket = issued.remove(ticketId);
        if (ticket == null) {
            throw new IllegalArgumentException("Unknown ticket " + ticketId);
        }
        System.out.println("  [tickets] revoked " + ticketId);
        return ticket;
    }

    public List<Ticket> ticketsFor(String flightNo) {
        List<Ticket> result = new ArrayList<>();
        for (Ticket ticket : issued.values()) {
            if (ticket.flightNo().equals(flightNo)) {
                result.add(ticket);
            }
        }
        return result;
    }
}