package univ_assignments.SDP_ASS_4;

public class BookingException extends RuntimeException {
    public BookingException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookingException(String message) {
        super(message);
    }
}