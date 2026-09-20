package univ_assignments.SDP_ASS_2.abstractfactory;

public class OrcPlateArmor implements Armor {

    private static final int DEFENSE_RATING = 30;

    @Override
    public String getName() {
        return "Orc Plate Armor";
    }

    @Override
    public int getDefenseRating() {
        return DEFENSE_RATING;
    }
}