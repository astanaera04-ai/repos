package univ_assignments.ADS_ASS_2;

public class Task6 {
    static class BankAccount {
        String accountNumber;
        String username;
        double balance;
        public BankAccount(String acc, String name, double bal) {
            accountNumber = acc; username = name; balance = bal;
        }
    }

    public static void main(String[] args) {
        BankAccount[] bankArray = new BankAccount[3];

        bankArray[0] = new BankAccount("A01", "John", 5000);
        bankArray[1] = new BankAccount("A02", "Emma", 7500);
        bankArray[2] = new BankAccount("A03", "Liam", 10000);

        System.out.println("Predefined Accounts in Array:");
        for (int i = 0; i < bankArray.length; i++) {
            System.out.println(bankArray[i].username + " - Balance: " + bankArray[i].balance);
        }
    }
}