package ass;

public class Professor extends Person {
    private int professorId;
    private String department;

    public Professor(String name, int age, int professorId, String
            department){
        super(name, age );
        this.professorId=professorId;
        this.department=department;
    }

    public int getProfessorId(){
        return professorId;
    }
    public void setProfessorId(int professorId){
        this.professorId=professorId;
    }
    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department = department;
    }

    public void displayInfo(){
        super.displayInfo();
        System.out.println("Professor ID:"+professorId);
        System.out.println("Department"+department);
        System.out.println("----------------------------");
    }

}
