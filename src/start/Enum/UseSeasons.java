package start.Enum;

import javax.crypto.SealedObject;
import java.util.Arrays;

public class UseSeasons {
    public static void main(String[] args) {
      Season season = Season.SUMMER;
        System.out.println(season);
        System.out.println(season.ordinal());
        Season[] seasons = Season.values();
        System.out.println(Arrays.toString(seasons));
        Season summer = Season.valueOf("SUMMER");
        System.out.println(summer);

        printSeasonMessage (season);

        String message = getSeasonMessage(season);

    }

    private static String getSeasonMessage(Season season) {
        String message = switch (season){
            case AUTUMN -> "Autumn message";
            case WINTER -> "Winter message";
            case SPRING -> "Spring message";
            case SUMMER -> "Summer message";
        };
        return message;
    }

    public static void printSeasonMessage(Season season) {
        switch (season){
            case WINTER -> System.out.println("It is snowing");
            case SPRING -> System.out.println("It is blooming");
            case AUTUMN -> System.out.println("It is raining");
            default -> System.out.println("It is shinning");
        }
    }
}
