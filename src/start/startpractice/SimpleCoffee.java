package start.startpractice;

public class SimpleCoffee {
    public static void main(String[] args) {
        CoffeeAutomat aut1;
        aut1 = new CoffeeAutomat();

        aut1.setName("Nespresso");
        aut1.setTypeCoffee("Cappuchino");
        aut1.setCountWater(10);

        aut1.putCoin(50);
        aut1.getCoffee();

        CoffeeAutomat aut2 = new CoffeeAutomat("Nespresso", "Cappuccino", 10, true);

        aut2.putCoin(50);
        aut2.getCoffee();
    }
}
