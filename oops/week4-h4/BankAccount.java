import java.util.Random;

public class BankAccount {
    String accountHolder;
    int accountNumber;
    double balance;

    BankAccount() {
        this.accountHolder = "Unknown";
        this.accountNumber = generateAccountNumber();
        this.balance = 0;
    }

    BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
        this.accountNumber = generateAccountNumber();
        this.balance = 0;
    }

    BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = generateAccountNumber();
        this.balance = balance;
    }

    private int generateAccountNumber() {
        Random rand = new Random();
        return 100000 + rand.nextInt(900000); // generates a 6-digit account number
    }

    void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Deposited: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    void displayAccount() {
        System.out.println("----- Bank Account -----");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
        System.out.println("------------------------\n");
    }
        public static void main(String[] args) {
        BankAccount acc1 = new BankAccount();
        BankAccount acc2 = new BankAccount("Varad");
        BankAccount acc3 = new BankAccount("Riya", 5000);

        acc1.deposit(1000);
        acc1.withdraw(200);
        acc1.displayAccount();

        acc2.deposit(3000);
        acc2.withdraw(500);
        acc2.displayAccount();

        acc3.deposit(2000);
        acc3.withdraw(1000);
        acc3.displayAccount();
    }
}

