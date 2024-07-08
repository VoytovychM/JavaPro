package summary.task;

public class Rectangle implements Figures{

    private double width;
    private double heights;

    public Rectangle(double width, double heights) {
        this.width = width;
        this.heights = heights;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", heights=" + heights +
                '}';
    }

    @Override
    public double calculateArea() {
        return width * heights;
    }
}
