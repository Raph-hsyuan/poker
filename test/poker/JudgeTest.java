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
	Card card5 = new Card(Rank.FIVE);
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
		
		testHand2.add(card2);
		testHand2.add(card4);
		testHand2.add(card5);
		
		testHand3.add(card5);
		testHand3.add(card5);
		testHand3.add(card5);
		
		testHand4.add(card5);
		testHand4.add(card5);
		testHand4.add(card2);
	}

	@AfterEach
	void clearHands() {
		testHand1.clear();
		testHand2.clear();
		testHand3.clear();
	}

	@Test
	void testPaireD() {
		assertEquals(101, testJudge.paireDetector(testHand1));
		assertEquals(0, testJudge.paireDetector(testHand2));
		assertEquals(104, testJudge.paireDetector(testHand3));
	}

	@Test
	void brelanPaireD() {
		assertEquals(301, testJudge.brelanDetector(testHand1));
		assertEquals(0, testJudge.brelanDetector(testHand2));
		assertEquals(304, testJudge.brelanDetector(testHand3));
		assertEquals(0, testJudge.brelanDetector(testHand4));
	}

}
