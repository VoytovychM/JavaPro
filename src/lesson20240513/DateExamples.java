package lesson20240513;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateExamples {
    public static void main(String[] args) {

            Date now = new Date();
            System.out.println(now);
            System.out.println(now.getTime());

            Date date = new Date(1000L);
            System.out.println(date);

            System.out.println(new Date(100, 1, 5));
            System.out.println(new Date(100, 12, 32));
            Date date1 = new Date(100, Calendar.DECEMBER, 14);
            System.out.println(date1);

            System.out.println(date1.compareTo(date));

            date1.setHours(10);
            System.out.println(date1);

            Calendar calendar = new GregorianCalendar();
            System.out.println(calendar);
            System.out.println(calendar.getCalendarType());

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println(format.format(now));

            Locale locale = Locale.of("ru");
            Locale.setDefault(locale);
            String formattedDate = String.format(locale, "%tc\n", now) + // длинная строка
                    String.format(locale, "%tD\n", now) + //(MM/DD/YY)
                    String.format(locale, "%tF\n", now) + //(YYYY-MM-DD)
                    String.format(locale, "%tr\n", now) + //Full 12-hour time
                    String.format(locale, "%tz\n", now) + //Time zone GMT offset
                    String.format(locale, "%tZ\n", now);//Localized time zone abbreviation
            System.out.println(formattedDate);

        }


    }

