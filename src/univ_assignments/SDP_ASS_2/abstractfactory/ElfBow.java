package univ_assignments.SDP_ASS_2.abstractfactory;

import univ_assignments.SDP_ASS_2.factorymethod.Weapon;

public class ElfBow implements Weapon {

    @Override
    public String getName() {
        return "Elven Bow";
    }

    @Override
    public String attack() {
        return "fires a silent, precise arrow";
    }
}