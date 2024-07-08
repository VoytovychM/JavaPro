package start.coffee;

public class Main {
    public static void main(String[] args) {
       CoffeeMachine coffeeMachine = new CoffeeMachine();
       coffeeMachine.displayInfo(ListOfCoffee.AMERICANO);
       coffeeMachine.makeCoffee(ListOfCoffee.AMERICANO, 5);

    }
}
