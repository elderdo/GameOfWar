/**
 * Copyright (c) 2016 Hong Quach
 *
 * This source file is licensed under the "MIT License."  Please see the LICENSE
 * in this distribution for license terms.
 */
package com.gameofwar;

import com.gameofwar.model.Card;

/**
 * Game of War
 */
public class War {

    /**
     * Play a game of War with the following eight rules:
     *     R1. Minimum of 2 players required for this game.
     *     R2. Only card's rank is used to compare with other cards (card's
     *     suit is ignored).
     *     R3. Cards are dealt to each player evenly until the deck does not
     *     have enough card to deal for all player.
     *     R4. Player collected the most card at the end of the game wins the
     *     game.
     *     R5. When players tide on highest rank card, a war is declared
     *     between these players only.  All players with lower rank card are
     *     not eligible to win the war, but they are still required to put out
     *     their cards in the war.
     *     R6. When a war is declared between players, every player put out one
     *     card then reveal an additional card.  Note every players put at
     *     least 2 cards, but only the players in the war are to be compete.
     *     R7. The game is over when any player runs out of card to play.
     *     R8. If the game ends while during a war, the number of card
     *     collected before the war are used to determine the winner (cards in
     *     war are left unclaimed).
     * @param numberOfSuits number of suits to use in this game
     * @param numberOfRanks number or ranks to use in this game
     * @param numberOfPlayers number of player in this game.  Minimum 2 is
     *                        required.
     */
    public void play(int numberOfSuits, int numberOfRanks, int numberOfPlayers) {
        throw new UnsupportedOperationException();
    }

    /**
     * Program entry point
     * @param args:  A commas separated values for number_of_suits,
     *            number_of_ranks, and _number_of_players
     */
    public static void main(String[] args) {
        War war = new War();
        war.play(4, 13, 2);
    }
}
