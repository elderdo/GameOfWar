/**
 * Copyright (c) 2016 Hong Quach
 *
 * This source file is licensed under the "MIT License."  Please see the LICENSE
 * in this distribution for license terms.
 */
import org.junit.Test;

public class MainTest {

    private final int NUMBER_OF_RANKS = 13;
    private final int NUMBER_OF_SUITS = 4;
    private final int NUMBER_OF_PLAYERS = 2;

    @Test
    public void main() {
        // No direct assert, just test for non failing function call
        String[] args = {Integer.toString(NUMBER_OF_SUITS),
                Integer.toString(NUMBER_OF_RANKS),
                Integer.toString(NUMBER_OF_PLAYERS)};
    }

    @Test
    public void mainWithLessArgs() {
        // No direct assert, just test for non failing function call
        String[] args = {Integer.toString(NUMBER_OF_SUITS),
                Integer.toString(NUMBER_OF_RANKS)};
        Main.main(args);
    }

    @Test
    public void mainWithMoreArgs() {
        // No direct assert, just test for non failing function call
        String[] args = {Integer.toString(NUMBER_OF_SUITS),
                Integer.toString(NUMBER_OF_RANKS),
                Integer.toString(NUMBER_OF_PLAYERS),
                "3"};
        Main.main(args);
    }

    @Test
    public void mainWithNonIntegerArg() {
        // No direct assert, just test for non failing function call
        String[] args = {Integer.toString(NUMBER_OF_SUITS),
                Integer.toString(NUMBER_OF_RANKS),
                "a"};
        Main.main(args);
    }
}