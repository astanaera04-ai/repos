package Hospital_OOP;

import java.sql.SQLOutput;

public class Patient extends Person implements Treatable {
    private String diagnosis;
    private int roomNumber;
    private boolean isTreated;
    public Patient(String name, int age, int id, String diagnosis, int roomNumber) {
        super(name, age, id);
        this.diagnosis = diagnosis;
        this.roomNumber = roomNumber;
        this.isTreated = false; // ← автоматты
    }
    public String getDiagnosis(){
        return diagnosis;
    }
    public int getRoomNumber(){
        return roomNumber;
    }
    public boolean getIsTreat(){
        return isTreated;
    }
    @Override
    public void treat(){
        isTreated = true;
        System.out.println(getName() + " емделді! ✅");
    }

    @Override
    public void discharge() {
        if (isTreated) {
            System.out.println(getName() + " ауруханадан шығарылды! 🏥");
        } else {
            System.out.println("❌ " + getName() + " әлі емделген жоқ!");
        }
    }
    @Override
    public void getInfo(){
        System.out.println("👤 Науқас: " + getName());
        System.out.println("   Жасы: " + getAge());
        System.out.println("   Диагноз: " + diagnosis);
        System.out.println("   Палата: " + roomNumber);
        System.out.println("   Емделді: " + (isTreated ? "Иә ✅" : "Жоқ ❌"));
    }
    @Override
    public void introduce() {
        System.out.println("Сәлем! Мен " + getName() + ", диагнозым: " + diagnosis);
    }
}
