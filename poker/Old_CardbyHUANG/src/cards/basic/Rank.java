package cards.basic;

/**
 * Representations for all the Ranks of card for the game along with a string of
 * its name.
 * @author HUANG Shenyuan
 * @version 2017.12.29
 */
enum Rank {
	// A value for each Rank along with its name String
	TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"),
	EIGHT("8"), NINE("9"), TEN("10"), JACK("J"), QUEEN("Q"), KING("K"),
	ACE("A");
	// The Rank name String
	private final String name;

	/**
	 * Initialise with the Rank name String.
	 * @param name The Rank string.
	 */
	Rank(String name) {
		this.name = name;
	}

	/**
	 * @param rank The Rank to compare with.
	 * @return True if it is bigger than the rank takein, false otherwise.
	 */
	boolean biggerThan(Rank rank) {
		return this.compareTo(rank) > 0;
	}

	/**
	 * Override the toString
	 * @return name The name of Rank.
	 */
	@Override
	public String toString() {
		return name;
	}
}