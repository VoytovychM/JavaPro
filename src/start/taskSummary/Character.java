package start.taskSummary;

public abstract class Character {
    private String name;
    private int health = 100;

    Character(String name) {
        this.name = name;

    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void introduce() {
        System.out.println("Hello! My name is " + name);
    }

    public abstract int countForce();

    public abstract int countProtection();

    public void fight(Character another) {

        System.out.println(this.getName() + " fights with " + another.getName());
        int myForce = countForce();
        int anotherForce = another.countForce();
        if (myForce < anotherForce) {
            System.out.println(another.getName() + " wins");
            this.health = this.health - (anotherForce - myForce) / countProtection();
        } else if (myForce > anotherForce) {
            System.out.println(this.getName() + " wins");
            another.health = another.health - (myForce - anotherForce) / another.countProtection();
        } else {
            System.out.println("No one wins. Powers are equal");
        }
    }


    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", health=" + health +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

}
