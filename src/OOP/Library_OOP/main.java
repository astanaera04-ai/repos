package OOP.Library_OOP;

public class main {
    public static void main(String[] args) {

        Library library = new Library("Астана кітапханасы");

        library.addItem(new Book("Абай жолы", "М.Әуезов", 892));
        library.addItem(new Magazine("National Geographic", "Редакция", 205));

        library.showAll();

        try {
            library.borrowItem("Абай жолы");
            library.borrowItem("Абай жолы");
        } catch (ItemAlreadyBorrowedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=== Оқу ===");
        library.showAll();


    }
}
