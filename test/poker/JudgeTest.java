package poker;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * @author Groupe A
 * @date 2018-3-6
 */
class JudgeTest {
	Hand hand = new Hand();
	Card card2 = new Card(Rank.TWO);
	Card card5 = new Card(Rank.FIVE);
	Card card4 = new Card(Rank.FOUR);
	ArrayList<Card> testHand1 = new ArrayList<>();
	ArrayList<Card> testHand2 = new ArrayList<>();
	ArrayList<Card> testHand3 = new ArrayList<>();

	@Test
	void testPaireD() {
		Judge testJudge = new Judge();
		testHand1.add(card2);
		testHand1.add(card2);
		testHand1.add(card2);
		testHand2.add(card2);
		testHand2.add(card4);
		testHand2.add(card5);
		testHand3.add(card5);
		testHand3.add(card5);
		testHand3.add(card5);
		assertEquals(101, testJudge.paireDetector(testHand1));
		assertEquals(0, testJudge.paireDetector(testHand2));
		assertEquals(104, testJudge.paireDetector(testHand3));
	}

}
