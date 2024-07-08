package practice20240429;

public class Singer extends Actor {

    public Singer(String name, String skill) {
        super(name, skill);
    }

    @Override
    public void showTalant() {
        System.out.println(name + " is singing Lady in Red " + skill);
    }
}
