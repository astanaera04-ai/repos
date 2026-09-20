package univ_assignments.SDP_ASS_2.factorymethod;

public class SwordCreator extends WeaponCreator {

    @Override
    public Weapon createWeapon() {
        return new Sword();
    }
}