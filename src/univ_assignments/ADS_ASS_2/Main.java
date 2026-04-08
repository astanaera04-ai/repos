package univ_assignments.ADS_ASS_2;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        AccountLinkedList list = new AccountLinkedList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add account");
            System.out.println("2. Display all accounts");
            System.out.println("3. Search by username");
            System.out.println("4. Exit");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Account Number: ");
                String num = scanner.next();
                System.out.print("Username: ");
                String name = scanner.next();
                System.out.print("Balance: ");
                double bal = scanner.nextDouble();
                list.addAccount(new BankAccount(num, name, bal));

            } else if (choice == 2) {
                list.displayAll();

            } else if (choice == 3) {
                System.out.print("Enter username: ");
                String name = scanner.next();
                list.searchByUsername(name);

            } else if (choice == 4) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }
}