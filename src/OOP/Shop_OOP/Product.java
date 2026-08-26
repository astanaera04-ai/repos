package OOP.Shop_OOP;

abstract public class Product implements Sellable {
    String name;
    int price;
    int stock;
    public Product(String name, int price,int stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public void restock(int quantity){
        stock +=quantity;
        System.out.println(name + " қоймасы толықтырылды: +" + quantity + " дана. Жалпы: " + stock);
    }
    public void showInfo(){
        System.out.println("Өнім: " + name + ", " + "Баға: " + price + " Қойма: " + stock);
    }
    public abstract void sell(int quantity);
}
