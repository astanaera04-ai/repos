package univ_assignments.SDP_ASS_5;

import java.util.Locale;

 public record Enemy(String name, int health, double distanceToTurret, double distanceToBase) {

    @Override
    public String toString() {
        return String.format(Locale.US, "%s(hp=%d, dTurret=%.0f, dBase=%.0f)",
                name, health, distanceToTurret, distanceToBase);
    }
}

