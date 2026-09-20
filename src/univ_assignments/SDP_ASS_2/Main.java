package univ_assignments.SDP_ASS_2;

import univ_assignments.SDP_ASS_2.abstractfactory.EquipmentFactory;
import univ_assignments.SDP_ASS_2.abstractfactory.EquipmentFactoryProvider;
import univ_assignments.SDP_ASS_2.abstractfactory.HeroEquipper;
import univ_assignments.SDP_ASS_2.factorymethod.BowCreator;
import univ_assignments.SDP_ASS_2.factorymethod.SwordCreator;
import univ_assignments.SDP_ASS_2.factorymethod.WeaponCreator;

public class Main {

    public static void main(String[] args) {
        demonstrateFactoryMethod();
        demonstrateAbstractFactory();
        demonstrateInvalidFaction();
    }

    private static void demonstrateFactoryMethod() {
        System.out.println("---- Part A: Factory Method ----\n");

        WeaponCreator swordCreator = new SwordCreator();
        WeaponCreator bowCreator = new BowCreator();

        System.out.println(swordCreator.forge());
        System.out.println(bowCreator.forge());
        System.out.println();
    }

    private static void demonstrateAbstractFactory() {
        System.out.println("---- Part B: Abstract Factory ----\n");

        HeroEquipper equipper = new HeroEquipper();
        EquipmentFactory elfFactory = EquipmentFactoryProvider.getFactory("elf");
        EquipmentFactory orcFactory = EquipmentFactoryProvider.getFactory("orc");

        System.out.println("Elf hero: " + equipper.equip(elfFactory));
        System.out.println("Orc hero: " + equipper.equip(orcFactory));
        System.out.println();
    }

    private static void demonstrateInvalidFaction() {
        System.out.println("---- Client: invalid faction is rejected ----\n");

        try {
            EquipmentFactoryProvider.getFactory("dwarf");
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}