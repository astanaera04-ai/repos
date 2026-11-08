package univ_assignments.SDP_ASS_6;

/** Concrete element: cargo storage. Immutable. */
public final class CargoBay implements StationModule {

    private final String name;
    private final double storedTons;
    private final double capacityTons;

    public CargoBay(String name, double storedTons, double capacityTons) {
        this.name = name;
        this.storedTons = storedTons;
        this.capacityTons = capacityTons;
    }

    @Override
    public String getName() {
        return name;
    }

    public double getStoredTons() {
        return storedTons;
    }

    public double getCapacityTons() {
        return capacityTons;
    }

    @Override
    public void accept(StationVisitor visitor) {
        visitor.visitCargoBay(this);
    }
}