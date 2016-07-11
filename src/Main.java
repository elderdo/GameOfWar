/**
 * Copyright (c) 2016 Hong Quach
 *
 * This source file is licensed under the "MIT License."  Please see the LICENSE
 * in this distribution for license terms.
 */
import com.gameofwar.War;

public class Main {

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

    /**
     * Print the help message
     */
    private static void helpMessage() {
        System.out.println("Exactly three arguments are needed to play:");
        System.out.println("\tNumber of suits, number of ranks, " +
                "and number of players");
        System.out.println("\tNote: the number of suits and ranks make up " +
                "the number of cards which must be enough to deal at least " +
                "one round for all players.");
    }
}
