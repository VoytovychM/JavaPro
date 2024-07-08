package practice20240429;

public class Dancer extends Actor{


    public Dancer(String name, String skill) {
        super(name, skill);
    }

    public void showTalant(){
        System.out.println(name + " is dancing contemporary style " + skill);
    }

}
