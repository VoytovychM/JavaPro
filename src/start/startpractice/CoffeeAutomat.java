package start.startpractice;

import java.text.DecimalFormat;

public class CoffeeAutomat {
    private String name;
    private String typeCoffee;
    private int litreOfWater;

    static boolean isButtonSwitch; // наличие кнопки Включения/выключение

    private boolean isStatus; // включен авторма или нет.

    public void getCoffee() {
        System.out.println("The coffee machine " + name + " making coffee and pours us coffee into a cup");
    }

    public void putCoin(int nominal) {
        double action = 1.1; // процент от суммы
        System.out.println("The screen of the coffee machine shows us price for a cup of coffee "+ DecimalFormat.getInstance().format(nominal * action)  +
                " and type of drink "+ typeCoffee);
    }

    public CoffeeAutomat() {
    }

    public CoffeeAutomat(String name, String typeCoffee, int litreOfWater, boolean isStatus) {
        this.name = name;
        this.typeCoffee = typeCoffee;
        this.litreOfWater = litreOfWater;
        this.isStatus = isStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTypeCoffee(String typeCoffee) {
        this.typeCoffee = typeCoffee;
    }

    public void setCountWater(int countWater) {
        this.litreOfWater = litreOfWater;
    }

    public void setStatus(boolean status) {
        isStatus = status;
    }
}