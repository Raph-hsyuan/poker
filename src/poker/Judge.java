package poker;

import java.util.ArrayList;
import java.util.List;

class Judge {
	ArrayList<Card> handCard1 = new ArrayList<Card>();
	ArrayList<Card> handCard2 = new ArrayList<Card>();
	public static final int PAIREPOINT = 100;
	

	Judge(ArrayList<Card> handCard1, ArrayList<Card> handCard2) {
		this.handCard1=(ArrayList<Card>) handCard1.clone();
		this.handCard2=(ArrayList<Card>) handCard2.clone();
	}

	int paire(ArrayList<Card> cards) {
		ArrayList<Card> store = new ArrayList<Card>();
		int maxpaire = 0, point =0;
		for (Card card: cards) {
			for (Card compare: store) {
				if(compare.compareWith(card) == 0) {
					int paire = compare.getRank().getValue();
					if (paire >= maxpaire) maxpaire = paire;
					point = PAIREPOINT + maxpaire;
				}
			}
			store.add(card);
		}
		return point;
	}
	
	int brelan(ArrayList<Card> cards) {
		ArrayList<Card> store = new ArrayList<Card>();
		for (Card card: cards) {
			
		}
		return 0;
	}

}
