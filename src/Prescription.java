import java.time.LocalDate;

public class Prescription {
  // Variables

  private int id;
  private Doctor doctor;
  private Patient patient;
  private Medication medication;
  private LocalDate Issuedate;
  private LocalDate expirydate;

  // Constructor

  public Prescription(int id, Doctor doctor, Patient patient, Medication medication){
    this.id = id;
    this.doctor = doctor;
    this.patient = patient;
    this.medication = medication;

    this.Issuedate = LocalDate.now();
    this.expirydate = Issuedate.plusYears(1);
  }

  // Getters 

  public Doctor getDoctor() {
    return doctor;
  }

  public Patient getPatient() {
    return patient;
  }

  public Medication getMedication() {
    return medication;
  }

  // Display the perscription 

     public void display() {
       System.out.println("Prescription ID: " + id);
       System.out.println("Doctor: " + doctor.getName());
       System.out.println("Patient: " + patient.getName());
       System.out.println("Medication: " + medication.getName());
       System.out.println("Expires: " + expirydate);
   }

}
