package univ_assignments.ADS_ASS_2;

import java.util.LinkedList;
import java.util.Queue;

public class Task5 {
    static class BankAccount {
        String username;
        double balance;
        public BankAccount(String username, double balance) { this.username = username; this.balance = balance; }
    }

    public static void main(String[] args) {
        LinkedList<BankAccount> mainAccountsDB = new LinkedList<>();
        Queue<BankAccount> accountRequests = new LinkedList<>();

        accountRequests.add(new BankAccount("Nurzhan", 50000));
        accountRequests.add(new BankAccount("Aruzhan", 70000));
        System.out.println("Pending requests: " + accountRequests.size());

        while (!accountRequests.isEmpty()) {
            BankAccount newAcc = accountRequests.poll();
            mainAccountsDB.add(newAcc);
            System.out.println("Admin processed account for: " + newAcc.username);
        }

        System.out.println("\nPending requests now: " + accountRequests.size());
        System.out.println("Total active accounts in Bank: " + mainAccountsDB.size());
    }
}