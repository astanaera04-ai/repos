package univ_assignments.SDP_ASS_4;

public record BookingRequest(String passengerName, String email, String flightNo,
                             SeatClass seatClass, PassengerType passengerType,
                             String promoCode, String cardToken) {
}
