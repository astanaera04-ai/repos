package univ_assignments.SDP_ASS_2.abstractfactory;

import univ_assignments.SDP_ASS_2.factorymethod.Weapon;

public class HeroEquipper {

    public String equip(EquipmentFactory factory) {
        Weapon weapon = factory.createWeapon();
        Armor armor = factory.createArmor();
        return "Equipped with " + weapon.getName() + " (" + weapon.attack() + ") and "
                + armor.getName() + " [defense " + armor.getDefenseRating() + "]";
    }
}