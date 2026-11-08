package univ_assignments.SDP_ASS_6;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * Concrete visitor #2: safety inspection.
 * Single operation: collect safety findings for every module type.
 */
public class SafetyInspectionVisitor implements StationVisitor {

    private static final int MAX_SAFE_HABITAT_AGE_YEARS = 15;
    private static final int MIN_SAFE_PANEL_EFFICIENCY_PERCENT = 80;
    private static final double MAX_SAFE_CARGO_LOAD_RATIO = 0.9;

    private final List<String> findings = new ArrayList<>();

    @Override
    public void visitHabitat(HabitatModule habitat) {
        if (habitat.getAgeInYears() > MAX_SAFE_HABITAT_AGE_YEARS) {
            findings.add(habitat.getName() + ": hull is " + habitat.getAgeInYears()
                    + " years old, schedule a structural check");
        }
    }

    @Override
    public void visitLaboratory(LaboratoryModule laboratory) {
        if (laboratory.hasHazardousMaterials()) {
            findings.add(laboratory.getName() + ": hazardous materials, verify containment");
        }
    }

    @Override
    public void visitSolarArray(SolarArray solarArray) {
        if (solarArray.getEfficiencyPercent() < MIN_SAFE_PANEL_EFFICIENCY_PERCENT) {
            findings.add(solarArray.getName() + ": efficiency dropped to "
                    + solarArray.getEfficiencyPercent() + "%, panels degraded");
        }
    }

    @Override
    public void visitCargoBay(CargoBay cargoBay) {
        double loadRatio = cargoBay.getStoredTons() / cargoBay.getCapacityTons();
        if (loadRatio > MAX_SAFE_CARGO_LOAD_RATIO) {
            findings.add(String.format(Locale.US, "%s: loaded to %.0f%%, risk of overload",
                    cargoBay.getName(), loadRatio * 100));
        }
    }

    public List<String> getFindings() {
        return Collections.unmodifiableList(findings);
    }
}
