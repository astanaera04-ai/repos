package univ_assignments.SDP_ASS_2.abstractfactory;

import univ_assignments.SDP_ASS_2.factorymethod.Weapon;

public class ElfEquipmentFactory implements EquipmentFactory {

    @Override
    public Weapon createWeapon() {
        return new ElfBow();
    }

    @Override
    public Armor createArmor() {
        return new ElfLeatherArmor();
    }
}