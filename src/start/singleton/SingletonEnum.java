package start.singleton;

public enum SingletonEnum {
    INSTANCE("Initial class info");

    private String info;

    SingletonEnum(String info) {
        this.info = info;
    }

    public SingletonEnum getInstance() {
        return INSTANCE;
    }

    // getters and setters
}