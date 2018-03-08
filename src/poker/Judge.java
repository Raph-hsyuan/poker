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
	public static final int BRELANPOINT = 3000000;
	
	/**
	 * Base of the value of card
	 * JJJKA: Point = BRELANPOINT+BASEVALUE*J.ordinal()+K.shortValue()+A.longValue();
	 */
	public static final int BASEVALUE = 10000;

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
					if (paire >= maxpaire && count > 1) {
						maxpaire = paire;
						point = PAIREPOINT + maxpaire*BASEVALUE;
					}
				}
			}
		}
		if(point==0)return point;
		/**
		 * Every point of Hand with pair will also note other cards'
		 * longvalues, it needs to campare the rest of card by decending 
		 * order, thats why we use binary weight.
		 */
		for(Card find : cards) 
			if(find.shortValue()!=maxpaire) 
				point+=find.longValue();
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
					if (count > 2) {
						brelan = paire;
						point = BRELANPOINT + brelan*BASEVALUE;
					}
				}
			}
		}
		if(point==0)return point;
		for(Card find : cards) 
			if(find.shortValue()!=brelan) 
				point+=find.longValue();
		return point;
	}

}
