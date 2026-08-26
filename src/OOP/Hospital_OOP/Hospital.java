package OOP.Hospital_OOP;

import java.util.ArrayList;

public class Hospital {
    private String hospitalName;
    private ArrayList<Patient> patients = new ArrayList<>();
    private ArrayList<Doctor> doctors = new ArrayList<>();

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public void admitPatient(Patient patient) {
        patients.add(patient);
        System.out.println("✅ " + patient.getName() + " ауруханаға қабылданды!");
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println("✅ Дәрігер " + doctor.getName() + " қосылды!");
    }

    public Doctor findDoctor(String specialty) throws DoctorNotFoundException {
        for (Doctor d : doctors) {
            if (d.getSpecialty().equals(specialty)) {
                return d;
            }
        }
        throw new DoctorNotFoundException("❌ " + specialty + " дәрігері табылмады!");
    }

    public void assignDoctor(Patient patient, String specialty) {
        try {
            Doctor doctor = findDoctor(specialty);
            doctor.addPatient(patient);
        } catch (DoctorNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    public void showAll() {
        System.out.println("=============================");
        System.out.println("🏥 Аурухана: " + hospitalName);
        System.out.println("=============================");

        System.out.println("\n👨‍⚕️ Дәрігерлер:");
        for (Doctor d : doctors) {
            d.introduce();
        }

        System.out.println("\n🛏️ Науқастар:");
        for (Patient p : patients) {
            p.getInfo();
        }
    }


 }
