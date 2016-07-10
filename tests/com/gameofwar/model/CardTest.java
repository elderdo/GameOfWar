/**
 * Copyright (c) 2016 Hong Quach
 *
 * This source file is licensed under the "MIT License."  Please see the LICENSE
 * in this distribution for license terms.
 */
package com.gameofwar.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void compareTo() {
        final int RANKS = 13;
        final int SUITS = 4;

        //Create a set of cards
        Card[][] cards = new Card[RANKS][SUITS];
        for (int i = 0; i < RANKS; i++) {
            for (int j = 0; j < SUITS; j++) {
                cards[i][j] = new Card(i, j);
            }
        }

        for (int i = 0; i < RANKS; i++) {
            for (int j = 0; j < SUITS; j++) {
                // Assert cards with inequality rank
                for (int k = i + 1; k < RANKS; k++) {
                    assertTrue(0 > cards[i][j].compareTo(cards[k][j]));
                    assertTrue(0 < cards[k][j].compareTo(cards[i][j]));
                }
                // Assert the property of compareTo for a given card against
                // all cards
                for (int p = 0; p < RANKS; p++) {
                    for (int q = 0; q < SUITS; q++) {
                        assertTrue(cards[i][j].compareTo(cards[p][q])
                                == -(cards[p][q].compareTo(cards[i][j])));
                    }
                }
            }
        }
    }

}