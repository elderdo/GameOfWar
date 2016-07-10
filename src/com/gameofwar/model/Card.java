/**
 * Copyright (c) 2016 Hong Quach
 *
 * This source file is licensed under the "MIT License."  Please see the LICENSE
 * in this distribution for license terms.
 */
package com.gameofwar.model;

/**
 * A Card with a given rank and suit
 */
public class Card implements Comparable<Card> {
    public final int rank;
    public final int suit;

    /**
     * Constructor to initialize a new Card
     * @param rank the rank of the card
     * @param suit the suit of the card
     */
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public int compareTo(Card o) {
        if (this.rank > o.rank) {
            return 1;
        } else if (this.rank < o.rank) {
            return -1;
        } else {
            return 0;
        }
    }
}
