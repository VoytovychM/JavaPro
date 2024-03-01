package start.taskSummary;

public class Doctor implements CurableSkills {
    public void cure (Character character){
        int newHealth = 150;
        character.setHealth(newHealth);
        System.out.println("Doctor cured " + character + ".");
    }

    public void increaseForce (Superhero character){
        int newForce = (int) (character.countForce() + character.countForce() * 0.1 * character.getProtection().getLevel());
        character.getWeapon().setForce(newForce);
        System.out.println(character + " obtained new force: " + newForce);
    }

    @Override
    public void increaseForce(Superhero[] characters) {
        for (Superhero superhero:characters) {
            increaseForce(superhero);
        }
    }

    public void cure(Character[] characters) {
        for (Character character : characters) {
            cure(character);
        }
        }
}

