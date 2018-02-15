package poker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CardTest {

	@Test
	void createAndTest() {

		Card r5Card = new Card(Rank.FIVE);
		assertEquals(Rank.FIVE, r5Card.getRank());
		assertTrue(r5Card.toString().equals(" 5 "));

	}
}
