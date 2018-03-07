package poker;

/**
 * @author Groupe A
 * @date 2018-2-15
 */
enum Rank {
	ONE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"), TEN("10"), JACK(
			"J"), QUEEN("Q"), KING("K");
	private String name;

	Rank(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}

	int getValue() {
		return this.ordinal();
	}
}
