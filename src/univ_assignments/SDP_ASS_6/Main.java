package univ_assignments.SDP_ASS_6;

import java.util.Locale;

/** Client: builds the object structure and runs different visitors over it. */
public class Main {

    public static void main(String[] args) {
        SpaceStation station = buildStation();

        printHeader("Power balance");
        PowerBalanceVisitor power = new PowerBalanceVisitor();
        station.accept(power);
        System.out.printf(Locale.US, "Produced: %.1f kW%n", power.getProducedKw());
        System.out.printf(Locale.US, "Consumed: %.1f kW%n", power.getConsumedKw());
        System.out.printf(Locale.US, "Net:      %.1f kW%n", power.getNetKw());

        printHeader("Safety inspection");
        SafetyInspectionVisitor safety = new SafetyInspectionVisitor();
        station.accept(safety);
        safety.getFindings().forEach(finding -> System.out.println("! " + finding));

        printHeader("Yearly maintenance cost");
        MaintenanceCostVisitor cost = new MaintenanceCostVisitor();
        station.accept(cost);
        System.out.printf(Locale.US, "Total: $%,.0f%n", cost.getTotalCost());

        printHeader("Extensibility: 4th visitor added without changing any element");
        CrewCapacityVisitor crew = new CrewCapacityVisitor();
        station.accept(crew);
        System.out.println("Total crew seats: " + crew.getTotalSeats());
    }

    private static SpaceStation buildStation() {
        return new SpaceStation("Orbital-7")
                .addModule(new HabitatModule("Alpha Habitat", 6, 18.0, 18))
                .addModule(new HabitatModule("Beta Habitat", 4, 12.5, 6))
                .addModule(new LaboratoryModule("Bio Lab", 5, 14.0, true))
                .addModule(new LaboratoryModule("Optics Lab", 3, 9.0, false))
                .addModule(new SolarArray("Solar Wing North", 40, 60.0, 92))
                .addModule(new SolarArray("Solar Wing South", 40, 60.0, 74))
                .addModule(new CargoBay("Cargo Bay 1", 19.0, 20.0))
                .addModule(new CargoBay("Cargo Bay 2", 8.0, 20.0));
    }

    private static void printHeader(String title) {
        System.out.println();
        System.out.println("=== " + title + " ===");
    }
}
