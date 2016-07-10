/**
 * Copyright (c) 2016 Hong Quach
 *
 * This source file is licensed under the "MIT License."  Please see the LICENSE
 * in this distribution for license terms.
 */
package com.gameofwar;

import com.gameofwar.model.Card;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A standard deck of 52 cards with 4 suits and 13 ranks.
 */
public class StandardDeck implements Deck {

    private ArrayList<Card> deck = new ArrayList<>();

    @Override
    public void create(int numberOfSuits, int numberOfRanks) {
        if (0 < getSize()) {
            throw new DeckIsNotEmptyException();
        }
        if (numberOfRanks < 0 || numberOfSuits < 0) {
            throw new InvalidParameterException();
        }
        for (int r = 1; r <= numberOfRanks; r++) {
            for (int s = 1; s <= numberOfSuits; s++) {
                deck.add(new Card(r, s));
            }
        }
    }

    @Override
    public void shuffle() {
        Collections.shuffle(deck);
    }

    @Override
    public Card deal() {
        if (0 >= getSize()) {
            throw new DeckIsEmptyException();
        }
        return deck.remove(0);
    }

    /**
     * Get the current card count of the deck
     * @return number of cards in the deck
     */
    public int getSize() {
        return deck.size();
    }

    /**
     * Exception to indicate the deck is empty
     */
    public class DeckIsEmptyException extends RuntimeException {
    }

    /**
     * Exception to indicate the deck is not empty
     */
    public class DeckIsNotEmptyException extends RuntimeException {
    }
}
