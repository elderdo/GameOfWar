/**
 * Copyright (c) 2016 Hong Quach
 *
 * This source file is licensed under the "MIT License."  Please see the LICENSE
 * in this distribution for license terms.
 */
package com.gameofwar;

import com.gameofwar.model.Card;

/**
 * A standard deck of 52 cards with 4 suits and 13 ranks.
 */
public class StandardDeck implements Deck {
    @Override
    public void create(int numberOfSuits, int numberOfRank) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void shuffle() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Card deal() { throw new UnsupportedOperationException(); }
}
