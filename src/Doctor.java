import java.util.ArrayList;

public class Doctor extends Person {

    private String specialization;
    private ArrayList<Patient> patients;

    public Doctor(int id,
                  String name,
                  int age,
                  String phoneNumber,
                  String specialization) {

        super(id, name, age, phoneNumber);

        this.specialization = specialization;
        patients = new ArrayList<>();
    }

    public String getSpecialization() {
        return specialization;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    @Override
    public String toString() {

        return "Doctor -> " +
                super.toString() +
                ", Specialization: " +
                specialization +
                ", Patients Managed: " +
                patients.size();
    }
}

