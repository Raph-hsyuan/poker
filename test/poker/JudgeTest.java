package poker;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Groupe A
 * @date 2018-3-8
 */

class JudgeTest {
	Judge testJudge = new Judge();
	Hand hand = new Hand();
	Card card2 = new Card(Rank.TWO);
	Card cardJ = new Card(Rank.JACK);
	Card card4 = new Card(Rank.FOUR);
	ArrayList<Card> testHand1 = new ArrayList<>();
	ArrayList<Card> testHand2 = new ArrayList<>();
	ArrayList<Card> testHand3 = new ArrayList<>();
	ArrayList<Card> testHand4 = new ArrayList<>();
	@BeforeEach
	void intialHands() {
		testHand1.add(card2);
		testHand1.add(card2);
		testHand1.add(card2);
		testHand1.add(cardJ);
		
		testHand2.add(card2);
		testHand2.add(card4);
		testHand2.add(cardJ);
		testHand2.add(card4);
		
		testHand3.add(cardJ);
		testHand3.add(cardJ);
		testHand3.add(cardJ);
		testHand3.add(card4);
		
		testHand4.add(cardJ);
		testHand4.add(cardJ);
		testHand4.add(card2);
		testHand4.add(card4);
	}

	@AfterEach
	void clearHands() {
		testHand1.clear();
		testHand2.clear();
		testHand3.clear();
	}

	@Test
	void testPaireD() {
		assertEquals(1040513, testJudge.paireDetector(testHand2));
		assertEquals(1110005, testJudge.paireDetector(testHand4));
	}

	@Test
	void brelanPaireD() {
		assertEquals(2020512, testJudge.brelanDetector(testHand1));
		assertEquals(0, testJudge.brelanDetector(testHand2));
		assertEquals(2110004, testJudge.brelanDetector(testHand3));
		assertEquals(0, testJudge.brelanDetector(testHand4));
	}

}
