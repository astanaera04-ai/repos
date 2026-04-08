package univ_assignments.ADS_ASS_2;

import java.util.LinkedList;
import java.util.Queue;

public class Task4 {
    public static void main(String[] args) {
        Queue<String> billQueue = new LinkedList<>();

        billQueue.add("Electricity Bill");
        System.out.println("Added: Electricity Bill");

        billQueue.add("Internet Bill");
        System.out.println("Added: Internet Bill");

        System.out.println("\nProcessing: " + billQueue.poll());

        System.out.println("Remaining: " + billQueue.peek());
    }
}