package lesson20240325;

import java.util.EnumSet;
import java.util.Set;

public class SetWithEnum {

    public enum Colour{
        RED, GREEN, WHITE, BLACK
    }


    public static void main(String[] args) {
        Set<Colour> availableColours = EnumSet.noneOf(Colour.class);
        availableColours.add(Colour.BLACK);
        availableColours.add(Colour.GREEN);
        availableColours.add(Colour.WHITE);

        if(availableColours.contains(Colour.WHITE)){
            System.out.println("White color is available");


        }
    }
}
