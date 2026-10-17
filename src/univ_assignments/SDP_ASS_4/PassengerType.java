package univ_assignments.SDP_ASS_4;

public enum PassengerType {
    ADULT(1.0), CHILD(0.5);

    private final double fareMultiplier;

    PassengerType(double fareMultiplier) {
        this.fareMultiplier = fareMultiplier;
    }

    public double fareMultiplier() {
        return fareMultiplier;
    }
}