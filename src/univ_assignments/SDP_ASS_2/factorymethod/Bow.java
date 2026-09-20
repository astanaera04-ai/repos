package univ_assignments.SDP_ASS_2.factorymethod;

public class Bow implements Weapon {

    @Override
    public String getName() {
        return "Bow";
    }

    @Override
    public String attack() {
        return "shoots an arrow from a distance";
    }
}