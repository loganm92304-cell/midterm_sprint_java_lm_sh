import java.util.ArrayList;
import java.util.List;

public class MedicationTrackingSystem {
    // Variables 

    private final List<Patient> patients = new ArrayList<>();
    private final List<Doctor> doctors = new ArrayList<>();
    private final List<Medication> medications = new ArrayList<>();
    private final List<Prescription> prescriptions = new ArrayList<>();

   // Methods
   
   public void addPatient(Patient p){
    patients.add(p);
   }

   public void addDoctor(Doctor d){
    doctors.add(d);
   }

   public void addMedication(Medication m){
    medications.add(m);
   }

 
   // Search 
    
   public Patient findPatient(String name) {
       return patients.stream()
               .filter(p -> p.getName().equalsIgnoreCase(name))
               .findFirst().orElse(null);
   }

   public Doctor findDoctor(String name) {
       return doctors.stream()
               .filter(d -> d.getName().equalsIgnoreCase(name))
               .findFirst().orElse(null);
   }

   public Medication findMedication(String name) {
       return medications.stream()
               .filter(m -> m.getName().equalsIgnoreCase(name))
               .findFirst().orElse(null);
   }

   // PRESCRIPTION
    
   public void addPrescription(Prescription p) {
       prescriptions.add(p);
       p.getPatient().addPrescription(p);
       p.getDoctor().addPatient(p.getPatient());
   }


   // Reports

      public void expiredMedicationsReport() {
       System.out.println("=== EXPIRED MEDICATIONS ===");
       for (Medication m : medications) {
           if (m.isExpired()) {
               System.out.println(m);
           }
       }
   }

   public void systemReport() {
       System.out.println("Doctors: " + doctors.size());
       System.out.println("Patients: " + patients.size());
       System.out.println("Medications: " + medications.size());
       System.out.println("Prescriptions: " + prescriptions.size());
   }

   public void restockAll(int amount) {
       for (Medication m : medications) {
           m.restock(amount);
       }
   }

   public void prescriptionsByDoctor(String name) {
       for (Prescription p : prescriptions) {
           if (p.getDoctor().getName().equalsIgnoreCase(name)) {
               p.display();
           }
       }
   }
}