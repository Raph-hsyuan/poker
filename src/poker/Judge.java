package poker;

import java.util.ArrayList;
/**
 * @author Groupe A
 * @date 2018-3-1
 */
class Judge {

	public static final int PAIREPOINT = 100;
	int scoreHand1=0;
	int scoreHand2=0;
	void toJudge(ArrayList<Card> handCard1, ArrayList<Card> handCard2) {
		scoreHand1=this.paireDetector(handCard1);
		scoreHand2=this.paireDetector(handCard2);
	}

	int paireDetector(ArrayList<Card> cards) {
		int maxpaire = 0;
		int point = 0;
		for (Card card : cards) {
			int count = 0;
			for (Card compare : cards) {
				if (compare.compareWith(card) == 0) {
					count++;
					int paire = compare.getRank().getValue();
					if (paire >= maxpaire && count>1) {
						maxpaire = paire;
						point = PAIREPOINT + maxpaire;
					}
				}
			}
		}
		return point;
	}

}
