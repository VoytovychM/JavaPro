package start.taskSummary;

import java.util.Random;

public class EvilCreature extends Character {
    public int force;
    public int protection;

    public EvilCreature(String name, int force, int protection) {
        super(name);
        this.force = force;
        this.protection = protection;


    }
    public static EvilCreature generateRandomEvilCreature() {
        Random random = new Random();
        String name = "Random evil " + random.nextInt();
        EvilCreature evilCreature = new EvilCreature(name, (random.nextInt(100)), (random.nextInt(10)));
        return evilCreature;

    }

    @Override
    public int countForce() {
        return force;
    }

    @Override
    public int countProtection() {
        return protection;
    }


    @Override
    public String toString() {
        return "EvilCreature{" + getName() +
                "force=" + force +
                ", protection=" + protection +
                '}';
    }
}
