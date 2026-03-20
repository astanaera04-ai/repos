package ass;

public class Main {
    public static void main(String[] args) {

        Student student = new Student("Aidos", 20, 101, "Computer Science");
        Professor professor = new Professor("Dr. Ali", 45, 202, "Software Engineering");
        Staff staff = new Staff("Marat", 35, 303, "Administrator");

        student.displayInfo();
        professor.displayInfo();
        staff.displayInfo();
    }
}
