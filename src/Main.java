import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       MedicationTrackingSystem system = new MedicationTrackingSystem();
       try (Scanner sc = new Scanner(System.in)) {

           while (true) {
           System.out.println("\n=== PHARMACY SYSTEM ===");
           System.out.println("1. Add Patient");
           System.out.println("2. Add Doctor");
           System.out.println("3. Add Medication");
           System.out.println("4. Generate Report");
           System.out.println("5. Check Expired Meds");
           System.out.println("6. Restock");
           System.out.println("0. Exit");

           int choice = sc.nextInt();

           switch (choice) {
               case 1: {
                   System.out.print("ID: ");
                   int pid = sc.nextInt();
                   sc.nextLine();
                   System.out.print("Name: ");
                   String pname = sc.nextLine();

                   system.addPatient(new Patient(pid, pname, 25, "000"));
                   break;
               }

               case 2: {
                   System.out.print("ID: ");
                   int did = sc.nextInt();
                   sc.nextLine();
                   System.out.print("Name: ");
                   String dname = sc.nextLine();
                   System.out.print("Specialization: ");
                   String spec = sc.nextLine();

                   system.addDoctor(new Doctor(did, dname, 40, "000", spec));
                   break;
               }

               case 3: {
                   System.out.print("ID: ");
                   int mid = sc.nextInt();
                   sc.nextLine();
                   System.out.print("Name: ");
                   String mname = sc.nextLine();
                   System.out.print("Dose: ");
                   String dose = sc.nextLine();

                   system.addMedication(new Medication(mid, mname, dose, 50));
                   break;
               }

               case 4:
                   system.systemReport();
                   break;

               case 5:
                   system.expiredMedicationsReport();
                   break;

               case 6: {
                   system.restockAll(10);
                   System.out.println("Restocked!");
                   break;
               }

               case 0:
                   return;
           }
       }
   }

}
}