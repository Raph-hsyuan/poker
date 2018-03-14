package poker;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Groupe A
 * @date 2018-3-9
 */

class JudgeTest {
	Judge testJudge = new Judge();
	Hand hand = new Hand();
	Card card2 = new Card(Rank.TWO,Suit.CLUB);
	Card card3 = new Card(Rank.THREE,Suit.CLUB);
	Card card4 = new Card(Rank.FOUR,Suit.CLUB);
	Card card5 = new Card(Rank.FIVE,Suit.CLUB);
	Card card6 = new Card(Rank.SIX,Suit.CLUB);
	Card card7 = new Card(Rank.SEVEN,Suit.CLUB);
	Card cardA = new Card(Rank.ACE,Suit.DIAMOND);
	Card cardJ = new Card(Rank.JACK,Suit.HEART);
	Card card2C = new Card(Rank.TWO,Suit.CLUB);
	Card card3C = new Card(Rank.THREE,Suit.CLUB);
	Card card4C = new Card(Rank.FOUR,Suit.CLUB);
	Card card5C = new Card(Rank.FIVE,Suit.CLUB);
	Card card6C = new Card(Rank.SIX,Suit.CLUB);
	Card card7C = new Card(Rank.SEVEN,Suit.CLUB);
	ArrayList<Card> testHand1 = new ArrayList<>();
	ArrayList<Card> testHand2 = new ArrayList<>();
	ArrayList<Card> testHand3 = new ArrayList<>();
	ArrayList<Card> testHand4 = new ArrayList<>();
	ArrayList<Card> testHand5 = new ArrayList<>();
	ArrayList<Card> testHand6 = new ArrayList<>();
	ArrayList<Card> testHand7 = new ArrayList<>();
	ArrayList<Card> testHand8 = new ArrayList<>();
	ArrayList<Card> testHand9 = new ArrayList<>();
	ArrayList<Card> testHand10 = new ArrayList<>();
	ArrayList<Card> testHand11 = new ArrayList<>();
	ArrayList<Card> testHand12 = new ArrayList<>();
	@BeforeEach
	void intialHands() {
		testHand1.add(card2);
		testHand1.add(card2);
		testHand1.add(card2);
		testHand1.add(cardJ);
		testHand1.add(cardA);

		testHand2.add(card2);
		testHand2.add(card4);
		testHand2.add(cardJ);
		testHand2.add(card4);
		testHand2.add(card4);

		testHand3.add(cardJ);
		testHand3.add(cardJ);
		testHand3.add(cardJ);
		testHand3.add(card4);
		testHand3.add(cardJ);

		testHand4.add(cardJ);
		testHand4.add(cardJ);
		testHand4.add(cardA);
		testHand4.add(card4);
		testHand4.add(card2);

		testHand5.add(cardJ);
		testHand5.add(cardJ);
		testHand5.add(card4);
		testHand5.add(card2);
		testHand5.add(card2);

		testHand6.add(cardJ);
		testHand6.add(cardJ);
		testHand6.add(cardJ);
		testHand6.add(cardJ);
		testHand6.add(card2);

		testHand7.add(card4);
		testHand7.add(card5);
		testHand7.add(card3);
		testHand7.add(card6);
		testHand7.add(card2);

		testHand8.add(card7);
		testHand8.add(card6);
		testHand8.add(card5);
		testHand8.add(card4);
		testHand8.add(card3);
		
		testHand9.add(card7);
        testHand9.add(card7);
        testHand9.add(card7);
        testHand9.add(card4);
        testHand9.add(card4);
        
        testHand10.add(cardJ);
        testHand10.add(cardJ);
        testHand10.add(cardJ);
        testHand10.add(card5);
        testHand10.add(card5);
        
        testHand11.add(card2C);
        testHand11.add(card3C);
        testHand11.add(card4C);
        testHand11.add(card5C);
        testHand11.add(card7C);
        
        testHand12.add(card2C);
        testHand12.add(card3C);
        testHand12.add(card4C);
        testHand12.add(card5C);
        testHand12.add(card6C);
	}


	@Test
	void testJudger() {
		Hand hand = new Hand();
		hand.drawCard(testHand1);
		assertEquals(3024608, testJudge.toPoint(hand));
		hand.drawCard(testHand2);
		assertEquals(3040513, testJudge.toPoint(hand));
		hand.drawCard(testHand3);
		assertEquals(7110004, testJudge.toPoint(hand));
		hand.drawCard(testHand4);
		assertEquals(1114101, testJudge.toPoint(hand));
		hand.drawCard(testHand5);
		assertEquals(2051304, testJudge.toPoint(hand));
		hand.drawCard(testHand6);
		assertEquals(7110001, testJudge.toPoint(hand));
	}

	@Test
	void testPaireD() {
		assertEquals(1040513, testJudge.paireDetector(testHand2));
		assertEquals(1114101, testJudge.paireDetector(testHand4));
	}

	@Test
	void testBrelanPaireD() {
		assertEquals(3024608, testJudge.brelanDetector(testHand1));
		assertEquals(3040513, testJudge.brelanDetector(testHand2));
		assertEquals(3110004, testJudge.brelanDetector(testHand3));
		assertEquals(0, testJudge.brelanDetector(testHand4));
	}

	@Test
	void paire2D() {
		assertEquals(0, testJudge.paire2Detector(testHand1));
		assertEquals(0, testJudge.paire2Detector(testHand2));
		assertEquals(0, testJudge.paire2Detector(testHand3));
		assertEquals(0, testJudge.paire2Detector(testHand4));
		assertEquals(2051304, testJudge.paire2Detector(testHand5));
	}

	@Test
	void testCarreD() {
		assertEquals(0, testJudge.carreDetector(testHand1));
		assertEquals(0, testJudge.carreDetector(testHand2));
		assertEquals(7110004, testJudge.carreDetector(testHand3));
		assertEquals(0, testJudge.carreDetector(testHand5));
		assertEquals(7110001, testJudge.carreDetector(testHand6));
	}

	@Test
	void testSuiteD() {
		assertEquals(0, testJudge.suiteDetector(testHand5));
		assertEquals(0, testJudge.suiteDetector(testHand6));
		assertEquals(4000006, testJudge.suiteDetector(testHand7));
		assertEquals(4000007, testJudge.suiteDetector(testHand8));
	}
	
	@Test
	void testfullD(){
	    assertEquals(0, testJudge.fullDetector(testHand3));
	    assertEquals(0, testJudge.fullDetector(testHand2));
	    assertEquals(6110005, testJudge.fullDetector(testHand10));
	    assertEquals(6070004, testJudge.fullDetector(testHand9));
	}
}
