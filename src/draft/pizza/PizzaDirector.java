package draft.pizza;

public class PizzaDirector {
    public Pizza makeMar(PizzaBuilder builder){

        return builder
                .setSize("Medium")
                .setCrust("thin")
                .setTopping("Cheese")
                .build();
    }
}
