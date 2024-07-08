package practice20240429;

public abstract class Actor {
    protected String name;
    protected String skill;

    public Actor(String name, String skill) {
        this.name = name;
        this.skill = skill;
    }

    abstract void showTalant();


}
