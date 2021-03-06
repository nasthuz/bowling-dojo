package com.kata.bowling;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {

    @org.junit.jupiter.api.Test
    void shouldCalculateAllMissesAndReturnZero() {
        Game game = new Game("-- -- -- -- -- -- -- -- -- -- ");
        Assertions.assertEquals(0,game.getTotalPoints());
    }

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

    @org.junit.jupiter.api.Test
    void shouldCalculateMixedEndingWithStrikeAndReturnScore() {
        Game game = new Game("6/ 2/ X 4/ X 4/ X 3/ 4/ X11");
        Assertions.assertEquals(178,game.getTotalPoints());
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateMixedAndReturnScore() {
        Game game = new Game("6/ -- -4 X -- 4/ X 8- 41 2/1");
        Assertions.assertEquals(86,game.getTotalPoints());
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateOpenFramesWithStrikeEndingAndReturnScore() {
        Game game = new Game("11 11 11 11 11 11 11 11 11 XXX");
        Assertions.assertEquals(48,game.getTotalPoints());
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateOpenFramesWithSpareEndingAndReturnScore() {
        Game game = new Game("11 11 11 11 11 11 11 11 11 1/1");
        Assertions.assertEquals(29,game.getTotalPoints());
    }

    @org.junit.jupiter.api.Test
    void invalidNumberOfFramesLessThanTenExceptionTesting() {
        Game game = new Game("11 11 11 11 11 11 11 ");
        assertThrows(IllegalArgumentException.class,
                () -> game.convertInitData("Invalid number of frames"));
    }

    @org.junit.jupiter.api.Test
    void invalidNumberOfFramesMoreThanTenExceptionTesting() {
        Game game = new Game("11 11 11 11 11 11 11 11 11 11 11 11 11");
        assertThrows(IllegalArgumentException.class,
                () -> game.convertInitData("Invalid number of frames"));
    }
}