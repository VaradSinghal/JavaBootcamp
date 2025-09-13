public class SecureBankAccount {
    private final String accountNumber;
    private double balance;
    private int pin;
    private boolean isLocked;
    private int failedAttempts;

    private static final int MAX_FAILED_ATTEMPTS = 3;
    private static final double MIN_BALANCE = 0.0;

    public SecureBankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = Math.max(initialBalance, MIN_BALANCE);
        this.pin = 0;
        this.isLocked = false;
        this.failedAttempts = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        if (isLocked) {
            System.out.println("Account is locked. Cannot view balance.");
            return -1;
        }
        return balance;
    }

    public boolean isAccountLocked() {
        return isLocked;
    }

    public boolean setPin(int oldPin, int newPin) {
        if (this.pin == oldPin) {
            this.pin = newPin;
            System.out.println("PIN updated successfully.");
            return true;
        }
        System.out.println("Incorrect old PIN.");
        return false;
    }

    public boolean validatePin(int enteredPin) {
        if (isLocked) {
            System.out.println("Account is locked.");
            return false;
        }
        if (this.pin == enteredPin) {
            resetFailedAttempts();
            return true;
        } else {
            incrementFailedAttempts();
            System.out.println("Invalid PIN.");
            return false;
        }
    }

    public boolean unlockAccount(int correctPin) {
        if (this.pin == correctPin) {
            isLocked = false;
            resetFailedAttempts();
            System.out.println("Account unlocked successfully.");
            return true;
        }
        System.out.println("Failed to unlock account. Wrong PIN.");
        return false;
    }

    public boolean deposit(double amount, int pin) {
        if (validatePin(pin)) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited: " + amount);
                return true;
            }
            System.out.println("Invalid deposit amount.");
        }
        return false;
    }

    public boolean withdraw(double amount, int pin) {
        if (validatePin(pin)) {
            if (amount > 0 && balance - amount >= MIN_BALANCE) {
                balance -= amount;
                System.out.println("Withdrew: " + amount);
                return true;
            }
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
        return false;
    }

    public boolean transfer(SecureBankAccount target, double amount, int pin) {
        if (withdraw(amount, pin)) {
            target.balance += amount;
            System.out.println("Transferred " + amount + " to account " + target.getAccountNumber());
            return true;
        }
        return false;
    }

    private void lockAccount() {
        isLocked = true;
        System.out.println("Account locked due to multiple failed attempts.");
    }

    private void resetFailedAttempts() {
        failedAttempts = 0;
    }

    private void incrementFailedAttempts() {
        failedAttempts++;
        if (failedAttempts >= MAX_FAILED_ATTEMPTS) {
            lockAccount();
        }
    }

    public static void main(String[] args) {
        SecureBankAccount acc1 = new SecureBankAccount("ACC123", 500);
        SecureBankAccount acc2 = new SecureBankAccount("ACC456", 1000);

        // acc1.balance = 10000;   // ❌ Not allowed (private)
        // acc1.pin = 1234;        // ❌ Not allowed (private)

        acc1.setPin(0, 1234);
        acc2.setPin(0, 5678);

        acc1.deposit(200, 1234);
        acc1.withdraw(100, 1234);
        acc1.transfer(acc2, 50, 1234);

        acc1.validatePin(1111);
        acc1.validatePin(2222);
        acc1.validatePin(3333);

        acc1.deposit(100, 1234);

        acc1.unlockAccount(1234);
        acc1.deposit(100, 1234);

        acc2.withdraw(5000, 5678);
    }
}
