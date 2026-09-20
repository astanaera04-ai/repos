package univ_assignments.SDP_ASS_2.abstractfactory;

import univ_assignments.SDP_ASS_2.factorymethod.Weapon;

public class OrcAxe implements Weapon {

    @Override
    public String getName() {
        return "Orc Battle Axe";
    }

    @Override
    public String attack() {
        return "delivers a brutal, heavy chop";
    }
}
