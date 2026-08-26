package Learn_java;

import java.util.Scanner;


public class esep42 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = 1000.0;
        int choice;

        do {
            System.out.println("\n===== ATM =====");
            System.out.println("1. Check balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: $" + balance);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    double deposit = sc.nextDouble();
                    if (deposit > 0) {
                        balance += deposit;
                        System.out.println("Deposited $" + deposit);
                    } else {
                        System.out.println("Invalid amount!");
                    }
                    break;
                case 3:
                    System.out.print("Enter withdraw amount: $");
                    double withdraw = sc.nextDouble();
                    if (withdraw <= 0) {
                        System.out.println("Invalid amount!");
                    } else if (withdraw > balance) {
                        System.out.println("Insufficient funds!");
                    } else {
                        balance -= withdraw;
                        System.out.println("Withdrawn $" + withdraw);
                    }
                    break;
                case 4:
                    System.out.println("Goodbye! 👋");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } while (choice != 4);
    }
}
