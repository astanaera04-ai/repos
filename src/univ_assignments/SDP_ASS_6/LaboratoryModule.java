package univ_assignments.SDP_ASS_6;

/** Concrete element: science laboratory. Immutable. */
public final class LaboratoryModule implements StationModule {

    private final String name;
    private final int experimentCount;
    private final double powerDrawKw;
    private final boolean hazardousMaterials;

    public LaboratoryModule(String name, int experimentCount, double powerDrawKw,
                            boolean hazardousMaterials) {
        this.name = name;
        this.experimentCount = experimentCount;
        this.powerDrawKw = powerDrawKw;
        this.hazardousMaterials = hazardousMaterials;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getExperimentCount() {
        return experimentCount;
    }

    public double getPowerDrawKw() {
        return powerDrawKw;
    }

    public boolean hasHazardousMaterials() {
        return hazardousMaterials;
    }

    @Override
    public void accept(StationVisitor visitor) {
        visitor.visitLaboratory(this);
    }
}
