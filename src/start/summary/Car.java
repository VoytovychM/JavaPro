package start.summary;

import java.util.Objects;

public class Car {
    private String model;
    private int id;
    private String color;

    public Car(String model, int id, String color) {
        this.model = model;
        this.id = id;
        this.color = color;
    }

    public static void main(String[] args) {
        Car car1 = new Car("BMW", 123, "black");
        Car car2 = new Car("BMW", 123, "black");
        String stringDescription = car1.toString();
        System.out.println(car1);

        System.out.println(car1 == car2);
        System.out.println(car1.equals(car2));
        System.out.println("ABC".equals("ABB"));
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", id=" + id +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && Objects.equals(model, car.model) && Objects.equals(color, car.color);
    }


}
