package start.practiceEnum;

public enum DaysOFWeek {

    MONDAY ("Monday"),
    TUESDAY ("Tuesday"),
    WEDNESDAY ("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY ("Friday"),
    SATURDAY ("Saturday"),
    SUNDAY ("Sunday");
    private String title;
    DaysOFWeek(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "DaysOFWeek{" +
                "title='" + title + '\'' +
                '}';
    }
}

