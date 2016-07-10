/**
 * Copyright (c) 2016 Hong Quach
 *
 * This source file is licensed under the "MIT License."  Please see the LICENSE
 * in this distribution for license terms.
 */
package com.gameofwar;

import com.gameofwar.model.Card;
import com.gameofwar.model.GameResults;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Game of War
 */
public class War {

    public static final int MINIMUM_NUMBER_OF_PLAYERS = 2;

    private int numberOfSuits = 0;
    private int numberOfRanks = 0;
    private int numberOfPlayers = 0;
    private GameResults result = GameResults.NO_RESULT;
    private Map<Integer, Integer> playersCardCount = new HashMap<>();

    /**
     * Get the number of suits used in the game
     * @return
     */
    public int getNumberOfSuits() {
        return numberOfSuits;
    }

    /**
     * Get the number of ranks used in the game
     * @return
     */
    public int getNumberOfRanks() {
        return numberOfRanks;
    }

    /**
     * Get the number of players in the game
     * @return
     */
    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    /**
     * Get the resuslt of the game
     * @return the game result
     */
    public GameResults getResult() {
        return result;
    }

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
        if (numberOfSuits * numberOfRanks < numberOfPlayers) {
            throw new DeckTooSmallException();
        }
        if (numberOfPlayers < MINIMUM_NUMBER_OF_PLAYERS) {
            throw new MinimumNumberOfPlayersNotMetException();
        }

        Card[] playersCard = new Card[numberOfPlayers];
        int numberOfCardsInPlay = 0;

        StandardDeck deck = new StandardDeck();
        initGame(numberOfSuits, numberOfRanks, numberOfPlayers, deck);

        while (numberOfPlayers < deck.getSize()) {
            // Deal
            for (int p = 0; p < numberOfPlayers; p++) {
                playersCard[p] = deck.deal();
                numberOfCardsInPlay++;
            }
            // Check result
            ArrayList<Integer> winners;
            winners = evaluateWinner(playersCard);
            if (1 < winners.size()) {
                declareWar(winners);
                if (numberOfPlayers > deck.getSize()) {
                    // game over
                    break;
                }
                for (int q = 0; q < numberOfPlayers; q++) {
                    // Deal extra cards
                    deck.deal();
                    numberOfCardsInPlay++;
                }
            } else if (1 == winners.size()) {
                int winner = winners.get(0);
                playersCardCount.replace(winner,
                        playersCardCount.get(winner) + numberOfCardsInPlay);
                numberOfCardsInPlay = 0;
            }
        }

        finalizedResult();
    }

    private void declareWar(ArrayList<Integer> players) {
        System.out.println("War is on between players: " + players);
    }

    private ArrayList<Integer> evaluateWinner(Card[] playersCard) {
        ArrayList<Integer> winners = new ArrayList<>();
        Card highestCard = new Card(Card.LOWEST_RANK, Card.LOWEST_SUIT);
        for (int p = 0; p < numberOfPlayers; p++) {
            if (0 < playersCard[p].compareTo(highestCard)) {
                winners.clear();
                winners.add(p);
                highestCard = playersCard[p];
            } else if (0 == playersCard[p].compareTo(highestCard)) {
                winners.add(p);
            }
        }
        return winners;
    }

    private void initGame(int numberOfSuits, int numberOfRanks, int numberOfPlayers, StandardDeck deck) {
        this.numberOfSuits = numberOfSuits;
        this.numberOfRanks = numberOfRanks;
        this.numberOfPlayers = numberOfPlayers;
        deck.create(this.numberOfSuits, this.numberOfRanks);
        deck.shuffle();
        for (int p = 0; p < this.numberOfPlayers; p++) {
            playersCardCount.put(p, 0);
        }
    }

    private void finalizedResult() {
        int maxCardCount = -1;
        ArrayList<Integer> winners = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: playersCardCount.entrySet()) {
            Integer cardCount = entry.getValue();
            if (maxCardCount < cardCount) {
                maxCardCount = cardCount;
                winners.clear();
                winners.add(entry.getKey());
            } else if (maxCardCount == cardCount) {
                winners.add(entry.getKey());
            }
        }
        if (winners.size() > 1) {
            result = GameResults.TIED;
            System.out.println("Game is tided by players: " +
                    winners.toString() + " each collected " +
                    maxCardCount + " cards");
        } else {
            result = GameResults.ONE_WINNER;
            System.out.println("The winner is player " + winners.get(0) +
                    " collected " + maxCardCount + " cards");
        }
    }

    /**
     * Program entry point
     * @param args:  A commas separated values for number_of_suits,
     *            number_of_ranks, and _number_of_players
     */
    public static void main(String[] args) {
        if (3 != args.length) {
            helpMessage();
            return;
        }
        War war = new War();
        try {
            war.play(Integer.parseInt(args[0]),
                    Integer.parseInt(args[1]),
                    Integer.parseInt(args[2]));
        } catch (NumberFormatException e) {
            System.out.println("Not able to parse all arguments to integers.");
            helpMessage();
        }
    }

    private static void helpMessage() {
        System.out.println("Exactly three arguments are needed to play:");
        System.out.println("\tNumber of suits, number of ranks, " +
                "and number of players");
        System.out.println("\tNote: the number of suits and ranks make up " +
                "the number of cards which must be enough to deal at least " +
                "one round for all players.");
    }

    /**
     * Exception to indicate not enough card to deal for all players
     */
    public class DeckTooSmallException extends RuntimeException {};

    /**
     * Exception to indicate not enough players
     */
    public class MinimumNumberOfPlayersNotMetException
            extends RuntimeException {};
}
