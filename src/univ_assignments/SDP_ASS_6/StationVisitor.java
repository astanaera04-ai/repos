package univ_assignments.SDP_ASS_6;
/**
 * Visitor interface: one visitX() method per concrete element type.
 * The overloads are resolved at compile time from the static type of the
 * argument, which is what makes the double-dispatch step in accept() work.
 */
public interface StationVisitor {

    void visitHabitat(HabitatModule habitat);

    void visitLaboratory(LaboratoryModule laboratory);

    void visitSolarArray(SolarArray solarArray);

    void visitCargoBay(CargoBay cargoBay);
}
