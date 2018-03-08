package poker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Groupe A
 * @date 2018-3-6
 */
class Hand {
	List<Card> cards = new ArrayList<>();
	private final static Card MINICARD = new Card(Rank.TWO);
	private final static int HAND_LIMIT = 3;
	Card maxCard;

	void drawCard(List<Card> cards) {
		maxCard = MINICARD;
		this.cards.clear();
		if (cards.size() != HAND_LIMIT)
			throw new RuntimeException("The number of the cards is not valid");
		for (int i = 0; i < HAND_LIMIT; i++) {

			this.cards.add(cards.get(i));
		}
		for (int i = 0; i < HAND_LIMIT; i++) {
			Card mini = MINICARD;
			if (mini.compareWith(this.cards.get(i)) <= 0)
				mini = this.cards.get(i);
			maxCard = mini;
		}
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
