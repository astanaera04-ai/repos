package draft;

public class Student {
    String name;
    int grade;

    public Student(String name, int grade){
        this.name = name;
        this.grade = grade;
    }
    static void main(String[] args) {


        Student[] students = {
                new Student("Алибек", 90),
                new Student("Айша", 75),
                new Student("Нұрлан", 85),
                new Student("Бек", 60),
                new Student("Дана", 95)
        };
        for(Student s: students){
            System.out.println(s.name + "---" + s.grade);
        }
    }
}
