//package BANK;
//
//public class CreditAccount extends BankAccount {
//    int creditLimit;
//
//    public CreditAccount(String ownerName, int balance, int creditLimit){
//        super(ownerName,balance);
//        this.creditLimit = creditLimit;
//    }
//
//    @Override
//    public void withdraw(int amount){
//
//        if (amount <= balance + creditLimit){
//            balance -= amount;
//            System.out.println("Алынды: -" + amount + " тг");
//            System.out.println("Жаңа баланс: " + balance + " тг");
//        }
//        else {
//            System.out.println("❌ Лимит жетпейді!");
//        }
//    }
//
//}
