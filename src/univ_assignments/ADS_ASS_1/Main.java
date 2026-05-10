package univ_assignments.ADS_ASS_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static LinkedList<BankAccount> accounts = new LinkedList<>();
    static Stack<String> transactionHistory = new Stack<>();
    static Queue<String> billQueue = new LinkedList<>();
    static Queue<BankAccount> accountRequests = new LinkedList<>();

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        accounts.add(new BankAccount("1001", "Ali", 150000));
        accounts.add(new BankAccount("1002", "Sara", 220000));

        billQueue.add("Electricity Bill");
        billQueue.add("Internet Bill");

        while (true) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1 - Enter Bank");
            System.out.println("2 - Enter ATM");
            System.out.println("3 - Admin Area");
            System.out.println("4 - Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    bankMenu();
                    break;
                case 2:
                    atmMenu();
                    break;
                case 3:
                    adminMenu();
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void bankMenu() {
        while (true) {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1 - Submit account opening request");
            System.out.println("2 - Deposit money");
            System.out.println("3 - Withdraw money");
            System.out.println("4 - Add Bill Payment Request");
            System.out.println("5 - Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter new username: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter initial deposit: ");
                    double initialDep = scanner.nextDouble();
                    scanner.nextLine();
                    String accNum = "REQ" + (int)(Math.random() * 10000);
                    accountRequests.add(new BankAccount(accNum, name, initialDep));
                    System.out.println("Account request submitted. Pending admin approval.");
                    break;
                case 2:
                    performTransaction("deposit");
                    break;
                case 3:
                    performTransaction("withdraw");
                    break;
                case 4:
                    System.out.print("Enter bill name (e.g., Water Bill): ");
                    String bill = scanner.nextLine();
                    billQueue.add(bill);
                    System.out.println("Added: " + bill);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void atmMenu() {
        while (true) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1 - Balance enquiry");
            System.out.println("2 - Withdraw money");
            System.out.println("3 - Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String name = scanner.nextLine();
                    BankAccount acc = findAccount(name);
                    if (acc != null) {
                        System.out.println("Current Balance for " + name + ": " + acc.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 2:
                    performTransaction("withdraw");
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1 - View and process account queue");
            System.out.println("2 - Process bill payment queue");
            System.out.println("3 - View all active accounts (LinkedList)");
            System.out.println("4 - View transaction history (Stack)");
            System.out.println("5 - Undo last transaction");
            System.out.println("6 - Test Physical Array (Task 6)");
            System.out.println("7 - Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (accountRequests.isEmpty()) {
                        System.out.println("No pending requests.");
                    } else {
                        BankAccount newAcc = accountRequests.poll();
                        accounts.add(newAcc);
                        System.out.println("Processed and activated account for: " + newAcc.getUsername());
                    }
                    break;
                case 2:
                    if (billQueue.isEmpty()) {
                        System.out.println("No pending bills.");
                    } else {
                        System.out.println("Processing: " + billQueue.poll());
                        if (!billQueue.isEmpty()) {
                            System.out.println("Remaining: " + billQueue.peek() + " (and more)");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Accounts List:");
                    for (int i = 0; i < accounts.size(); i++) {
                        System.out.println((i + 1) + ". " + accounts.get(i).toString());
                    }
                    break;
                case 4:
                    if (transactionHistory.isEmpty()) {
                        System.out.println("No transactions yet.");
                    } else {
                        System.out.println("Last transaction: " + transactionHistory.peek());
                    }
                    break;
                case 5:
                    if (!transactionHistory.isEmpty()) {
                        String removed = transactionHistory.pop();
                        System.out.println("Undo -> Removed transaction: [" + removed + "]");
                    } else {
                        System.out.println("No transactions to undo.");
                    }
                    break;
                case 6:
                    runPhysicalArrayTask();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    private static BankAccount findAccount(String username) {
        for (BankAccount acc : accounts) {
            if (acc.getUsername().equalsIgnoreCase(username)) {
                return acc;
            }
        }
        return null;
    }

    private static void performTransaction(String type) {
        System.out.print("Enter username: ");
        String name = scanner.nextLine();
        BankAccount acc = findAccount(name);

        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter amount to " + type + ": ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (type.equals("deposit")) {
            acc.deposit(amount);
            System.out.println("New balance: " + acc.getBalance());
            transactionHistory.push("Deposit " + amount + " to " + name);
        } else if (type.equals("withdraw")) {
            if (acc.withdraw(amount)) {
                System.out.println("New balance: " + acc.getBalance());
                transactionHistory.push("Withdraw " + amount + " from " + name);
            } else {
                System.out.println("Insufficient funds!");
            }
        }
    }

    private static void runPhysicalArrayTask() {
        System.out.println("\n--- Task 6: Physical Array Demonstration ---");
        BankAccount[] physicalArray = new BankAccount[3];
        physicalArray[0] = new BankAccount("A001", "Daniyar", 50000);
        physicalArray[1] = new BankAccount("A002", "Aruzhan", 120000);
        physicalArray[2] = new BankAccount("A003", "Bekzhat", 75000);

        System.out.println("Predefined Accounts in Array:");
        for (int i = 0; i < physicalArray.length; i++) {
            System.out.println("Index " + i + ": " + physicalArray[i].toString());
        }
    }
}