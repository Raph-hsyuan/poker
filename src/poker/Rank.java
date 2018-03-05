package poker;

enum Rank {
	ONE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5");
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
