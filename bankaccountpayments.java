import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentAuthorizationService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional
    public void authorizePayment(String accountNumber, double amount) {
        validatePaymentAmount(amount);

        // Fetch the account associated with the provided account number
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Account not found for account number: " + accountNumber);
        }

        // Create a payment object and save it to the database
        Payment payment = new Payment();
        payment.setAccount(account);
        payment.setAmount(amount);
        payment.setStatus(PaymentStatus.AUTHORIZED);
        paymentRepository.save(payment);

        // Update the account balance
        double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);
        accountRepository.save(account);
    }


    private void validatePaymentAmount(double amount) {
        if (amount <= 0) {
            throw new InvalidPaymentAmountException("Payment amount must be greater than zero.");
        }
    }
}
