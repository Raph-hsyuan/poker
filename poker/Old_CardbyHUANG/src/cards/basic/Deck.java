package cards.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * A Deck which represents all 52 cards of a normal deck of cards.
 * @author HUANG Shenyuan
 * @version 2017.12.29
 */
class Deck {
	// A list named myCards to save all 52 cards.
	private final List<Card> myCards = new ArrayList<>();

	/**
	 *  *The cards in the deck are initially in order and saved
	 *  in a List named myCards.
	 */
	Deck() {
		for (Rank rank : Rank.values()) {
			for (Suit suit : Suit.values()) {
				myCards.add(new Card(suit, rank));
			}
		}
	}

	/**
	 * To put the cards into a random order.
	 */
	void shuffle() {
		Random rd = new Random();
		for (int i = 0; i < 52; i++) {
			int change = rd.nextInt(52);
			Collections.swap(myCards, i, change);
		}
	}

	/**
	 * Select the top card of the deck and that card is removed from the deck.
	 * @return topCard which is the selected card, and has been removed.
	 */
	Card draw() {
		Card topCard = myCards.get(0);
		myCards.remove(0);
		return topCard;
	}

	/**
	 * @return the number of the rest of Cards.
	 */
	int restCard() {
		return myCards.size();
	}

}
