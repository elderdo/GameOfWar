/**
 * Copyright (c) 2016 Hong Quach
 *
 * This source file is licensed under the "MIT License."  Please see the LICENSE
 * in this distribution for license terms.
 */
package com.gameofwar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.gameofwar.model.GameResults.NO_RESULT;
import static com.gameofwar.model.GameResults.ONE_WINNER;
import static com.gameofwar.model.GameResults.TIED;
import static org.junit.Assert.*;

public class WarTest {
    private War game = new War();

    private final int NUMBER_OF_RANKS = 13;
    private final int NUMBER_OF_SUITS = 4;
    private final int NUMBER_OF_PLAYERS = 2;

    @Before
    public void setUp() {
        assertEquals(0, game.getNumberOfSuits());
        assertEquals(0, game.getNumberOfRanks());
        assertEquals(0, game.getNumberOfPlayers());
        assertEquals(NO_RESULT, game.getStatus());
    }

    @After
    public void tearDown() {
        game = null;
    }

    @Test
    public void play() {
        game.play(NUMBER_OF_SUITS, NUMBER_OF_RANKS, NUMBER_OF_PLAYERS);
        assertNotEquals(NO_RESULT, game.getStatus());
        assertTrue(ONE_WINNER == game.getStatus() || TIED == game.getStatus());
    }

    @Test
    public void playTie() {
        game.play(NUMBER_OF_SUITS, 1, NUMBER_OF_PLAYERS);
        assertNotEquals(NO_RESULT, game.getStatus());
        assertEquals(TIED, game.getStatus());
    }

    @Test
    public void playOneWinner() {
        game.play(1, NUMBER_OF_RANKS, NUMBER_OF_PLAYERS);
        assertNotEquals(NO_RESULT, game.getStatus());
        assertEquals(ONE_WINNER, game.getStatus());
    }

    @Test(expected = War.DeckTooSmall.class)
    public void playNotEnoughCard() {
        game.play(NUMBER_OF_SUITS, NUMBER_OF_RANKS,
                (NUMBER_OF_SUITS * NUMBER_OF_RANKS) + 1);
    }

    @Test
    public void main() {
        String[] args = {Integer.toString(NUMBER_OF_SUITS),
                Integer.toString(NUMBER_OF_RANKS),
                Integer.toString(NUMBER_OF_PLAYERS)};
        game.main(args);
    }

    @Test
    public void mainWithLessArgs() {
        String[] args = {Integer.toString(NUMBER_OF_SUITS),
                Integer.toString(NUMBER_OF_RANKS)};
        game.main(args);
    }

    @Test
    public void mainWithMoreArgs() {
        String[] args = {Integer.toString(NUMBER_OF_SUITS),
                Integer.toString(NUMBER_OF_RANKS),
                Integer.toString(NUMBER_OF_PLAYERS),
                "3"};
        game.main(args);
    }

    @Test
    public void mainWithNonIntegerArg() {
        String[] args = {Integer.toString(NUMBER_OF_SUITS),
                Integer.toString(NUMBER_OF_RANKS),
                "a"};
        game.main(args);
    }

}