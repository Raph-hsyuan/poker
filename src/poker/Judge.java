package poker;

import java.util.*;

/**
 * @author Groupe A
 * @date 2018-3-9
 */
class Judge {

	/**
	 * Point of different Hand Patterns
	 */
	public static final int PAIREPOINT = 1000000;
	public static final int PAIRE2POINT = 2000000;
	public static final int BRELANPOINT = 3000000;
	public static final int CARREPOINT = 4000000;
	public static final int SUITEPOINT = 5000000;
	public static final int FULLPOINT = 6000000;

	/**
	 * Base of the value of card JJJKA: Point =
	 * BRELANPOINT+SBASEVALUE*J.shortValue()+K.longValue()+A.longValue();
	 */
	public static final int SBASEVALUE = 10000; // base for short value
	public static final int LBASEVALUE = 100; // base for long value

	int scoreOfHand = 0;

	/**
	 * @param hand
	 * @return the highest score
	 */
	int judger(Hand hand) {
		scoreOfHand = carreDetector(hand.cards);
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
		return hand.maxCard.shortValue();
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
		return SUITEPOINT + max;
	}
	
	int fullDetector(ArrayList<Card> cards) {
		HashMap<Integer,Integer> counter = new HashMap<>();
		for (Card find : cards) {
			int shortValue = find.shortValue();
			if(!counter.containsKey(shortValue))
				counter.put(shortValue, 1);
			else {
				int count = counter.get(shortValue);
				counter.put(shortValue, count+1);
			}
		}
		if (counter.size() == 2) {
			int point2=0;
			int point3=0;
			for(HashMap.Entry<Integer,Integer> find : counter.entrySet()) {
				if(find.getValue()==2) point2=find.getKey();
				if(find.getValue()==3) point3=find.getKey()*SBASEVALUE;
			}
			return point2*point3==0? 0:FULLPOINT+point2+point3;	
		}
		return 0;
	}
}
