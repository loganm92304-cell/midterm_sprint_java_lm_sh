import java.util.ArrayList;

public class Patient extends Person {

    private ArrayList<Medication> medications;
    private ArrayList<Prescription> prescriptions;

    public Patient(int id,
                   String name,
                   int age,
                   String phoneNumber) {

        super(id, name, age, phoneNumber);

        medications = new ArrayList<>();
        prescriptions = new ArrayList<>();
    }

    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    public ArrayList<Medication> getMedications() {
        return medications;
    }

    public ArrayList<Prescription> getPrescriptions() {
        return prescriptions;
    }

    @Override
    public String toString() {
        return "Patient -> " + super.toString();
    }
}