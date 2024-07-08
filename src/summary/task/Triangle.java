package summary.task;

public class Triangle implements Figures{

    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "base=" + base +
                ", height=" + height +
                '}';
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}
