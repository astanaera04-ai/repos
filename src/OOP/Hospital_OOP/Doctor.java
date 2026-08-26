package OOP.Hospital_OOP;

import java.util.ArrayList;

public class Doctor extends Person{
        private String specialty;
        private ArrayList<Patient> patients = new ArrayList<>();

        public Doctor(String name, int age, int id, String specialty) {
                super(name, age, id);
                this.specialty = specialty;
        }

        public String getSpecialty(){
                return specialty;
        }

        public void addPatient(Patient patient){
                patients.add(patient);
                System.out.println(patient.getName() + " → " + getName() + "-ға тағайындалды!");
        }

        public void treatAll() {
                System.out.println("=== " + getName() + " емдеп жатыр ===");
                for (Patient p : patients) {
                        p.treat();
                }
        }

        public void showPatients() {
                System.out.println("=== " + getName() + " науқастары ===");
                for (Patient p : patients) {
                        p.getInfo();
                }
        }

        @Override
        public void introduce() {
                System.out.println("Сәлем! Мен дәрігер " + getName() + ", мамандығым: " + specialty);
        }

}
