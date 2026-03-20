package Shop;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();

        products.add(new FoodProduct( "Сүт", 500,50  ,5 ));
        products.add(new FoodProduct("Ескі нан", 300, 10, 0));
        products.add(new ElectroProduct("iPhone", 500000, 5, 12));
        products.add(new ElectroProduct("Nokia", 50000, 3, 0));

        System.out.println("=== Дүкен ===");
        for (Product p : products) {
            p.showInfo();
        }

        System.out.println("\n=== Сату ===");
        products.get(0).sell(10);
        products.get(1).sell(5);
        products.get(2).sell(2);
        products.get(3).sell(1);
    }
}
