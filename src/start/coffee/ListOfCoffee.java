package start.coffee;

public enum ListOfCoffee {
    CAPPUCCINO (2, "Cappuccino - coffee with milk"),
    LATTE (3, "Latte - Coffee with double dose of milk"),
    AMERICANO(2, "Americano - black coffee"),
    ESPRESSO(2, "Espresso - strong coffee"),
    MACCIATO (3, "Macchiato - Coffee with less milk");

    private final int price;
    private final String description;



    ListOfCoffee(int price, String description) {
        this.price = price;
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
