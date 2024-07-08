package summary.task;

public class Circle implements Figures {

    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
