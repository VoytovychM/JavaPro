package summary.task;

public class Square implements Figures {

    double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                '}';
    }

    @Override
    public double calculateArea() {
        return side * side;
    }
}
