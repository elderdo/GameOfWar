/**
 * Copyright (c) 2016 Hong Quach
 *
 * This source file is licensed under the "MIT License."  Please see the LICENSE
 * in this distribution for license terms.
 */
package com.gameofwar;

import com.gameofwar.model.Card;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class StandardDeckTest {
    private StandardDeck deck;
    private final int NUMBER_OF_SUITS = 4;
    private final int NUMBER_OF_RANKS = 13;

    @Before
    public void setUp() {
        deck = new StandardDeck();
    }

    @After
    public void tearDown() {
        deck = null;
    }

    @Test
    public void create() {
        assertEquals(0, deck.getSize());
        deck.create(NUMBER_OF_SUITS, NUMBER_OF_RANKS);
        assertEquals(NUMBER_OF_SUITS * NUMBER_OF_RANKS, deck.getSize());
    }

    @Test(expected = InvalidParameterException.class)
    public void createNegativeNumberOfSuits() {
        assertEquals(0, deck.getSize());
        deck.create(-NUMBER_OF_SUITS, NUMBER_OF_RANKS);
        assertEquals(0, deck.getSize());
    }

    @Test(expected = InvalidParameterException.class)
    public void createNegativeNumberOfRanks() {
        assertEquals(0, deck.getSize());
        deck.create(NUMBER_OF_SUITS, -NUMBER_OF_RANKS);
        assertEquals(0, deck.getSize());
    }

    @Test(expected = StandardDeck.DeckIsNotEmptyException.class)
    public void createRepeat() {
        assertEquals(0, deck.getSize());
        deck.create(NUMBER_OF_SUITS, NUMBER_OF_RANKS);
        assertEquals(NUMBER_OF_SUITS * NUMBER_OF_RANKS, deck.getSize());
        deck.create(2, 2);
    }

    @Ignore
    public void shuffle() {
        //Not testable as shuffle can produce the same deck as the original deck
    }

    @Test
    public void deal() {
        deck.create(NUMBER_OF_SUITS, NUMBER_OF_RANKS);
        ArrayList<Card> dealtDeck = new ArrayList();
        while (0 < deck.getSize()) {
            assertFalse(dealtDeck.contains(deck.deal()));
        }
    }

    @Test
    public void getSize() {
        assertEquals(0, deck.getSize());
        deck.create(NUMBER_OF_SUITS, NUMBER_OF_RANKS);
        for (int i = NUMBER_OF_SUITS * NUMBER_OF_RANKS; i > 0; i--) {
            assertEquals(i, deck.getSize());
            deck.deal();
            assertEquals(i - 1, deck.getSize());
        }
    }

}