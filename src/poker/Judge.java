package poker;

import java.util.*;

/**
 * @author Groupe A
 * @date 2018-3-17
 * A class who has methods to detect all kind of hand type
 */
class Judge {

	/**
	 * Point of different Hand Patterns
	 */
	public static final int PAIREPOINT = 1000000;// yes
	public static final int PAIRE2POINT = 2000000;// yes
	public static final int BRELANPOINT = 3000000;// yes
	public static final int SUITEPOINT = 4000000;// yes
	public static final int COULEURPOINT = 5000000;// yes
	public static final int FULLPOINT = 6000000;// yes
	public static final int CARREPOINT = 7000000;// yes
	public static final int QFPOINT = 4000000;// yes

	/**
	 * Base of the value of card JJJKA: Point =
	 * BRELANPOINT+SBASEVALUE*J.shortValue()+K.longValue()+A.longValue();
	 */
	public static final int SBASEVALUE = 10000; // base for short value
	public static final int LBASEVALUE = 100; // base for long value

	int scoreOfHand = 0;
	String result;

	/**
	 * @param hand
	 * @return the highest score
	 */

	String judger(Hand hand1, Hand hand2) {
		int point1 = this.toPoint(hand1);
		String result1 = "La main 1 gagne avec " + result;
		int point2 = this.toPoint(hand2);
		String result2 = "La main 2 gagne avec " + result;
		if (point1 == point2)
			return "Egalite";
		return point1 > point2 ? result1 : result2;
	}

	int toPoint(Hand hand) {
		scoreOfHand = qfDetector(hand.cards);
		if (scoreOfHand != 0)
			return scoreOfHand;
		scoreOfHand = carreDetector(hand.cards);
		if (scoreOfHand != 0)
			return scoreOfHand;
		scoreOfHand = fullDetector(hand.cards);
		if (scoreOfHand != 0)
			return scoreOfHand;
		scoreOfHand = colorDetector(hand.cards);
		if (scoreOfHand != 0)
			return scoreOfHand;
		scoreOfHand = suiteDetector(hand.cards);
		if (scoreOfHand != 0)
			return scoreOfHand;
		scoreOfHand = brelanDetector(hand.cards);
		if (scoreOfHand != 0)
			return scoreOfHand;
		scoreOfHand = paire2Detector(hand.cards);
		if (scoreOfHand != 0)
			return scoreOfHand;
		scoreOfHand = paireDetector(hand.cards);
		if (scoreOfHand != 0)
			return scoreOfHand;
		result = "High Card : " + hand.maxCard;
		int point = 0;
		for (Card find : hand.cards)
			point += find.longValue();
		return point;
	}

	int paireDetector(ArrayList<Card> cards) {
		int maxpaire = 0;
		int point = 0;
		for (Card card : cards) {
			int count = 0;
			for (Card compare : cards) {
				if (compare.compareWith(card) == 0) {
					count++;
					int paire = compare.shortValue();
					if (paire >= maxpaire && count == 2) {
						maxpaire = paire;
						point = PAIREPOINT + maxpaire * SBASEVALUE;
					}
				}
			}
		}
		if (point == 0)
			return point;
		/**
		 * Every point of Hand with pair will also note other cards' longvalues, it
		 * needs to campare the rest of card by decending order, thats why we use binary
		 * weight.
		 */
		for (Card find : cards)
			if (find.shortValue() != maxpaire)
				point += find.longValue();
			else
				result = "paire de " + find.getRank();
		return point;
	}

	int brelanDetector(ArrayList<Card> cards) {
		int brelan = 0;
		int point = 0;
		for (Card card : cards) {
			int count = 0;
			for (Card compare : cards) {
				if (compare.compareWith(card) == 0) {
					count++;
					int paire = compare.shortValue();
					if (count == 3) {
						brelan = paire;
						point = BRELANPOINT + brelan * SBASEVALUE;
					}
				}
			}
		}
		if (point == 0)
			return point;
		for (Card find : cards)
			if (find.shortValue() != brelan)
				point += find.longValue();
			else
				result = "brelan de " + find.getRank();
		return point;
	}

	int paire2Detector(ArrayList<Card> cards) {
		int paire1 = 0;
		int paire2 = 0;
		int point = 0;
		for (Card card : cards) {
			int count = 0;
			for (Card compare : cards) {
				if (compare.compareWith(card) == 0) {
					count++;
					int paire = compare.longValue();
					if (count == 2 && paire1 != paire) {
						if (paire1 == 0)
							paire1 = paire;
						else
							paire2 = paire;
					}
				}
			}
			if (paire1 != 0 && paire2 != 0)
				point = PAIRE2POINT + (paire1 + paire2) * LBASEVALUE;
		}
		if (point == 0)
			return point;
		for (Card find : cards)
			if (find.longValue() != paire1 && find.longValue() != paire2)
				point += find.shortValue();
		Rank[] myrank = Rank.values();
		result = "deux Paire : " + myrank[(int) (Math.log(paire1) / Math.log(2))] + " et "
				+ myrank[(int) (Math.log(paire2) / Math.log(2))];
		return point;
	}

	int carreDetector(ArrayList<Card> cards) {
		int carre = 0;
		int point = 0;
		for (Card card : cards) {
			int count = 0;
			for (Card compare : cards) {
				if (compare.compareWith(card) == 0) {
					count++;
					int paire = compare.shortValue();
					if (count == 4) {
						carre = paire;
						point = CARREPOINT + carre * SBASEVALUE;
					}
				}
			}
		}
		if (point == 0)
			return point;
		for (Card find : cards)
			if (find.shortValue() != carre)
				point += find.longValue();
			else
				result = "carre de " + find.getRank();
		return point;
	}

	int suiteDetector(ArrayList<Card> cards) {
		for (int i = 0; i < cards.size() - 1; i++) {
			for (int j = 0; j < cards.size() - 1 - i; j++) {
				if (cards.get(j).compareWith(cards.get(j + 1)) > 0) {
					Collections.swap(cards, j, j + 1);
				}
			}
		}
		for (int i = 0; i < cards.size() - 1; i++) {
			if (cards.get(i + 1).shortValue() - cards.get(i).shortValue() != 1)
				return 0;
		}
		int max = cards.get(cards.size() - 1).shortValue();
		result = "suit de " + cards.get(cards.size() - 1).getRank();
		return SUITEPOINT + max;
	}

	int fullDetector(ArrayList<Card> cards) {
		HashMap<Integer, Integer> counter = new HashMap<>();
		for (Card find : cards) {
			int shortValue = find.shortValue();
			if (!counter.containsKey(shortValue))
				counter.put(shortValue, 1);
			else {
				int count = counter.get(shortValue);
				counter.put(shortValue, count + 1);
			}
		}
		if (counter.size() == 2) {
			int point2 = 0;
			int point3 = 0;
			for (HashMap.Entry<Integer, Integer> find : counter.entrySet()) {
				if (find.getValue() == 2)
					point2 = find.getKey();
				if (find.getValue() == 3)
					point3 = find.getKey() * SBASEVALUE;
			}
			Rank[] myrank = Rank.values();
			if (point2 * point3 != 0) {
				result = "full : " + myrank[point3 / SBASEVALUE - 2] + " sur " + myrank[point2 - 2];
				return FULLPOINT + point2 + point3;
			}
		}
		return 0;
	}

	int colorDetector(ArrayList<Card> cards) {
		Suit suit = cards.get(0).getSuit();
		int point = 0;
		for (Card card : cards) {
			if (!suit.equals(card.getSuit()))
				return 0;
			point += card.longValue();
		}
		result = "Couleur";
		return point + COULEURPOINT;
	}

	int qfDetector(ArrayList<Card> cards) {
		if (colorDetector(cards) * suiteDetector(cards) == 0)
			return 0;
		Card max = Hand.MINICARD;
		for (Card find : cards) {
			if (find.compareWith(max) > 0)
				max = find;
		}

		int point = QFPOINT + suiteDetector(cards);
		result = "Quinte Flush de " + max.getRank();
		return point;
	}

}
