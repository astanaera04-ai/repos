package univ_assignments.SDP_ASS_2.abstractfactory;

public final class EquipmentFactoryProvider {

    private static final String ELF_FACTION = "elf";
    private static final String ORC_FACTION = "orc";

    private EquipmentFactoryProvider() {
    }

    public static EquipmentFactory getFactory(String faction) {
        if (faction == null || faction.isBlank()) {
            throw new IllegalArgumentException("Faction must not be blank");
        }
        String normalized = faction.trim().toLowerCase();
        if (normalized.equals(ELF_FACTION)) {
            return new ElfEquipmentFactory();
        }
        if (normalized.equals(ORC_FACTION)) {
            return new OrcEquipmentFactory();
        }
        throw new IllegalArgumentException("Unknown faction: " + faction);
    }
}
