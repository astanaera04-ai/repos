package OOP.Library_OOP;

public class Magazine extends Item{
    private int issue;

    public Magazine(String title, String author, int issue) {
        super(title, author, false);
        this.issue = issue;
    }
    public int getissue(){
        return issue;
    }
    public void setIssue(int issue){
        this.issue = issue;
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
        System.out.println("Журнал: " + getTitle() + ", " + " Автор: " + getAuthor() + ", №" + getissue());
    }
    @Override
    public void read() {
        System.out.println("=== Оқу ===");
        System.out.println("Журнал  оқылуда: " + getTitle());
    }
}
