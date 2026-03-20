package learn_java;

public class SavingsAccount extends BankAccount {

    double interestRate;

    public SavingsAccount(String ownerName, int balance, double interestRate ) {
        super(ownerName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            history.add("-" + amount + " тг алынды");
            System.out.println("***********");
            System.out.println("Алынды: -" + amount + " тг");
            System.out.println("Жаңа баланс: " + balance + " тг");
            System.out.println();
        } else {
            System.out.println("❌ Қате! Жеткіліксіз қаражат");
            System.out.println();
        }
    }

    public void addInterest(){
        balance *= (1 + interestRate);
        System.out.println( ownerName + " балансына +" + (interestRate * 100) + "% қосылды. Жаңа баланс: " + balance);
        System.out.println();
    }

}
