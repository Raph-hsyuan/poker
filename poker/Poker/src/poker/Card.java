package poker;

public class Card {
	private Rank rank;

	public Card(Rank rank) {
		this.rank = rank;
	}

	public Rank getRank() {
		return this.rank;
	}
	@Override
	public String toString() {
		return " "+rank+" ";
	}
}
