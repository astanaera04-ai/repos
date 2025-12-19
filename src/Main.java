public class Main {
    public static void main(String[] args) {

        Pet pet1 = new Pet("Buddy", "Dog", 3);
        Pet pet2 = new Pet("Misty", "Cat", 2);

        Adopter adopter = new Adopter("Ali", 25);

        Shelter shelter = new Shelter("Happy Paws", "Almaty");

        shelter.showShelterInfo();
        System.out.println();

        pet1.showInfo();
        System.out.println();

        pet2.showInfo();
        System.out.println();

        if (pet1.getAge() > pet2.getAge()) {
            System.out.println(pet1.getName() + " is older than " + pet2.getName());
        } else {
            System.out.println(pet2.getName() + " is older than " + pet1.getName());
        }

        System.out.println();
        adopter.adoptPet(pet1);
    }
}
