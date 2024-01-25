import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // Method to find an account by account number
    Account findByAccountNumber(String accountNumber);

    // Additional methods for custom queries related to accounts, if needed
    // For example: List<Account> findByBalanceGreaterThan(double balance);
}
