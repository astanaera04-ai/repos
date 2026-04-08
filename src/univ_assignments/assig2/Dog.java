public class Dog extends Pet {

    public Dog(int id, String name, int age, String healthStatus) {
        super(id, name, "Dog", age, healthStatus);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says Woof!");
    }
}
