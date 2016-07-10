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
    public final int RANK;
    public final int SUIT;

    public static final int LOWEST_RANK = 0;
    public static final int LOWEST_SUIT = 0;

    /**
     * Constructor to initialize a new Card
     * @param rank the rank of the card
     * @param suit the suit of the card
     */
    public Card(int rank, int suit) {
        if (LOWEST_RANK > rank || LOWEST_SUIT > suit) {
            throw new RankOrSuiteTooLowException();
        }
        this.RANK = rank;
        this.SUIT = suit;
    }

    @Override
    public int compareTo(Card o) {
        if (this.RANK > o.RANK) {
            return 1;
        } else if (this.RANK < o.RANK) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * Exception to indicate rank or suit is lower than the value specified in
     * LOWEST_RANK and LOWEST_SUIT
     */
    public class RankOrSuiteTooLowException extends RuntimeException {
    }
}
