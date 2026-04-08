package univ_assignments.postgr;

public class Main {

    public static void main(String[] args) {

        PetRepository repo = new PetRepository();

        repo.addPet(new pet("Rex", 3, "Healthy"));
        repo.addPet(new pet("Murka", 2, "Injured"));

        System.out.println("All pets:");
        repo.getAllPets().forEach(System.out::println);

        repo.updatePetStatus(1, "Adopted");

        repo.deletePet(2);

        

    }
}
