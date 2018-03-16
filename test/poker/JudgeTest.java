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
		assertTrue(testJudge.paireDetector(c9C_9D_KD_QS_JH) == testJudge.paireDetector(c9H_9S_KC_QD_JC));
		assertTrue(testJudge.paireDetector(c9C_9D_10H_5H_4S) < testJudge.paireDetector(c9H_9S_10C_8H_4D));
		assertTrue(testJudge.paireDetector(c8C_8D_KD_QS_3H) < testJudge.paireDetector(cJH_JS_KS_QH_3D));
		
		
		

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
		ArrayList<Card> c3H_3D_3S_AD_AC = new ArrayList<>();
			c3H_3D_3S_AD_AC = toCardList
					(THREE,HEART,THREE,DIAMOND,THREE,SPADE,ACE,DIAMOND,ACE,CLUB);
		ArrayList<Card> c4D_4S_4C_5D_5C = new ArrayList<>();
			c4D_4S_4C_5D_5C = toCardList
					(FOUR,DIAMOND,FOUR,CLUB,FOUR,CLUB,FIVE,DIAMOND,FIVE,CLUB);
		ArrayList<Card> c7H_7D_7S_KD_KH = new ArrayList<>();
			c7H_7D_7S_KD_KH = toCardList
					(SEVEN,HEART,SEVEN,DIAMOND,SEVEN,SPADE,KING,DIAMOND,KING,HEART);
		ArrayList<Card> cQH_QD_QS_KS_KC = new ArrayList<>();
			cQH_QD_QS_KS_KC = toCardList
					(QUEEN,HEART,QUEEN,DIAMOND,QUEEN,SPADE,KING,SPADE,KING,CLUB);
		assertTrue(testJudge.fullDetector(c3H_3D_3S_AD_AC) < testJudge.fullDetector(c4D_4S_4C_5D_5C));
		assertTrue(testJudge.fullDetector(c7H_7D_7S_KD_KH) < testJudge.fullDetector(cQH_QD_QS_KS_KC));
	 }
	
	 @Test
	 void testColorD() {
        ArrayList<Card> cAC_10C_9C_7C_3C = new ArrayList<>();
			cAC_10C_9C_7C_3C = toCardList
					(ACE,CLUB,TEN,CLUB,NINE,CLUB,SEVEN,CLUB,THREE,CLUB);
		ArrayList<Card> cAD_10D_9D_7D_3D = new ArrayList<>();
			cAD_10D_9D_7D_3D = toCardList
					(ACE,DIAMOND,TEN,DIAMOND,NINE,DIAMOND,SEVEN,DIAMOND,THREE,DIAMOND);
		ArrayList<Card> cQC_JC_7C_4C_3C = new ArrayList<>();
			cQC_JC_7C_4C_3C = toCardList
					(QUEEN,CLUB,JACK,CLUB,SEVEN,CLUB,FOUR,CLUB,THREE,CLUB);
		ArrayList<Card> cQD_10D_7D_4D_3D = new ArrayList<>();
			cQD_10D_7D_4D_3D = toCardList
					(QUEEN,DIAMOND,TEN,DIAMOND,SEVEN,DIAMOND,FOUR,DIAMOND,THREE,DIAMOND);
		ArrayList<Card> cAS_9S_8S_4S_3S = new ArrayList<>();
			cAS_9S_8S_4S_3S = toCardList
					(ACE,SPADE,NINE,SPADE,EIGHT,SPADE,FOUR,SPADE,THREE,SPADE);
		ArrayList<Card> cKH_JH_10H_7H_6H = new ArrayList<>();
			cKH_JH_10H_7H_6H = toCardList
					(KING,HEART,JACK,HEART,TEN,HEART,SEVEN,HEART,SIX,HEART);
		assertTrue(testJudge.colorDetector(cAC_10C_9C_7C_3C) == testJudge.colorDetector(cAD_10D_9D_7D_3D));
		assertTrue(testJudge.colorDetector(cQC_JC_7C_4C_3C) > testJudge.colorDetector(cQD_10D_7D_4D_3D));
		assertTrue(testJudge.colorDetector(cAS_9S_8S_4S_3S) > testJudge.colorDetector(cKH_JH_10H_7H_6H));
	 }
	
	 @Test
	 void testqfD() {

	 }
	
}
