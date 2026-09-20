package univ_assignments.SDP_ASS_2.factorymethod;

public class Sword implements Weapon {

    @Override
    public String getName() {
        return "Sword";
    }

    @Override
    public String attack() {
        return "slashes fiercely at close range";
    }
}