package poker;

class Card {
	private Rank rank;

	Card(Rank rank) {
		this.rank = rank;
	}

	Rank getRank() {
		return this.rank;
	}

	@Override
	public String toString() {
		return " " + rank + " ";
	}
	
	public int compareWith(Card card) {
		return this.rank.compareTo(card.rank);
	}
}
