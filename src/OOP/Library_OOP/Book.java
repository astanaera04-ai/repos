package OOP.Library_OOP;

public class Book extends Item{
    private int pages;

    public Book(String title, String author, int pages){
        super(title, author, false);
        this.pages = pages;
    }
    public int getPages(){
        return pages;
    }
    public void setPages(int pages){
        this.pages = pages;
    }

    public void returnItem(){
        if (getisBorrowed()){
            System.out.println("=== Алу ===");
            System.out.println(getTitle() + " алынды! ✅");
        }else {
            System.out.println("=== Алу ===");
            System.out.println("❌ " + getTitle() + " бұрын алынған!");
        }
    }

    public void getInfo(){
        System.out.println("=== Кітапхана ===");
        System.out.println("Кітап: " + getTitle() + ", " + " Автор: " + getAuthor() + ", " + getPages() + " бет");
    }

    @Override
    public void read() {
        System.out.println("=== Оқу ===");
        System.out.println("Кітап оқылуда: " + getTitle());
    }
}
