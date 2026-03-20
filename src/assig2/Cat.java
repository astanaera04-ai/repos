public class Cat extends Pet {

    public Cat(int id, String name, int age, String healthStatus) {
        super(id, name, "Cat", age, healthStatus);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says Meow!");
    }
}
