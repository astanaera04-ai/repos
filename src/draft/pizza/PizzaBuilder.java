package draft.pizza;

public class PizzaBuilder {
    private String size;
    private String crust;
    private String topping;

    public PizzaBuilder setSize(String size){
        this.size = size;
        return this;
    }
    public PizzaBuilder setCrust(String crust){
        this.crust = crust;
        return this;
    }
    public PizzaBuilder setTopping (String topping){
        this.topping = topping;
        return this;
    }
    public Pizza build(){
        return new Pizza(size, crust, topping);
    }
}
