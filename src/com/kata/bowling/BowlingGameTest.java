package com.kata.bowling;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {

    @org.junit.jupiter.api.Test
    void shouldCalculateAllMissesAndReturnZero() {
        Game game = new Game("-- -- -- -- -- -- -- -- -- -- ");
        Assertions.assertEquals(0,game.getTotalPoints());
    }
//200
    @org.junit.jupiter.api.Test
    void shouldCalculateAllStrikesAndReturnMax() {
        Game game = new Game("X X X X X X X X X XXX");
        Assertions.assertEquals(300,game.getTotalPoints());
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateAllSparesAndReturnScore() {
        Game game = new Game("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5");
        Assertions.assertEquals(150,game.getTotalPoints());
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateMissesAndValuesAndReturnScore() {
        Game game = new Game("9- 9- 9- 9- 9- 9- 9- 9- 9- 9-");
        Assertions.assertEquals(90,game.getTotalPoints());
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateMixedStrikesAndSparesAndReturnScore() {
        Game game = new Game("6/ 2/ X 4/ X 4/ X 3/ X 2/1");
        Assertions.assertEquals(183,game.getTotalPoints());
    }

//184
    @org.junit.jupiter.api.Test
    void shouldCalculateMixedEndingWithStrikeAndReturnScore() {
        Game game = new Game("6/ 2/ X 4/ X 4/ X 3/ X X11");
        Assertions.assertEquals(185,game.getTotalPoints());
    }
//169
    @org.junit.jupiter.api.Test
    void shouldCalculateMixedDoubleStrikesAndSparesAndReturnScore() {
        Game game = new Game("6/ 2/ X X 3/ 4/ X X 4/ 2/1");
        Assertions.assertEquals(176,game.getTotalPoints());
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateMixedAndReturnScore() {
        Game game = new Game("6/ -- -4 X -- 4/ X 8- 41 2/1");
        Assertions.assertEquals(86,game.getTotalPoints());
    }
}