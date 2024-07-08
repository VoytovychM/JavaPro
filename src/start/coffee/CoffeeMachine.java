package start.coffee;

public class CoffeeMachine {
    public void displayInfo(ListOfCoffee coffee) {
        System.out.println("You picked: " + coffee.name());
        System.out.println("Description: " + coffee.getDescription());
        System.out.println("Price: " + coffee.getPrice() + " EUR");
    }

    public void makeCoffee(ListOfCoffee coffee, int money) {
        switch (coffee) {
            case CAPPUCCINO -> {
                System.out.println("Sorry, the type of coffee is invalid.");

            }
            default -> {
                if (coffee.getPrice() > money) {
                    System.out.println("Not enough money");
                } else {

                    int change = (int) (money - coffee.getPrice());
                    System.out.println("Yours " + coffee.name() + " ready!");
                    System.out.println("Yours change: " + change + " EUR");
                }
            }

        }
    }
}