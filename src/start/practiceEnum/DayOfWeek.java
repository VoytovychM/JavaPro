package start.practiceEnum;

public class DayOfWeek {

    private String title;

    private DayOfWeek(String title) {
        this.title = title;
    }
    public static DayOfWeek MONDAY = new DayOfWeek("Monday");



    @Override
    public String toString() {
        return "DayOfWeek{" +
                "title='" + title + '\'' +
                '}';
    }
}
