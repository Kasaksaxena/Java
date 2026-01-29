public class Encapsulation {

    public static void main(String[] args) {

        Account account = new Account();

        // Deposit money
        account.deposit(1000);
        System.out.println("Balance after deposit: " + account.getBalance());

        // Try invalid deposit
        account.deposit(-500);

        // Withdraw money
        account.withdraw(300);
        System.out.println("Balance after withdrawal: " + account.getBalance());

        // Try invalid withdrawal
        account.withdraw(1000);
    }
}

// Encapsulated class
class Account {

    // Data hiding
    private double balance;

    // Getter (read-only access)
    public double getBalance() {
        return balance;
    }

    // Deposit with validation
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount");
            return;
        }
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    // Withdrawal with validation
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance");
            return;
        }

        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }
}
