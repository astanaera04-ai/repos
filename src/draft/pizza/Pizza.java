package draft.pizza;

public final class Pizza {
    private String size;
    private String cr;
    private String top;

    public Pizza(String size, String cr, String top){
        this.size = size;
        this.cr = cr;
        this.top = top;
    }
    @Override
    public String toString(){
        return size + " pizza, " + cr + " crust, topping: " + top;
    }
}
