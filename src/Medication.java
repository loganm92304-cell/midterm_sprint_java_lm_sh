import java.time.LocalDate;
import java.util.Random;

public class Medication {

    private int id;
    private String name;
    private String dose;
    private int quantityInStock;
    private LocalDate expiryDate;

    public Medication(int id,
                      String name,
                      String dose,
                      int quantityInStock) {

        this.id = id;
        this.name = name;
        this.dose = dose;
        this.quantityInStock = quantityInStock;

        Random random = new Random();

        // Creates dates that may be expired
        int randomDays = random.nextInt(1000) - 500;

        expiryDate = LocalDate.now().plusDays(randomDays);
    }

    // Getters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDose() {
        return dose;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    public void restock(int amount) {
        quantityInStock += amount;
    }

    @Override
    public String toString() {

        return "Medication ID: " + id +
                ", Name: " + name +
                ", Dose: " + dose +
                ", Stock: " + quantityInStock +
                ", Expiry: " + expiryDate;
    }
}