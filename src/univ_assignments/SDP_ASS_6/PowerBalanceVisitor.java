package univ_assignments.SDP_ASS_6;

/**
 * Concrete visitor #1: calculates the power balance of the station.
 * Single operation: "how much power is produced and consumed".
 */
public class PowerBalanceVisitor implements StationVisitor {

    private static final double LAB_POWER_PER_EXPERIMENT_KW = 0.8;
    private static final double CARGO_BAY_POWER_KW = 0.5;

    private double producedKw;
    private double consumedKw;

    @Override
    public void visitHabitat(HabitatModule habitat) {
        consumedKw += habitat.getPowerDrawKw();
    }

    @Override
    public void visitLaboratory(LaboratoryModule laboratory) {
        consumedKw += laboratory.getPowerDrawKw()
                + laboratory.getExperimentCount() * LAB_POWER_PER_EXPERIMENT_KW;
    }

    @Override
    public void visitSolarArray(SolarArray solarArray) {
        producedKw += solarArray.getOutputKw() * solarArray.getEfficiencyPercent() / 100.0;
    }

    @Override
    public void visitCargoBay(CargoBay cargoBay) {
        consumedKw += CARGO_BAY_POWER_KW;
    }

    public double getProducedKw() {
        return producedKw;
    }

    public double getConsumedKw() {
        return consumedKw;
    }

    public double getNetKw() {
        return producedKw - consumedKw;
    }
}
