package OOP.Shop_OOP;

public class ElectroProduct extends Product{
    int warrantyMonths;

    public ElectroProduct(String name, int price,int stock,  int warrantyMonths) {
        super(name, price, stock);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public void sell( int quantity){
        if (warrantyMonths > 0){
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
