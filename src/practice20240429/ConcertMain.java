package practice20240429;

import java.util.List;

public class ConcertMain {
    public static void main(String[] args) {
        Singer singer1 = new Singer("Tina", "soprano");
        Singer singer2 = new Singer("Roma", "alto");
        Dancer dancer1 = new Dancer("Lisa", "outstanding");
        Dancer dancer2 = new Dancer("Martin", "splendid");

        List<Actor> consert1 = List.of(dancer1, singer2, dancer2, singer1);

        Concert<Actor> concerts = new Concert<>(consert1);
        concerts.process();
        System.out.println("---------");
        Concert<Actor> concert2 = new Concert<>(dancer1, singer2);
        concert2.process();


    }
}
