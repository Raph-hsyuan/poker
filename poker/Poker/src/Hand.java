package poker;

public class Hand {
	Card card;
	boolean addCard(Card card){
		if(this.card.equals(null)){
			this.card=card;
			return true;
		}else {
			return false;
		}
	}
}
