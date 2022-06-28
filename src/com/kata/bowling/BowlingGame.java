package com.kata.bowling;

public class BowlingGame {
    public static void main(String[] args) {
//        Game game = new Game("12 71 5/ 23 X 52 4/ 80 X 5/1");
        Game game = new Game("args[0]");
        System.out.println("\nThe Bowling Game score is = " + game.getTotalPoints());
    }
}
