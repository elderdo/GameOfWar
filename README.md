# Game of War Simulator

This project is a simulator of the card game called Game of War.  The rules listed below is what I have chosen to implement.  This project is an exercise on TDD, OOP, and docstring.

### Game Rules
1. Minimum of 2 players required for this game.
2. Only card's rank is used to compare with other cards (card's suit is ignored).
3. Cards are dealt to each player evenly until the deck does not have enough card to deal for all player.
4. Player collected the most card at the end of the game wins the game.
5. When players tide on highest rank card, a war is declared between these players only.  All players with lower rank card are not eligible to win the war, but they are still required to put out their cards in the war.
6. When a war is declared between players, every player put out one card then reveal an additional card.  Note every players put at least 2 cards, but only the players in the war are to be compete.
7. The game is over when any player runs out of card to play.
8. If the game ends while during a war, the number of card collected before the war are used to determine the winner (cards in war are left unclaimed).

### Build
Compile the program
`javac Main.java`

Run the program with 4 suits, 13 ranks, and 3 players
`java Main 4 13 3`

Output of running the command above may look something like this
```
Deal Card: r2:s4
Deal Card: r13:s4
Deal Card: r13:s1
War is on between players: [1, 2]
--- Deal extra round
Deal Card: r1:s3
Deal Card: r9:s3
Deal Card: r11:s1
--------------------
Deal Card: r6:s2
Deal Card: r2:s2
Deal Card: r4:s3
Player 2 collected 9 cards
Deal Card: r6:s3
Deal Card: r2:s3
Deal Card: r12:s3
Player 2 collected 3 cards
Deal Card: r10:s4
Deal Card: r11:s2
Deal Card: r7:s2
Player 1 collected 3 cards
Deal Card: r5:s4
Deal Card: r5:s2
Deal Card: r8:s1
Player 2 collected 3 cards
Deal Card: r3:s2
Deal Card: r4:s4
Deal Card: r12:s4
Player 2 collected 3 cards
Deal Card: r11:s3
Deal Card: r1:s4
Deal Card: r5:s1
Player 0 collected 3 cards
Deal Card: r8:s3
Deal Card: r7:s3
Deal Card: r10:s2
Player 2 collected 3 cards
Deal Card: r4:s2
Deal Card: r3:s3
Deal Card: r13:s3
Player 2 collected 3 cards
Deal Card: r5:s3
Deal Card: r11:s4
Deal Card: r10:s1
Player 1 collected 3 cards
Deal Card: r12:s1
Deal Card: r9:s4
Deal Card: r2:s1
Player 0 collected 3 cards
Deal Card: r3:s4
Deal Card: r9:s1
Deal Card: r12:s2
Player 2 collected 3 cards
Deal Card: r4:s1
Deal Card: r7:s4
Deal Card: r6:s1
Player 1 collected 3 cards
Deal Card: r1:s2
Deal Card: r9:s2
Deal Card: r6:s4
Player 1 collected 3 cards
Deal Card: r1:s1
Deal Card: r7:s1
Deal Card: r8:s4
Player 2 collected 3 cards
Deal Card: r8:s2
Deal Card: r10:s3
Deal Card: r3:s1
Player 1 collected 3 cards
The winner is player 2 collected 30 cards
```
