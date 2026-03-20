package postgr;

public class pet {

    private int id;
    private String name;
    private int age;
    private String status;

    public pet(int id, String name, int age, String status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.status = status;
    }

    public pet(String name, int age, String status) {
        this.name = name;
        this.age = age;
        this.status = status;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return "Pet{id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", status='" + status + '\'' +
                '}';
    }
}
