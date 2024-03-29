package poker;

import java.util.ArrayList;

/**
 * @author Groupe A
 * @date 2018-3-10
 */
class Hand {
	ArrayList<Card> cards = new ArrayList<>();
	public static final Card MINICARD = new Card(Rank.TWO,Suit.TREFLE);
	private static final int HAND_LIMIT = 5;
	Card maxCard;

	void drawCard(ArrayList<Card> cards) {
		maxCard = MINICARD;
		this.cards.clear();
		if (cards.size() != HAND_LIMIT)
			throw new RuntimeException("Le nombre de carte n'est pas valide");
		for (int i = 0; i < HAND_LIMIT; i++) {

			this.cards.add(cards.get(i));
		}
		Card mini = MINICARD;
		for (int i = 0; i < HAND_LIMIT; i++) 	
			if (mini.compareWith(this.cards.get(i)) <= 0)
				mini = this.cards.get(i);
		maxCard = mini;
	}

	int compareto(Hand hand) {
		return this.maxCard.compareWith(hand.maxCard);
	}

	/*
	 * Only use for test
	 */
	ArrayList<Card> getCard() {
		return cards;
	}

	void printHand() {
		System.out.print("Le Main: ");
		for (int i = 0; i < HAND_LIMIT; i++)
			System.out.print(cards.get(i) + " ");
	}

}
