package lesson20240513;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.Locale;

public class DateAfterJava8Examples {
    public static void main(String[] args) {

        // Instant
        Instant instant = Instant.now();
        System.out.println(instant);
        System.out.println(instant.getNano());
        System.out.println(instant.getEpochSecond());

        Instant newInstant = instant.plusSeconds(100);
        System.out.println(newInstant);

        Duration duration = Duration.ofHours(10);
        newInstant = instant.plus(duration);
        System.out.println(newInstant);

        // LocalDate
        LocalDate today = LocalDate.now();
        System.out.println(today);
        LocalDate localDate = LocalDate.of(2024, Month.MAY, 31);
        System.out.println(localDate);

        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.plusMonths(1));
        System.out.println(localDate.plusDays(31));

        System.out.println("------");
        LocalDate.of(2024, Month.MAY, 1).datesUntil(LocalDate.of(2024, Month.JUNE, 1), Period.ofDays(7))
                .forEach(System.out::println);

        System.out.println("------");
        System.out.println(localDate.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println(localDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.FRIDAY)));
        System.out.println(localDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY)));

        // LocalTime
        System.out.println(LocalTime.now());
        LocalTime conferenceTime = LocalTime.of(12, 15);
        System.out.println(conferenceTime);

        // LocalDateTime
        LocalDateTime conferenceDateTime = LocalDateTime.of(today, conferenceTime);
        System.out.println(conferenceDateTime);

        // ZonedDateTime
        ZonedDateTime conferenceZonedTateTime = ZonedDateTime.of(conferenceDateTime, ZoneId.of("CET"));
        System.out.println(conferenceZonedTateTime);
        ZoneId zone = conferenceZonedTateTime.getZone();
        System.out.println(zone);
//        ZoneId.getAvailableZoneIds().forEach(System.out::println);

        ZonedDateTime tokyoTime = conferenceZonedTateTime.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        System.out.println(tokyoTime);


        // Period
//        Period period = Period.ofWeeks(10);
        Period period = Period.ofMonths(2);
        System.out.println(period);

        System.out.println(localDate.plus(period));


        // DateTimeFormatter
        System.out.println("Formatting data and time:");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
        String formatted = dateTimeFormatter.format(conferenceDateTime);
        System.out.println(formatted);

        System.out.println(DateTimeFormatter.ofPattern("dd-MM-yyyy").format(conferenceDateTime));
        DateTimeFormatter localizedDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        System.out.println(localizedDate.withLocale(Locale.GERMAN).format(conferenceDateTime));
        System.out.println(Arrays.toString(Locale.getAvailableLocales()));
        System.out.println(localizedDate.withLocale(Locale.of("en_NU")).format(conferenceDateTime));

    }

}

