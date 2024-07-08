package sammary20260614;

import java.util.Random;

public class Player {
    private int countWins = 0;

    private String name;

    private int countLoosed = 0;

    private GameChoice choice;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void makeRandomChoice() {
        Random random = new Random();
        choice = GameChoice.values()[random.nextInt(GameChoice.values().length)];
    }

    public int getCountWins() {
        return countWins;
    }

    public int getCountLoosed() {
        return countLoosed;
    }

    public GameChoice getChoice() {
        return choice;
    }

    public void setCountWins(int countWins) {
        this.countWins = countWins;
    }

    public void setCountLoosed(int countLoosed) {
        this.countLoosed = countLoosed;
    }

    @Override
    public String toString() {
        return "Player{" +
                "countWins=" + countWins +
                ", name='" + name + '\'' +
                ", countLoosed=" + countLoosed +
                ", choice=" + choice +
                '}';
    }
}

