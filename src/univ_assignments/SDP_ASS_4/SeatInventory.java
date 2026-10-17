package univ_assignments.SDP_ASS_4;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/** Subsystem class 1: seats per flight and class; holds and releases them. */
public class SeatInventory {

    private record SeatHold(String flightNo, SeatClass seatClass) {
    }

    private final Map<String, Map<SeatClass, Integer>> freeSeats = new HashMap<>();
    private final Map<String, Integer> capacity = new HashMap<>();
    private final Map<String, SeatHold> activeHolds = new HashMap<>();
    private int nextSeatNumber = 1;

    public void addFlight(String flightNo, int economySeats, int businessSeats) {
        Map<SeatClass, Integer> seats = new EnumMap<>(SeatClass.class);
        seats.put(SeatClass.ECONOMY, economySeats);
        seats.put(SeatClass.BUSINESS, businessSeats);
        freeSeats.put(flightNo, seats);
        capacity.put(flightNo, economySeats + businessSeats);
    }

    public int freeSeats(String flightNo, SeatClass seatClass) {
        return freeSeats.getOrDefault(flightNo, Map.of()).getOrDefault(seatClass, 0);
    }

    public int freeSeatsOn(String flightNo) {
        return freeSeats(flightNo, SeatClass.ECONOMY) + freeSeats(flightNo, SeatClass.BUSINESS);
    }

    public int totalSeatsOn(String flightNo) {
        return capacity.getOrDefault(flightNo, 0);
    }

    /** Holds one seat of the given class and returns its id. */
    public String reserveSeat(String flightNo, SeatClass seatClass) {
        if (!freeSeats.containsKey(flightNo)) {
            throw new IllegalArgumentException("Unknown flight " + flightNo);
        }
        int free = freeSeats(flightNo, seatClass);
        if (free == 0) {
            throw new IllegalStateException("No free " + seatClass + " seats on flight " + flightNo);
        }
        freeSeats.get(flightNo).put(seatClass, free - 1);
        String seatId = flightNo + "-" + seatClass.name().charAt(0) + nextSeatNumber++;
        activeHolds.put(seatId, new SeatHold(flightNo, seatClass));
        return seatId;
    }

    /** Releases a held seat. A seat can be released only once. */
    public void releaseSeat(String seatId) {
        SeatHold hold = activeHolds.remove(seatId);
        if (hold == null) {
            throw new IllegalArgumentException("Seat " + seatId + " is not held");
        }
        freeSeats.get(hold.flightNo()).merge(hold.seatClass(), 1, Integer::sum);
    }
}
