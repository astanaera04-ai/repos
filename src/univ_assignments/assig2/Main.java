public class Main {
    public static void main(String[] args) {

        Shelter shelter = new Shelter("Happy Paws", "Almaty");

        Pet dog = new Dog(1, "Rex", 3, "Healthy");
        Pet cat = new Cat(2, "Murka", 2, "Injured");

        shelter.addPet(dog);
        shelter.addPet(cat);

        shelter.showAllPets();

        shelter.sortByAge();
        shelter.showAllPets();

        System.out.println("Searching Murka:");
        System.out.println(shelter.searchByName("Murka"));

        Adopter adopter = new Adopter(101, "Aidos", "87001112233", "Dog");
        adopter.adoptPet(dog);

        adopter.showAdoptedPets();

        dog.makeSound();
        cat.makeSound();
    }
}
