package start.dayonePr;

public class SimplePegas {
    public static void main(String[] args) {
        Horse horse1 = new Horse();
        System.out.println(horse1);

        Horse horse2 = new Horse("Vasia", 5000, 50);
        System.out.println(horse2);

        Pegasus pegasus1 = new Pegasus("Pegasus ", 3000, 60);
        pegasus1.run();
        System.out.println(pegasus1);
        pegasus1.fly();

    }
}
