package lesson20240415;

import lesson20240410.functionalinterface.Playable;

public class LambdaScopes {
    public static void main(String[] args) {
        String data = "Main Data";
        int counter = 0;
        Playable footbalPlayer = new Playable() {
            String data = "Anonymous data"; //shadowing
            @Override
            public void play() {
                System.out.println(data);
                System.out.println(counter); //менять нельзя распечатать можно но менять нельзя
            }
        };
        footbalPlayer.play();

        Playable chessPlayer = () ->{
            String data2 = "Lambda Data"; // possible only if name is different
            System.out.println(data2);
            System.out.println(data);
        };

        chessPlayer.play();
    }
}
