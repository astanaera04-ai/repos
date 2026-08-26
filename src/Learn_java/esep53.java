package Learn_java;

import java.util.Scanner;

public class esep53 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] names = {"Alice", "Bob", "Charlie"};
        double[] balances = {1000.0,2000.0,1500.0};
        int appChoice = 0;
do{
    System.out.println("\nEnter account (1 - 3) or 0 exit: ");
    appChoice = sc.nextInt();

    if (appChoice == 0) break;

    if(appChoice < 1 || appChoice >3){
        System.out.println("Invalid account!");
        continue;
    }

    int index = appChoice - 1;
    System.out.println("Welcome " + names[index] + "!");

    int choice = 0;
    do {

        System.out.println("\n===== MENU =====");
        System.out.println("1. Check balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. Logout");
        System.out.print("Choose: ");
        choice = sc.nextInt();

        switch (choice){
            case 1:
                System.out.println("Balance: " + balances[index]);
                break;
            case 2:
                System.out.println("Enter deposit amount: $");
                double deposit = sc.nextDouble();
                if(deposit <= 0 ){
                    System.out.println("Invalid amount!");
                }else {
                    balances[index] += deposit;
                    System.out.println("Deposited " + deposit);
                }
                break;
            case 3:
                System.out.println("Enter withdraw amount :");
                double withdraw = sc.nextDouble();

                if(withdraw <= 0){
                    System.out.println("Invalid amount");
                } else if (withdraw > balances[index]) {
                    System.out.println("Insufficient funds!");
                } else {
                    balances[index] -= withdraw;
                    System.out.println("Withdraw:" + withdraw);
                }
                break;
            case 4:
                System.out.print("Transfer to account (1 - 3): ");
                int target = sc.nextInt();
                if (target < 1 || target > 3) {
                    System.out.println("Invalid account!");
                } else if (target == appChoice) {
                    System.out.println("Cannot transfer to yourself!");
                } else {
                    System.out.print("Enter amount: $");
                    double amount = sc.nextDouble();
                    if (amount <= 0) {
                        System.out.println("Invalid amount!");
                    } else if (amount > balances[index]) {
                        System.out.println("Insufficient funds!");
                    } else {
                        balances[index] -= amount;
                        balances[target - 1] += amount;
                        System.out.println("Transferred $" + amount + " to " + names[target-1]);
                    }
                }
                break;
            case 5:
                System.out.println("Logged out! 👋");
                break;

            default:
                System.out.println("Invalid option!");

        }

        } while (choice != 5);
    } while (appChoice != 0);
System.out.println("Goodbye! 👋");
}}
