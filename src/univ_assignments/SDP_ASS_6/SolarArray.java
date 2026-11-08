package univ_assignments.SDP_ASS_6;

/** Concrete element: solar panel array that produces power. Immutable. */
public final class SolarArray implements StationModule {

    private final String name;
    private final int panelCount;
    private final double outputKw;
    private final int efficiencyPercent;

    public SolarArray(String name, int panelCount, double outputKw, int efficiencyPercent) {
        this.name = name;
        this.panelCount = panelCount;
        this.outputKw = outputKw;
        this.efficiencyPercent = efficiencyPercent;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getPanelCount() {
        return panelCount;
    }

    public double getOutputKw() {
        return outputKw;
    }

    public int getEfficiencyPercent() {
        return efficiencyPercent;
    }

    @Override
    public void accept(StationVisitor visitor) {
        visitor.visitSolarArray(this);
    }
}
