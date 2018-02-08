package cards.basic;

/**
 * Representations for all the Suits of card for the game along with a string of
 * its name.
 * @author HUANG Shenyuan
 * @version 2017.12.29
 */
enum Suit {
	// A value for each Suit along with its name String
	CLUBS("clubs"), DIAMONDS("diamonds"), HEARTS("hearts"), SPADES("spades");
	// The Suit name String
	private final String name;

	/**
	 * Initialise with the Suit name String.
	 * @param name The Suit string.
	 */
	Suit(String name) {
		this.name = name;
	}

	/**
	 * @param suit The Suit to compare with.
	 * @return True if it is bigger than the suit takein, false otherwise.
	 */
	boolean biggerThan(Suit suit) {
		return this.compareTo(suit) > 0;
	}

	/**
	 * Override the toString
	 * @return name The name of Suit.
	 */
	@Override
	public String toString() {
		return name;
	}

}