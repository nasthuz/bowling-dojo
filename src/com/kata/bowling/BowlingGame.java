package com.kata.bowling;

public class BowlingGame {
    public static void main(String[] args) {
        Game game = new Game("args[0]");
        System.out.println("\nThe Bowling Game score is = " + game.getTotalPoints());
    }
}
