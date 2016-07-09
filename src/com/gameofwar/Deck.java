/**
 * Copyright (c) 2016 Hong Quach
 *
 * This source file is licensed under the "MIT License."  Please see the LICENSE
 * in this distribution for license terms.
 */
package com.gameofwar;

import com.gameofwar.model.Card;

/**
 * An interface for all Card deck
 */
public interface Deck {

    /**
     * Create the deck of cards with the number of rank and number of suits per
     * rank
     * @param numberOfSuits Number of suits exist in a deck of card.
     * @param numberOfRank Number of ranks exist in a deck of card
     */
    public void create(int numberOfSuits, int numberOfRank);

    /**
     * Shuffle the deck
     */
    public void shuffle();

    /**
     * Deal a card from the deck.  Return null when there is no more card in
     * the deck to deal.
     * @return a card from the deck or null
     */
    public Card deal();

}
