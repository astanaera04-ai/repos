package OOP.Library_OOP;

public  abstract class Item implements Readable {
    private String title ;
    private String author;
    private boolean isBorrowed;

    public Item (String title, String author, boolean isBorrowed){
        this.title = title;
        this.author = author;
        this.isBorrowed = isBorrowed;
    }

    public String getTitle (){
        return title;
    }
    public void setTitle (String title){
        this.title = title;
    }

    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }

    public boolean getisBorrowed() {
        return isBorrowed;
    }
    public void setBorrowed(boolean isBorrowed){
        this.isBorrowed = isBorrowed;
    }

    public abstract void read();
}
