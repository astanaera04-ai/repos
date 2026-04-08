package univ_assignments.ADS_ASS_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class MiniBankingMenu {

    static LinkedList<BankAccount> accounts = new LinkedList<>();      // Active accounts
    static Stack<String> history = new Stack<>();                      // Transaction history (LIFO)
    static Queue<BankAccount> accountQueue = new LinkedList<>();       // Account opening requests (FIFO)
    static Queue<String> billQueue = new LinkedList<>();               // Bill payment requests (FIFO)

    static Scanner scanner = new Scanner(System.in);

    static class BankAccount {
        String username;
        double balance;

        public BankAccount(String username, double balance) {
            this.username = username;
            this.balance = balance;
        }
    }

    public static void main(String[] args) {
        accounts.add(new BankAccount("AdminUser", 50000));

        billQueue.add("Electricity Bill");

        boolean running = true;
        while (running) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1 - Enter Bank");
            System.out.println("2 - Enter ATM");
            System.out.println("3 - Admin Area");
            System.out.println("4 - Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1": bankMenu(); break;
                case "2": atmMenu(); break;
                case "3": adminMenu(); break;
                case "4":
                    running = false;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default: System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }


    private static void bankMenu() {
        System.out.println("\n--- Bank Menu ---");
        System.out.println("1. Submit account opening request");
        System.out.println("2. Deposit money");
        System.out.println("3. Withdraw money");
        System.out.print("Choose: ");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1": submitAccountRequest(); break;
            case "2": handleTransaction("Deposit"); break;
            case "3": handleTransaction("Withdraw"); break;
            default: System.out.println("Invalid choice.");
        }
    }

    private static void atmMenu() {
        System.out.println("\n--- ATM Menu ---");
        System.out.println("1. Balance enquiry");
        System.out.println("2. Withdraw");
        System.out.print("Choose: ");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1": balanceEnquiry(); break;
            case "2": handleTransaction("Withdraw"); break;
            default: System.out.println("Invalid choice.");
        }
    }

    private static void adminMenu() {
        System.out.println("\n--- Admin Menu ---");
        System.out.println("1. View and process account queue");
        System.out.println("2. View and process bill payment queue");
        System.out.println("3. View transaction history stack (Admin extra)");
        System.out.print("Choose: ");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1": processAccountQueue(); break;
            case "2": processBillQueue(); break;
            case "3":
                System.out.println("History Stack: " + history);
                break;
            default: System.out.println("Invalid choice.");
        }
    }


    private static void submitAccountRequest() {
        System.out.print("Enter your username: ");
        String name = scanner.nextLine();
        System.out.print("Enter initial deposit: ");
        double balance = Double.parseDouble(scanner.nextLine());

        accountQueue.add(new BankAccount(name, balance));
        System.out.println("Request submitted! Please wait for Admin approval.");
    }

    private static void balanceEnquiry() {
        BankAccount acc = findAccount();
        if (acc != null) {
            System.out.println("Current Balance: $" + acc.balance);
            history.push("Balance enquiry by " + acc.username);
        }
    }

    private static void handleTransaction(String type) {
        BankAccount acc = findAccount();
        if (acc == null) return;

        System.out.print("Enter amount to " + type.toLowerCase() + ": ");
        double amount = Double.parseDouble(scanner.nextLine());

        if (type.equals("Deposit")) {
            acc.balance += amount;
            System.out.println("Deposit successful. New balance: $" + acc.balance);
            history.push("Deposited $" + amount + " to " + acc.username);
        }
        else if (type.equals("Withdraw")) {
            if (acc.balance >= amount) {
                acc.balance -= amount;
                System.out.println("Withdrawal successful. New balance: $" + acc.balance);
                history.push("Withdrew $" + amount + " from " + acc.username);
            } else {
                System.out.println("Transaction failed: Insufficient funds.");
            }
        }
    }

    private static void processAccountQueue() {
        if (accountQueue.isEmpty()) {
            System.out.println("No pending account requests.");
            return;
        }
        BankAccount newAccount = accountQueue.poll(); // FIFO: Gets first in line
        accounts.add(newAccount); // Moves to LinkedList
        System.out.println("Approved account for: " + newAccount.username);
        System.out.println("Remaining requests in queue: " + accountQueue.size());
    }

    private static void processBillQueue() {
        if (billQueue.isEmpty()) {
            System.out.println("No pending bills to process.");
            return;
        }
        String bill = billQueue.poll(); // FIFO
        System.out.println("Processed bill: " + bill);
        System.out.println("Remaining bills in queue: " + billQueue.size());
    }

    private static BankAccount findAccount() {
        System.out.print("Enter username: ");
        String name = scanner.nextLine();

        for (BankAccount acc : accounts) {
            if (acc.username.equalsIgnoreCase(name)) {
                return acc;
            }
        }
        System.out.println("Account not found in active database.");
        return null;
    }
}