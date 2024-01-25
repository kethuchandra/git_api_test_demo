import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;

    private double balance;

    // Constructors, getters and setters, other fields, and methods as needed

    // Example method to deduct an amount from the balance
    public void deductAmount(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            // Handle insufficient balance scenario
            throw new InsufficientBalanceException("Insufficient balance to deduct amount: " + amount);
        }
    }
}
