package univ_assignments.ADS_ASS_2;

import java.util.Stack;

public class Task3  {
    public static void main(String[] args) {
        Stack<String> transactionHistory = new Stack<>();

        transactionHistory.push("Deposit 50000 to Ali");
        transactionHistory.push("Withdraw 20000 from Ali");

        System.out.println("Added to history.");

        System.out.println("Last transaction: " + transactionHistory.peek());

        String undone = transactionHistory.pop();
        System.out.println("Undo -> '" + undone + "' removed");

        System.out.println("Current Last transaction: " + transactionHistory.peek());
    }
}