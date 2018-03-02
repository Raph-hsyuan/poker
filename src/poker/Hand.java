package poker;

import java.util.ArrayList;
import java.util.List;

class Hand {
	List<Card> cards = new ArrayList<Card>();
	private final static int HAND_LIMIT = 2;

	void drawCard(List<Card> cards) {
		if (cards.size() != HAND_LIMIT)
			throw new RuntimeException("The number of the cards is not valid");
		for (int i = 0; i < HAND_LIMIT; i++)
			this.cards.add(cards.get(i));
	}

	/*
	 * Only use for test
	 */
	List<Card> getCard() {
		return cards;
	}

	void printHand() {
		System.out.print("HAND: ");
		for (int i = 0; i < HAND_LIMIT; i++)
			System.out.print(cards.get(i) + " ");
	}
}
