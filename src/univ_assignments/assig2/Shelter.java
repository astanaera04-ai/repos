import java.util.*;

public class Shelter {

    private String shelterName;
    private String location;
    private List<Pet> pets = new ArrayList<>();

    public Shelter(String shelterName, String location) {
        this.shelterName = shelterName;
        this.location = location;
    }

    public void addPet(Pet pet){
        pets.add(pet);
        System.out.println(pet.getName() + " added to shelter");
    }

    public void removePet(int id){
        pets.removeIf(p -> p.getId() == id);
        System.out.println("Pet removed with id: " + id);
    }

    public Pet searchByName(String name){
        for(Pet p : pets){
            if(p.getName().equalsIgnoreCase(name)){
                return p;
            }
        }
        return null;
    }

    public List<Pet> filterByType(String type){
        List<Pet> result = new ArrayList<>();
        for(Pet p : pets){
            if(p.getType().equalsIgnoreCase(type)){
                result.add(p);
            }
        }
        return result;
    }

    public void sortByAge(){
        pets.sort(Comparator.comparingInt(Pet::getAge));
        System.out.println("Pets sorted by age");
    }

    public void showAllPets(){
        for(Pet p : pets){
            System.out.println(p);
        }
    }
}
