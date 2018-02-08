package cards.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class Game to play a game of cards.
 * The constructor receives as argument the names of players and instantiates them. 
 * There may be two or more players.
 * In one round of the game, each player draws a card from his deck; 
 * The player with the highest card wins a point. No points awarded for a tie.
 * The game ends when there are no more cards left.
 * The player with the most points wins.
 * @author HUANG Shenyuan
 * @version 2017.12.29
 */
class Game {
	// A list to save all the players in this game.
	private List<Player> allPlayers;
	// To save the card in each one's hand in each round.
	private Map<Player, Card> allHands;
	// To save the round number.
	private int round;

	/**
	 * Receives the players' name and creates players for them.
	 * initialize and fill the List with all players.
	 * @param names several players' names can be receive
	 */
	public Game(String... names) {
		round = 0;
		allPlayers = new ArrayList<>();
		allHands = new HashMap<>();
		for (String name : names) {
			allPlayers.add(new Player(name));
		}
	}

	/**
	 * Start the game and play the game round by round.
	 * When all the cards have been drawed,the game ends.
	 * And then we annonce the final ranking.
	 */
	public void gameStart() {
		while (allPlayers.get(0).hasCard()) {
			round++;
			roundStart();
		}
		printRank();
	}

	/**
	 * When a round starts,we print "******Round X******".
	 * Every player draw a card.
	 * We print every player's hand.(the card in hand)
	 * The Dealer judges.
	 */
	private void roundStart() {
		System.out.println("**********Round " + round + "**********\n");
		playerDraw();
		printHands(allHands);
		judge(allHands);
	}

	/**
	 * Each player draw a card and save the card in the Map allHands.
	 */
	private void playerDraw() {
		allPlayers.forEach(player -> allHands.put(player, player.drawCard()));
	}

	/**
	 * The judge analyse everyone's hand card,and then gives the result to the 
	 * umpire,andthen he declares the result of this round.
	 * @param allHands A map for saving players and their cards.
	 */
	private void judge(Map<Player, Card> allHands) {
		Card biggest = new Card();// Initialize biggest by default smallest
									// card.
		int numOfMax = 0;// Helps to judge whether this round is a dogfall(TIE)
		Player markedPlayer = new Player("Nobody");// Used to mark the owner of
													// biggest card
		for (Player player : allHands.keySet()) {
			Card cardNew = allHands.get(player);
			if (cardNew.theSameAs(biggest)) {
				numOfMax++;
			} else if (cardNew.biggerThan(biggest)) {
				biggest = cardNew;
				numOfMax = 1;
				markedPlayer = player;
			}
		}
		umpire(numOfMax, markedPlayer);
	}

	/**
	 * The umpire will decide and declare the result of this round
	 * If numOfMax==1 someone win
	 * Else TIE
	 * @param numOfMax The number of the biggest Cards
	 * @param markedPlayer The player who has the biggest Card
	 */
	private void umpire(int numOfMax, Player markedPlayer) {
		if (numOfMax == 1) {
			markedPlayer.addPoints();
			System.out.println(
					"\n->Congratulations\n->" + markedPlayer + " wins!\n\n\n");
		} else {
			System.out.println("\n->TIE!");
		}
	}

	/**
	 * Print the final result (ranked)like:
	 * 
	 * >====************====<
	 * >====Final Points====<
	 * >====************====<
	 * Rank	|Player	|points
	 * ======================
	 * 1	|HUANG	|13		|Winner!
	 * 1	|Tom	|13		|Winner!
	 * 3	|Seiya	|8		|
	 * 3	|Jack	|8		|
	 * 5	|Jerry	|7		|
	 */
	private void printRank() {
		
			printFinalTitle();
			rank();
			int size = allPlayers.size();
			int num = 0;// To record the number of player who has the same point
			for (int i = 0; i < size; i++) {
				System.out.printf(i + 1 - num + "\t|");// print each one's rank
				allPlayers.get(i).printPoints();
				if (i + 1 - num == 1)
					System.out.printf("Winner!");// Anyone who ranks 1 is winner
				System.out.printf("\n");
				if (i + 1 < size
						? allPlayers.get(i).noBigThan(allPlayers.get(i + 1))
						: false)// Compare with the next player's point,num++ if
								// the same(Only if has next)
					num++;
				else
					num = 0;
			}

		}
	

	/**
	 * Use the Bubble Sort to rank.
	 */
	private void rank() {
		int size = allPlayers.size();
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - 1 - i; j++) {
				if (allPlayers.get(j).noBigThan(allPlayers.get(j + 1))) {
					Collections.swap(allPlayers, j, j + 1);
				}
			}
		}
	}

	/**
	 * To print everyone's hand like:
	 * 
	 * Player	|hand
	 * ===========================
	 * Tom		|10	of spades
	 * Seiya	|3	of clubs
	 * HUANG	|J	of hearts
	 * Jack		|7	of clubs
	 * Jerry	|A	of hearts
	 * @param allHands A map for saving players and their cards.
	 */
	private void printHands(Map<Player, Card> allHands) {
		System.out.println("Player\t|hand");
		System.out.println("===========================");
		allHands.keySet().forEach(player -> System.out
				.println(player + "\t|" + allHands.get(player)));
	}

	/**
	 * Doesn't important
	 */
	private void printFinalTitle() {
		System.out.println(">====************====<");
		System.out.println(">====Final Points====<");
		System.out.println(">====************====<\n");
		System.out.println("Rank\t|Player\t|points");
		System.out.println("======================");
	}

}
