import java.util.ArrayList;
import java.util.List;

public class Adopter {

    private int id;
    private String name;
    private String phone;
    private String preferredPetType;
    private List<Pet> adoptedPets = new ArrayList<>();

    public Adopter(int id, String name, String phone, String preferredPetType) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.preferredPetType = preferredPetType;
    }

    public void adoptPet(Pet pet){
        adoptedPets.add(pet);
        System.out.println(name + " adopted " + pet.getName());
    }

    public void showAdoptedPets(){
        System.out.println(name + " adopted pets:");
        for(Pet p : adoptedPets){
            System.out.println(p);
        }
    }
}
