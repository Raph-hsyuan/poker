package poker;

import java.util.ArrayList;
import java.util.List;

class Hand {
	List<Card> cards = new ArrayList<Card>();
	private final static int HAND_LIMIT = 2;
	private Card maxCard;

	void drawCard(List<Card> cards) {
		if (cards.size() != HAND_LIMIT)
			throw new RuntimeException("The number of the cards is not valid");
		for (int i = 0; i < HAND_LIMIT; i++)
			this.cards.add(cards.get(i));
		if (this.cards.get(0).compareWith(this.cards.get(1))<=0) maxCard = this.cards.get(1);
		else maxCard = this.cards.get(0);
	}
	
	int compareto(Hand hand) {
		return this.maxCard.compareWith(hand.maxCard);
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
