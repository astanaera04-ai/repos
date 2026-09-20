package univ_assignments.SDP_ASS_2.abstractfactory;

public class ElfLeatherArmor implements Armor {

    private static final int DEFENSE_RATING = 15;

    @Override
    public String getName() {
        return "Elven Leather Armor";
    }

    @Override
    public int getDefenseRating() {
        return DEFENSE_RATING;
    }
}
