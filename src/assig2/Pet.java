public abstract class Pet {

    private int id;
    private String name;
    private String type;
    private int age;
    private String healthStatus;

    public Pet(int id, String name, String type, int age, String healthStatus) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.age = age;
        this.healthStatus = healthStatus;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getType() {return type;}
    public void setType(String type) {this.type = type;}

    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}

    public String getHealthStatus() {return healthStatus;}
    public void setHealthStatus(String healthStatus) {this.healthStatus = healthStatus;}

    public abstract void makeSound(); // Polymorphism

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", age=" + age +
                ", healthStatus='" + healthStatus + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Pet)) return false;
        Pet other = (Pet) obj;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
