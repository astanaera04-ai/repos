package draft.pizza;

public class main {
    public static void main(String[] ards){
        PizzaDirector director = new PizzaDirector();
        PizzaBuilder builder = new PizzaBuilder();


        Pizza pizza = director.makeMar(builder);
        System.out.println(pizza);
    }

}
