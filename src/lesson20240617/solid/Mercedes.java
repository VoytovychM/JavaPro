package lesson20240617.solid;

import lombok.ToString;

@ToString
public class Mercedes extends Car {
    @Override
    public void move() {

    }

    @Override
    public CarService getCarService() {
        return new MercedesService();
    }


}