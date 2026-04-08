package Hospital_OOP;

public class Main {
    public static void main(String[] args) {

        Hospital hospital = new Hospital("Астана Медицина");

        Doctor doctor1 = new Doctor("Асқар Сейтқали", 45, 1, "Хирург");
        Doctor doctor2 = new Doctor("Айгүл Бекова", 38, 2, "Терапевт");
        Doctor doctor3 = new Doctor("Нұрлан Әлиев", 50, 3, "Кардиолог");

        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);
        hospital.addDoctor(doctor3);

        System.out.println();

        Patient patient1 = new Patient("Болат Жақсыбеков", 35, 101, "Аппендицит", 1);
        Patient patient2 = new Patient("Зарина Мұсаева", 28, 102, "Грипп", 2);
        Patient patient3 = new Patient("Ержан Қасымов", 60, 103, "Жүрек ауруы", 3);
        Patient patient4 = new Patient("Дана Серікова", 22, 104, "Грипп", 2);

        hospital.admitPatient(patient1);
        hospital.admitPatient(patient2);
        hospital.admitPatient(patient3);
        hospital.admitPatient(patient4);

        System.out.println();

        hospital.assignDoctor(patient1, "Хирург");
        hospital.assignDoctor(patient2, "Терапевт");
        hospital.assignDoctor(patient3, "Кардиолог");
        hospital.assignDoctor(patient4, "Терапевт");

        System.out.println();

        doctor1.treatAll();
        doctor2.treatAll();
        doctor3.treatAll();

        System.out.println();

        System.out.println("=== Науқастарды шығару ===");
        patient1.discharge();
        patient2.discharge();
        patient3.discharge();
        patient4.discharge();

        System.out.println();

        hospital.showAll();

        System.out.println();

        System.out.println("=== Exception тексеру ===");
        hospital.assignDoctor(patient1, "Невролог"); // ❌ Невролог жоқ!
    }
}