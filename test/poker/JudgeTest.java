package poker;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Groupe A
 * @date 2018-3-9
 */

class JudgeTest {
	Judge testJudge = new Judge();
	Hand hand = new Hand();
	Card card2 = new Card(Rank.TWO);
	Card card3 = new Card(Rank.THREE);
	Card card4 = new Card(Rank.FOUR);
	Card card5 = new Card(Rank.FIVE);
	Card card6 = new Card(Rank.SIX);
	Card card7 = new Card(Rank.SEVEN);
	Card cardA = new Card(Rank.ACE);
	Card cardJ = new Card(Rank.JACK);
	ArrayList<Card> testHand1 = new ArrayList<>();
	ArrayList<Card> testHand2 = new ArrayList<>();
	ArrayList<Card> testHand3 = new ArrayList<>();
	ArrayList<Card> testHand4 = new ArrayList<>();
	ArrayList<Card> testHand5 = new ArrayList<>();
	ArrayList<Card> testHand6 = new ArrayList<>();
	ArrayList<Card> testHand7 = new ArrayList<>();
	ArrayList<Card> testHand8 = new ArrayList<>();

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
	}

	@AfterEach
	void clearHands() {
		testHand1.clear();
		testHand2.clear();
		testHand3.clear();
	}

	@Test
	void testJudger() {
		Hand hand = new Hand();
		hand.drawCard(testHand1);
		assertEquals(3024608, testJudge.judger(hand));
		hand.drawCard(testHand2);
		assertEquals(3040513, testJudge.judger(hand));
		hand.drawCard(testHand3);
		assertEquals(4110004, testJudge.judger(hand));
		hand.drawCard(testHand4);
		assertEquals(1114101, testJudge.judger(hand));
		hand.drawCard(testHand5);
		assertEquals(2051304, testJudge.judger(hand));
		hand.drawCard(testHand6);
		assertEquals(4110001, testJudge.judger(hand));
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
		assertEquals(4110004, testJudge.carreDetector(testHand3));
		assertEquals(0, testJudge.carreDetector(testHand5));
		assertEquals(4110001, testJudge.carreDetector(testHand6));
	}

	@Test
	void testSuiteD() {
		assertEquals(0, testJudge.suiteDetector(testHand5));
		assertEquals(0, testJudge.suiteDetector(testHand6));
		assertEquals(5000006, testJudge.suiteDetector(testHand7));
		assertEquals(5000007, testJudge.suiteDetector(testHand8));

	}

}
