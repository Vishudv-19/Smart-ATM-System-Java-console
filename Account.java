package smart_ATM_simulation_system;
import java.util.ArrayList;


class Account {
    private double balance;
    private int pin;
    private ArrayList<String> transactions;

    public Account(int pin) {
        this.pin = pin;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public boolean authenticate(int enteredPin) {
        return this.pin == enteredPin;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }
        balance += amount;
        transactions.add("Deposited: " + amount);
        System.out.println("Deposit successful.");
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance!");
            return;
        }
        balance -= amount;
        transactions.add("Withdrawn: " + amount);
        System.out.println("Withdrawal successful.");
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public void showTransactions() {
        System.out.println("=== Transaction History ===");
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String t : transactions) {
                System.out.println(t);
            }
        }
    }
}


