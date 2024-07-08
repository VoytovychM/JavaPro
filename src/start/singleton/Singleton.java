package start.singleton;

public class Singleton {
    private static Singleton INSTANCE;
    private String info = "Initial info class";

    private Singleton() {
    }

    public static Singleton getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Singleton();
        }

        return INSTANCE;
    }
}