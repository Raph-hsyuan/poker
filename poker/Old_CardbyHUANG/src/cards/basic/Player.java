package cards.basic;

/**
 * A Player representing a card player.
 * A player has a deck of cards (ordered) passed as an argument in the constructor.
 * The player shuffles his cards.
 * The player has an attribute points indicating how many points he currently has.
 * @author HUANG Shenyuan
 * @version 2017.12.29
 */
class Player {
	//The player has a deck of cards.
	private final Deck deck;
	//The player has a name.
	private final String name;
	//The player has his points. 
	private int points;

	/**
	 * Initialise with the Player name String,points=0,a new Deck,
	 * and then shuffle it.
	 * @param name Player's name
	 */
	Player(String name) {
		this.name = name;
		deck = new Deck();
		deck.shuffle();
		points = 0;
	}

	/**
	 * @return true if still has cards
	 */
	boolean hasCard() {
		return deck.restCard() > 0;
	}

	/**
	 * Add the point of player
	 */
	void addPoints() {
		points++;
	}

	/**
	 * Player draw a card
	 * @return card drawed
	 */
	Card drawCard() {
		return this.deck.draw();
	}

	/**
	 * print something like "HUANG	|19	|"
	 */
	public void printPoints() {
		System.out.printf(name + "\t|" + points + "\t|");
	}

	/**
	 * @param player we called that player
	 * @return true if this player's point is less than or the same as that player
	 */
	public boolean noBigThan(Player player) {
		return this.points<=player.points;
	}

	/**
	 * Override the toString
	 * @return name of Player
	 */
	@Override
	public String toString() {
		return name;
	}
}
