package univ_assignments.SDP_ASS_4;

public class NotificationService {

    public void sendConfirmation(String email, Ticket ticket) {
        System.out.println("  [notify] confirmation for " + ticket.ticketId() + " -> " + email);
    }

    public void sendCancellation(String email, Ticket ticket) {
        System.out.println("  [notify] cancellation of " + ticket.ticketId() + " -> " + email);
    }
}