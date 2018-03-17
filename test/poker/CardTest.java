package poker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Groupe A
 * @date 2018-2-19
 */
class CardTest {

	@Test
	void createAndTest() {

		Card c5Tr = new Card(Rank.FIVE,Suit.TREFLE);
		assertEquals(Rank.FIVE, c5Tr.getRank());
		assertTrue(c5Tr.toString().equals("5Tr"));
		Card r3Card = new Card(Rank.THREE,Suit.TREFLE);
		assertEquals(0, c5Tr.compareWith(c5Tr));
		assertTrue(c5Tr.compareWith(r3Card) > 0);

	}
}
