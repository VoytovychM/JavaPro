package start.taskSummary;

public class Superhero extends Character {
    private int force;
    private Weapon weapon;
    private Protection protection;

    Superhero(String name, int force, Weapon weapon, Protection protection) {
        super(name);
        this.force = force;
        this.weapon = weapon;
        this.protection = protection;
    }

    @Override
    public int countForce() {
        return force + weapon.getForce();
    }

    @Override
    public int countProtection() {
        return protection.level;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Protection getProtection() {
        return protection;
    }

    @Override
    public String toString() {
        return "Superhero{" + getName() +
                "force=" + force +
                ", weapon=" + weapon +
                ", protection=" + protection +
                '}';
    }
}

