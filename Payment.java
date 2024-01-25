import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Account account;

    private double amount;

    private PaymentStatus status;

    // Constructors, getters and setters, other fields, and methods as needed

    // Example method to update payment status
    public void updateStatus(PaymentStatus newStatus) {
        this.status = newStatus;
    }
}
