public class Abstraction {
    public static void main(String[] args){
        BankAccount account = new SavingAccount();

        account.deposit(1000);
        account.withdraw(300);

        System.out.println("Final Balance: " + account.getBalance());


    }
}

    // 🔵 ABSTRACT CLASS (ABSTRACTION STARTS HERE)

    abstract class BankAccount{
        protected double balance;

            // Abstract methods (WHAT to do, not HOW)

        abstract void deposit(double amount);
        abstract void withdraw(double amount);

            // Concrete method

        public double getBalance(){
            return balance;
        }
    }
    // 🔵 CONCRETE CLASS (IMPLEMENTATION)
   
    class SavingAccount extends BankAccount{
        @Override
        void deposit(double amount ){
            if(amount <= 0){
                 System.out.println("Invalid deposit amount");
                 return ;

            }
            balance += amount;
            System.out.println("Deposited: " + amount);
        }

        @Override
        void withdraw(double amount) {
           if (amount <= 0 || amount > balance) {
            System.out.println("Invalid withdrawal");
            return;
           }
           balance -= amount;
           System.out.println("Withdrawn: " + amount);
    }

    }
    

