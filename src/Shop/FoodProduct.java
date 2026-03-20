package Shop;

public class FoodProduct extends Product {
    int expiryDays;
    public FoodProduct(String name, int price,int stock, int expiryDays ){
        super(name,price,stock);
        this.expiryDays = expiryDays;
    }

    @Override
    public void sell(int quantity){
        if (expiryDays > 0){
            if( quantity <= stock){
            stock -= quantity;
            System.out.println("Сатылды: " + quantity + " → Қойма: " + stock);
        }
        else{
            System.out.println("❌ Қойма жеткіліксіз!");
        }
        }
        else {
            System.out.println("❌ " + name + " мерзімі біткен, сатуға болмайды!");
        }


    }
}
