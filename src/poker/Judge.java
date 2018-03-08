package poker;

import java.util.ArrayList;

/**
 * @author Groupe A
 * @date 2018-3-8
 */
class Judge {

	/**
	 * Point of different Hand Patterns
	 */
	public static final int PAIREPOINT = 1000000;
	public static final int BRELANPOINT = 2000000;
	public static final int PAIRE2POINT = 3000000;
	public static final int CARREPOINT = 4000000;
	/**
	 * Base of the value of card JJJKA: Point =
	 * BRELANPOINT+SBASEVALUE*J.shortValue()+K.longValue()+A.longValue();
	 */
	public static final int SBASEVALUE = 10000; // base for short value
	public static final int LBASEVALUE = 100; // base for long value
	int scoreHand1 = 0;
	int scoreHand2 = 0;

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
					if (count == 2&&paire1!=paire) {
						if(paire1 == 0) paire1=paire;
						else paire2=paire;
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
					count ++;
					int paire = compare.shortValue();
					if (count == 4) {
						carre = paire;
						point = CARREPOINT + carre*SBASEVALUE;
					}
				}
			}
		}
		return point;
	}
}
