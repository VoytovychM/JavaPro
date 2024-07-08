package lesson20240410.functionalinterface;

public class SportGround {
    public static void main(String[] args) {

        Playable footballPlayer = new Playable() {
            @Override
            public void play() {
                System.out.println("I play football");
            }

//            @Override
//            public void walk() {
//                System.out.println("I walk");
//            }
        };

        Playable badmintonPlayer = () -> System.out.println("I play badminton");
        Playable chessPlayer = () -> {
            System.out.println("I play chess");
            System.out.println("I won!");
        };


        footballPlayer.play();
        badmintonPlayer.play();
        chessPlayer.play();
    }
}
