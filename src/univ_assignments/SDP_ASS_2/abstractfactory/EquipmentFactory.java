package univ_assignments.SDP_ASS_2.abstractfactory;

import univ_assignments.SDP_ASS_2.factorymethod.Weapon;

public interface EquipmentFactory {
    Weapon createWeapon();
    Armor createArmor();
}