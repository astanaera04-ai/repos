package learn_java;
import java.util.ArrayList;

public abstract class BankAccount implements Bankable {
    String ownerName;
    int balance;
    ArrayList<String> history = new ArrayList<>();

    public BankAccount (String ownerName, int balance ){
        this.balance = balance;
        this.ownerName = ownerName;
    }

    public void deposit(int amount){
        balance = balance + amount;
        history.add("+" + amount + " тг салынды");
        System.out.println("***********");
        System.out.println("Салынды: +" + amount + " тг");
        System.out.println("Салғандағы баланс : " + balance  );
        System.out.println();
    }

    public abstract void withdraw(int amount);

//    public void withdraw(int amount){
//        if (balance > amount){
//            balance = balance - amount;
//            history.add("-" + amount + " тг алынды");
//            System.out.println("***********");
//            System.out.println("Алынды: -"+ amount + " тг");
//            System.out.println("Жаңа баланс : " +balance);
//            System.out.println();
//        }else {
//            System.out.println("Қате! Жеткіліксіз қаражат");
//            System.out.println();
//        }
//    }

    public void showBalance(){
        System.out.println("***********");
        System.out.println("Иесі: " + ownerName);
        System.out.println("Баланс: " + balance);
        System.out.println();
    }


    public void transfer(BankAccount target, int amount) {

        if (balance >= amount) {

            balance = balance - amount;
            target.balance = target.balance + amount;

            history.add("→ " + target.ownerName + "-ға " + amount + " тг аударылды");


            System.out.println(ownerName + " → " + target.ownerName + ": " + amount + " тг аударылды");
            System.out.println();

        } else {
            System.out.println("❌ Жеткіліксіз қаражат!");
            System.out.println();
        }
    }



    public void showHistory() {
        System.out.println("=== " + ownerName + " тарихы ===");
        for (String record : history) {
            System.out.println(record);
        }
    }

    public static void main(String[] args) {
//
//        BankAccount bk1 = new BankAccount("Bek", 50000);
//        BankAccount bk2 = new BankAccount("Aisha", 10000);


//        bk1.transfer(bk2, 15000);
//        bk1.withdraw(999);
//        bk1.transfer(bk2, 15000);
//        bk1.showBalance();
//        bk1.showHistory();

        SavingsAccount sa = new SavingsAccount("Bek", 100000, 0.10);

        sa.showBalance();
        sa.deposit(20000);
        sa.withdraw(15000);
        sa.addInterest();
        sa.showHistory();

//        bk.deposit(10200);
//        bk.withdraw(999);
//        bk.showBalance();
        CreditAccount ca = new CreditAccount("Bek", 5000, 50000);

        ca.showBalance();
        ca.withdraw(30000);
        ca.showBalance();
        ca.withdraw(99999);
        ca.showHistory();






    }

}
