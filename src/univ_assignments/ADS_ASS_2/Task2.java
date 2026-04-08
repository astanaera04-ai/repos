package univ_assignments.ADS_ASS_2;

import java.util.LinkedList;
import java.util.Scanner;

public class Task2 {
    static class BankAccount {
        String username;
        double balance;
        public BankAccount(String username, double balance) {
            this.username = username;
            this.balance = balance; }
    }

    public static void main(String[] args) {
        LinkedList<BankAccount> accounts = new LinkedList<>();
        accounts.add(new BankAccount("Ali", 150000));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String name = scanner.nextLine();

        for (BankAccount acc : accounts) {
            if (acc.username.equalsIgnoreCase(name)) {
                System.out.print("Deposit amount: ");
                double deposit = scanner.nextDouble();
                acc.balance += deposit;
                System.out.println("New balance: " + acc.balance);

                System.out.print("Withdraw amount: ");
                double withdraw = scanner.nextDouble();
                if (acc.balance >= withdraw) {
                    acc.balance -= withdraw;
                    System.out.println("New balance: " + acc.balance);
                } else {
                    System.out.println("Insufficient funds!");
                }
            }
        }
        scanner.close();
    }
}