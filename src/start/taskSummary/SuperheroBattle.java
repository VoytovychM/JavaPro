package start.taskSummary;

public class SuperheroBattle {
    public static void main(String[] args) {
        Superhero superhero1 = new Superhero("Iron Man", 40, new Weapon("Iron", 45), new Protection("Armor", 5));
        Superhero superhero2 = new Superhero("Thor", 55, new Weapon("Thunder", 45), new Protection("Hammer", 8));
        EvilCreature evilCreature1 = new EvilCreature("Lokie", 20, 4);
        EvilCreature evilCreature2 = new EvilCreature("Thanos", 40, 9);

        superhero1.introduce();
        System.out.println(superhero1.toString());
        superhero2.introduce();
        System.out.println(superhero2.toString());

        evilCreature1.introduce();
        System.out.println(evilCreature1.toString());
        evilCreature2.introduce();
        System.out.println(evilCreature2.toString());

        System.out.println("======== Battle begins ========");


        EvilCreature rand1 = EvilCreature.generateRandomEvilCreature();
        rand1.introduce();
        System.out.println(rand1.toString());
        EvilCreature rand2 = EvilCreature.generateRandomEvilCreature();
        rand2.introduce();
        System.out.println(rand2.toString());

        while (superhero1.getHealth() > 0 && superhero2.getHealth() > 0 && evilCreature1.getHealth() > 0 && evilCreature2.getHealth() > 0) {
            superhero1.fight(evilCreature1);
            superhero2.fight(evilCreature2);
            evilCreature1.fight(superhero1);
            evilCreature2.fight(superhero2);
            superhero2.fight(rand1);
            superhero1.fight(rand2);


            System.out.println("Iron Man health: " + superhero1.getHealth());
            System.out.println("Thor health: " + superhero2.getHealth());
            System.out.println("Lokie health: " + evilCreature1.getHealth());
            System.out.println("Thanos health: " + evilCreature2.getHealth());
            System.out.println("rand2 health: " + rand2.getHealth());
            System.out.println("rand1 health: " + rand1.getHealth());

            Doctor doctor = new Doctor();
            doctor.cure(superhero1);
            doctor.increaseForce(superhero1);
            doctor.cure(new Superhero[]{superhero1, superhero2});
            doctor.increaseForce(new Superhero[]{superhero1, superhero2});
            }

        }
    }


