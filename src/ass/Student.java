package ass;

public class Student extends  Person{
    private int studentId;
    private String major;

    public Student(String name, int age,int studentId,String major){
        super(name,age);
        this.studentId=studentId;
        this.major=major;
    }
    public int getStudentId(){
        return studentId;
    }
    public void setStudentId(int studentId){
        this.studentId=studentId;
    }
    public String getMajor(){
        return major;
    }
    public void setMajor(String major){
        this.major = major;
    }
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Student ID: " + studentId);
        System.out.println("Major: " + major);
        System.out.println("----------------------------");
    }
}
