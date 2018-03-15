package poker;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static poker.Rank.*;
import static poker.Suit.*;
/**
 * @author Groupe A
 * @date 2018-3-14
 */

class JudgeTest {
	Judge testJudge = new Judge();
	Hand hand = new Hand();
	static HashMap<Suit, HashMap<Rank, Card>> myCards = new HashMap<>();
	Card getCard(Rank rank, Suit suit) {
		return myCards.get(suit).get(rank);
	}

	ArrayList<Card> toCardList(Rank rank1,Suit suit1,
							 Rank rank2,Suit suit2,
							 Rank rank3,Suit suit3,
							 Rank rank4,Suit suit4,
							 Rank rank5,Suit suit5) {
		
		ArrayList<Card> mylist = new ArrayList<>();
		mylist.add(new Card(rank1,suit1));
		mylist.add(new Card(rank2,suit2));
		mylist.add(new Card(rank3,suit3));
		mylist.add(new Card(rank4,suit4));
		mylist.add(new Card(rank5,suit5));
		return mylist;
		
	}
	
	@BeforeAll
	static void initialCard() {
		for (Suit suit : Suit.values())
			for (Rank rank : Rank.values()) {
				HashMap<Rank, Card> keyRank = new HashMap<>();
				keyRank.put(rank, new Card(rank, suit));
				myCards.put(suit, keyRank);
			}
		
	}

	
	 @Test
	 void testJudger() {

	 }
	
	 
	@Test
	void testPaireD() {
		ArrayList<Card> c9C_9D_KD_QS_JH = new ArrayList<>();
		c9C_9D_KD_QS_JH = toCardList
				(NINE,CLUB,NINE,DIAMOND,KING,DIAMOND,QUEEN,SPADE,JACK,HEART);
		ArrayList<Card> c9H_9S_KC_QD_JC = new ArrayList<>();
		c9H_9S_KC_QD_JC = toCardList
				(NINE,HEART,NINE,SPADE,KING,CLUB,QUEEN,DIAMOND,JACK,CLUB);
		ArrayList<Card> c9C_9D_10H_5H_4S = new ArrayList<>();
		c9C_9D_10H_5H_4S = toCardList
				(NINE,CLUB,NINE,DIAMOND,TEN,HEART,FIVE,HEART,FOUR,SPADE);
		ArrayList<Card> c9H_9S_10C_8H_4D = new ArrayList<>();
		c9H_9S_10C_8H_4D = toCardList
				(NINE,HEART,NINE,SPADE,TEN,CLUB,EIGHT,HEART,FOUR,DIAMOND);
		ArrayList<Card> c8C_8D_KD_QS_3H = new ArrayList<>();
		c8C_8D_KD_QS_3H = toCardList
				(EIGHT,CLUB,EIGHT,DIAMOND,KING,DIAMOND,QUEEN,SPADE,THREE,HEART);
		ArrayList<Card> cJH_JS_KS_QH_3D = new ArrayList<>();
		cJH_JS_KS_QH_3D = toCardList
				(JACK,HEART,JACK,SPADE,KING,SPADE,QUEEN,HEART,THREE,DIAMOND);
		assertTrue(testJudge.paireDetector(c9C_9D_KD_QS_JH)<testJudge.paireDetector(c9H_9S_KC_QD_JC));
		assertTrue(testJudge.paireDetector(c9C_9D_10H_5H_4S)<testJudge.paireDetector(c9H_9S_10C_8H_4D));
		assertTrue(testJudge.paireDetector(c8C_8D_KD_QS_3H)<testJudge.paireDetector(cJH_JS_KS_QH_3D));
		
		
		

	}
	
	 @Test
	 void testBrelanPaireD() {

	 }
	
	 @Test
	 void paire2D() {

	 }
	
	 @Test
	 void testCarreD() {

	 }
	
	 @Test
	 void testSuiteD() {

	 }
	
	 @Test
	 void testfullD() {

	 }
	
	 @Test
	 void testColorD() {

	 }
	
	 @Test
	 void testqfD() {

	 }
	
}
