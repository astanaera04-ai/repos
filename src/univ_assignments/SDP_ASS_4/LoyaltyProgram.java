package univ_assignments.SDP_ASS_4;

import java.util.HashMap;
import java.util.Map;

/** Subsystem class 3: frequent-flyer miles per passenger e-mail. */
public class LoyaltyProgram {

    private final Map<String, Integer> miles = new HashMap<>();

    public void addMiles(String email, int amount) {
        miles.merge(email, amount, Integer::sum);
        System.out.println("  [loyalty] +" + amount + " miles for " + email);
    }

    public void removeMiles(String email, int amount) {
        int balance = milesOf(email);
        miles.put(email, Math.max(0, balance - amount));
        System.out.println("  [loyalty] -" + amount + " miles for " + email);
    }

    public int milesOf(String email) {
        return miles.getOrDefault(email, 0);
    }
}