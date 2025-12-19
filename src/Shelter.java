public class Shelter {
    private String shelterName;
    private String location;

    public Shelter(String shelterName, String location) {
        this.shelterName = shelterName;
        this.location = location;
    }

    public String getShelterName() {
        return shelterName;
    }

    public void setShelterName(String shelterName) {
        this.shelterName = shelterName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void showShelterInfo() {
        System.out.println("Shelter: " + shelterName);
        System.out.println("Location: " + location);
    }
}
