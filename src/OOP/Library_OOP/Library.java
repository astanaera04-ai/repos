package OOP.Library_OOP;

import java.util.ArrayList;

public class Library {
    private String name;
    private ArrayList<Item> items = new ArrayList<>();

    public Library(String name){
        this.name = name;
    }

    public void addItem(Item item){
        items.add(item);
        System.out.println("✅ " + item.getTitle() + " қосылды!");
    }

    public void borrowItem(String title) throws ItemAlreadyBorrowedException{
        for (Item item : items){
            if (item.getTitle().equals(title)){
                if (item.getisBorrowed()){
                    throw new ItemAlreadyBorrowedException(
                            "❌ " + title + " бұрын алынған!"
                    );
                }item.setBorrowed(true);
                System.out.println("✅ " + title + " алынды!");
                return;
            }

        }
        System.out.println("❌ " + title + " табылмады!");
    }

    public void showAll(){
        System.out.println("=== " + name + " ===");
        for (Item item : items){
            item.getInfo();
        }
    }

}
