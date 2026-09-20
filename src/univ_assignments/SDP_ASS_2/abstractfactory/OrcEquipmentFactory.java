package univ_assignments.SDP_ASS_2.abstractfactory;

import univ_assignments.SDP_ASS_2.factorymethod.Weapon;

public class OrcEquipmentFactory implements EquipmentFactory {

    @Override
    public Weapon createWeapon() {
        return new OrcAxe();
    }

    @Override
    public Armor createArmor() {
        return new OrcPlateArmor();
    }
}
