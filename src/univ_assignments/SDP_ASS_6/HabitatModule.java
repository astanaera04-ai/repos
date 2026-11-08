package univ_assignments.SDP_ASS_6;

/** Concrete element: living quarters for the crew. Immutable. */
public final class HabitatModule implements StationModule {

    private final String name;
    private final int crewCapacity;
    private final double powerDrawKw;
    private final int ageInYears;

    public HabitatModule(String name, int crewCapacity, double powerDrawKw, int ageInYears) {
        this.name = name;
        this.crewCapacity = crewCapacity;
        this.powerDrawKw = powerDrawKw;
        this.ageInYears = ageInYears;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getCrewCapacity() {
        return crewCapacity;
    }

    public double getPowerDrawKw() {
        return powerDrawKw;
    }

    public int getAgeInYears() {
        return ageInYears;
    }

    @Override
    public void accept(StationVisitor visitor) {
        visitor.visitHabitat(this);          // double dispatch: step 2
    }
}

