package practice20240612;

import java.util.Random;

enum Menu {
        KITCHEN, SNACK, ALCOHOL;

public static Menu returnRandom() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
        }
        }