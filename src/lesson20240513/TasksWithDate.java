package lesson20240513;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Locale;





public class TasksWithDate {
    public static void main(String[] args) {

        //создать любую дату
        LocalDate currentDate = LocalDate.now();
        System.out.println(currentDate);

        // вывести на консоль на русском / английском языках
        System.out.println(DateTimeFormatter.ofPattern("dd-MM-yyyy").format(currentDate));
        DateTimeFormatter localizedDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        System.out.println(localizedDate.withLocale(new Locale("ru")).format(currentDate));
        System.out.println(localizedDate.withLocale(Locale.of("en_NU")).format(currentDate));

        // найти, на какой день недели она выпала
        System.out.println(currentDate.getDayOfWeek());

        // вычесть 10 лет из созданной даты, вывести на консоль
        System.out.println(currentDate.minusYears(10));

        // посчитать количество дней до нее
       long daysUntil = ChronoUnit.DAYS.between(LocalDate.now(), currentDate);
        System.out.println(daysUntil);
    }
}
