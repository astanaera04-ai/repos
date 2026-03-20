package ass;

public class Staff extends Person {

    private int staffId;
    private String role;

    public Staff(String name, int age, int staffId, String role){
        super(name, age);
        this.staffId = staffId;
        this.role = role;
    }

    public int getStaffId(){
        return staffId;
    }

    public String getRole(){
        return role;
    }

    public void setStaffId(int staffId){
        this.staffId = staffId;
    }

    public void setRole(String role){
        this.role = role;
    }

    public void displayInfo(){
        super.displayInfo();
        System.out.println("Staff ID: " + staffId);
        System.out.println("Role: " + role);
        System.out.println("----------------------------");
    }
}
