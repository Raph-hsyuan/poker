package poker;

class Hand {
	Card card;

	void drawCard(Card card) {
		this.card = card;
	}

	Card getCard() {
		return card;
	}
}
