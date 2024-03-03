package start.gamevscomputer;

import start.gamevscomputer.GameChoice;

import java.util.Random;
import java.util.Scanner;

import static start.gamevscomputer.GameChoice.*;

public class MashaPlayer extends Player{
    @Override
    public void makeRandomChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your choice: Rock, Scissors, Paper");
        String mashaChoice = scanner.next();


        if (mashaChoice.equals("Rock")) {
            choice = ROCK;
        } else if (mashaChoice.equals("Scissors")) {
            choice = SCISSORS;
        } else if (mashaChoice.equals("Paper")) {
            choice = PAPER;
        } else {
            System.out.println("Enter the right value");
            makeRandomChoice();
        }
    }
}
