package univ_assignments.SDP_ASS_6;

/**
 * Concrete visitor #4: added LATER to prove extensibility.
 * No element class, no interface of the elements and no other visitor was changed.
 */
public class CrewCapacityVisitor implements StationVisitor {

    private int totalSeats;

    @Override
    public void visitHabitat(HabitatModule habitat) {
        totalSeats += habitat.getCrewCapacity();
    }

    @Override
    public void visitLaboratory(LaboratoryModule laboratory) {
        // laboratories have no crew seats
    }

    @Override
    public void visitSolarArray(SolarArray solarArray) {
        // no crew seats
    }

    @Override
    public void visitCargoBay(CargoBay cargoBay) {
        // no crew seats
    }

    public int getTotalSeats() {
        return totalSeats;
    }
}
