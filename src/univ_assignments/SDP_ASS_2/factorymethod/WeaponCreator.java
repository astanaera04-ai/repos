package univ_assignments.SDP_ASS_2.factorymethod;

public abstract class WeaponCreator {

    public abstract Weapon createWeapon();

    public String forge() {
        Weapon weapon = createWeapon();
        return "Forged a " + weapon.getName() + " - it " + weapon.attack() + ".";
    }
}