import java.util.*;

class PersonalAccount {
    private String accountHolderName;
    private String accountNumber;
    private double currentBalance;
    private double totalIncome;
    private double totalExpenses;

    
    private static int totalAccounts = 0;
    private static String bankName = "Default Bank";


    public PersonalAccount(String accountHolderName) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = generateAccountNumber();
        this.currentBalance = 0.0;
        this.totalIncome = 0.0;
        this.totalExpenses = 0.0;
        totalAccounts++;
    }

    public void addIncome(double amount, String description) {
        if (amount > 0) {
            currentBalance += amount;
            totalIncome += amount;
            System.out.println(accountHolderName + " received income: " + amount + " (" + description + ")");
        } else {
            System.out.println("Invalid income amount!");
        }
    }


    public void addExpense(double amount, String description) {
        if (amount > 0 && amount <= currentBalance) {
            currentBalance -= amount;
            totalExpenses += amount;
            System.out.println(accountHolderName + " spent: " + amount + " (" + description + ")");
        } else {
            System.out.println("Invalid or insufficient balance for expense!");
        }
    }

    public double calculateSavings() {
        return totalIncome - totalExpenses;
    }

    
    public void displayAccountSummary() {
        System.out.println("\n------ Account Summary ------");
        System.out.println("Bank Name: " + bankName);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + currentBalance);
        System.out.println("Total Income: " + totalIncome);
        System.out.println("Total Expenses: " + totalExpenses);
        System.out.println("Total Savings: " + calculateSavings());
        System.out.println("-----------------------------\n");
    }

    public static void setBankName(String name) {
        bankName = name;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static String generateAccountNumber() {
        return "ACCT" + (1000 + totalAccounts + 1);
    }
}


public class PersonalFinanceApp {
    public static void main(String[] args) {
  
        PersonalAccount.setBankName("QwikBank");

    
        PersonalAccount acc1 = new PersonalAccount("Alice");
        PersonalAccount acc2 = new PersonalAccount("Bob");
        PersonalAccount acc3 = new PersonalAccount("Charlie");

      
        acc1.addIncome(5000, "Salary");
        acc1.addExpense(1500, "Rent");
        acc1.addExpense(1000, "Groceries");

        acc2.addIncome(7000, "Freelance Project");
        acc2.addExpense(2000, "Laptop Purchase");
        acc2.addExpense(1000, "Travel");

        acc3.addIncome(10000, "Business Profit");
        acc3.addExpense(3000, "Office Rent");
        acc3.addExpense(2500, "Supplies");

        // Display summaries
        acc1.displayAccountSummary();
        acc2.displayAccountSummary();
        acc3.displayAccountSummary();


        System.out.println("Static variable demonstration:");
        System.out.println("Bank Name (shared by all): " + PersonalAccount.getTotalAccounts() + " accounts in " + "QwikBank");
        System.out.println("Alice's balance: " + acc1.calculateSavings());
        System.out.println("Bob's balance: " + acc2.calculateSavings());
        System.out.println("Charlie's balance: " + acc3.calculateSavings());
    }
}
