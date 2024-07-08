package lesson20240617.refactoring;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/** The algorithm that counts income for voters in accordance with their prediction.
     * <p>Logic of the algorithm:
     * <p>1. If a player had voted for a team that lost, the money of a player is put to the winner's pool.
     * <p>2. If a player had voted for a team that won, he/she recieves an income according to this formula:
     * <p>income = normKoeff * stake * EXPONENTIAL_QUANTITY^-abs(result - prediction);
     * <p>where:
     * "normKoeff" - normalized koeff.,
     * "stake" - player's money put on goal count "prediction",
     * "result" - real goal count.*/

    public class GainAlgorithm {

        private static final int EXPONENTIAL_QUANTITY = 3;
        private static final int MAX_GOAL_DIFFERENCE = 5;

        public static ArrayList<Bet> calculateIncomeForWinningBets(Match match, List<Bet> list) {
            ArrayList<Bet> winningBets = list.stream().filter(bet -> bet.hasWon(match)).collect(Collectors.toCollection(ArrayList::new));

            double[] normCoeffArray = getNormCoeffArray(match.getGoalDifference());
            double[] normCoeffArrayWithStake = getNormCoeffArrayWithStake(winningBets, normCoeffArray);
            double sumCoeff = Arrays.stream(normCoeffArrayWithStake).sum();

            int pricePool = calculatePricePool(match, list);
            double normCoeff = (double) pricePool / sumCoeff;

            setEarnedMoneyForWinningBet(winningBets, normCoeff, normCoeffArrayWithStake);
            return winningBets;
        }

        private static void setEarnedMoneyForWinningBet(ArrayList<Bet> winingBets, double normCoeff, double[] normCoeffArrayWithStake) {
            for (int i = 0; i < winingBets.size(); i++) {
                Bet bet = winingBets.get(i);
                bet.setEarned(bet.getStake() + (int)(normCoeff * normCoeffArrayWithStake[i]));
            }
        }

        private static double[] getNormCoeffArrayWithStake(ArrayList<Bet> winingBets, double[] normCoeffArray) {
            double[] normCoeffArrayWithStake = new double[winingBets.size()];
            for (int i = 0; i < winingBets.size(); i++) {
                Bet bet = winingBets.get(i);
                normCoeffArrayWithStake[i] = normCoeffArray[Math.abs(bet.getCondition()) - 1]*bet.getStake();
            }
            return normCoeffArrayWithStake;
        }

        private static double[] getNormCoeffArray(int goalDifference) {
            double[] normCoeffArray = new double[MAX_GOAL_DIFFERENCE];
            for (int i = 0; i < MAX_GOAL_DIFFERENCE; i++) {
                normCoeffArray[i] = Math.pow(EXPONENTIAL_QUANTITY, - Math.abs(Math.abs(goalDifference) - i - 1));
            }
            return normCoeffArray;
        }

        private static int calculatePricePool(Match match, List<Bet> list) {
            return list.stream().filter(bet -> !bet.hasWon(match)).mapToInt(Bet::getStake).sum();
        }

    }

