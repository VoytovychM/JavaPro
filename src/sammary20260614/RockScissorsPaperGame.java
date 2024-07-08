package sammary20260614;

public class RockScissorsPaperGame {

    public static void main(String[] args) {

        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");

        while (player1.getCountWins() < 5) {
            gameRound(player1, player2);
        }
        System.out.println(player1);
        System.out.println(player2);

    }

    public static void gameRound(Player player1, Player player2) {
        player1.makeRandomChoice();
        player2.makeRandomChoice();
        GameChoice choice1 = player1.getChoice();
        GameChoice choice2 = player2.getChoice();

        if (choice1 == choice2) {
            System.out.println("No one wins: " + choice1 + " --- " + choice2);
        } else if ((choice2.ordinal() + 1) % 3 == choice1.ordinal()) {
                getResult(player1, player2);
                } else{
                    getResult(player2, player1);
                }
        }



    private static void getResult(Player winner, Player looser) {
        looser.setCountLoosed(looser.getCountLoosed() + 1);
        winner.setCountWins(winner.getCountWins() + 1);
        System.out.println (winner.getName() + " wins:  " + winner.getChoice() + " --- " + looser.getChoice());
    }
    }
