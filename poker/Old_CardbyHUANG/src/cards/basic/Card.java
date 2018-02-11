package cards.basic;

/**
 * A Card has its suit and rank,they will be initialized when a Card object is
 * created. It has its own methods to compare with other cards. We will get
 * "rank of suit" if we try to print a Card.
 * @author HUANG Shenyuan
 * @version 2017.12.29
 */
class Card {
	private Suit suit;
	private Rank rank;

	/**
	 * Initialise with the Rank and Suit.
	 * @param suit Suit of Card
	 * @param rank Rank of Card
	 */
	Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	/**
	 * If there is no param, it will create a smallest one
	 */
	Card() {
		this.suit = Suit.CLUBS;
		this.rank = Rank.TWO;
	}

	/**
	 * @param card That card to compare with this card
	 * @return true if this card is bigger than that card, false if equal or smaller.
	 */
	boolean biggerThan(Card card) {
		return this.rank.equals(card.rank) ? this.suit.biggerThan(card.suit)
				: this.rank.biggerThan(card.rank);
	}

	/**
	 * @param card That card to compare with this card
	 * @return true if this card is as big as that card
	 */
	public boolean theSameAs(Card card) {
		return card.rank.equals(this.rank) && card.suit.equals(this.suit);
	}

	/**
	 * Override the toString
	 * @return String like "RANK of SUIT"
	 */
	@Override
	public String toString() {
		return rank + "\tof " + suit;
	}
}
