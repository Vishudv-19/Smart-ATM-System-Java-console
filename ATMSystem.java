package smart_ATM_simulation_system;

import java.util.Scanner;

public class ATMSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Account user = new Account(1234); // default PIN

        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        if (!user.authenticate(pin)) {
            System.out.println("Invalid PIN. Access denied.");
            return;
        }

        int choice;

        do {
            System.out.println("\n=== ATM MENU ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    user.deposit(sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    user.withdraw(sc.nextDouble());
                    break;

                case 3:
                    user.checkBalance();
                    break;

                case 4:
                    user.showTransactions();
                    break;

                case 5:
                    System.out.println("Thank you for using ATM!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
