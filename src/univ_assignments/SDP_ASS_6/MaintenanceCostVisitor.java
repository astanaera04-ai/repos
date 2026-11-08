package univ_assignments.SDP_ASS_6;
/**
 * Concrete visitor #3: yearly maintenance budget.
 * Single operation: "how much does it cost to keep the station running".
 */
public class MaintenanceCostVisitor implements StationVisitor {

    private static final double HABITAT_BASE_COST = 120_000;
    private static final double HABITAT_COST_PER_CREW_SEAT = 15_000;
    private static final double LAB_BASE_COST = 200_000;
    private static final double LAB_COST_PER_EXPERIMENT = 25_000;
    private static final double SOLAR_COST_PER_PANEL = 4_000;
    private static final double CARGO_BAY_COST_PER_TON = 1_500;

    private double totalCost;

    @Override
    public void visitHabitat(HabitatModule habitat) {
        totalCost += HABITAT_BASE_COST + habitat.getCrewCapacity() * HABITAT_COST_PER_CREW_SEAT;
    }

    @Override
    public void visitLaboratory(LaboratoryModule laboratory) {
        totalCost += LAB_BASE_COST + laboratory.getExperimentCount() * LAB_COST_PER_EXPERIMENT;
    }

    @Override
    public void visitSolarArray(SolarArray solarArray) {
        totalCost += solarArray.getPanelCount() * SOLAR_COST_PER_PANEL;
    }

    @Override
    public void visitCargoBay(CargoBay cargoBay) {
        totalCost += cargoBay.getCapacityTons() * CARGO_BAY_COST_PER_TON;
    }

    public double getTotalCost() {
        return totalCost;
    }
}

