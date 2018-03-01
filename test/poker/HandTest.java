package poker;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class HandTest {

	Hand hand = new Hand();
	Card card2 = new Card(Rank.TWO);
	Card card5 = new Card(Rank.FIVE);
	Card card4 = new Card(Rank.FOUR);
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	// @Ignore
	// @Test
	// public void testGetCard() {
	// Card r2Card = new Card(Rank.TWO);
	// hand.drawCard(r2Card);
	// assertEquals(Rank.TWO, hand.getCard().getRank());
	// }

	@Test(expected = java.lang.RuntimeException.class)
	public void test1WrongDraw3() {
		List<Card> deck3 = new ArrayList<Card>();
		deck3.add(card2);
		deck3.add(card5);
		deck3.add(card4);
		hand.drawCard(deck3);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void test1WrongDraw1() {
		List<Card> deck1 = new ArrayList<Card>();
		deck1.add(card2);
		hand.drawCard(deck1);
	}

	@Test
	public void test1RightDraw() {
		System.setOut(new PrintStream(outContent));
		List<Card> deck2 = new ArrayList<Card>();
		String expected = "HAND:  2   5  ";
		deck2.add(card2);
		deck2.add(card5);
		hand.drawCard(deck2);
		assertEquals(deck2.get(0), hand.getCard().get(0));
		assertEquals(deck2.get(1), hand.getCard().get(1));
		hand.printHand();
		assertEquals(expected, outContent.toString());
	}

	@Test
	public void testCompareto() {
		List<Card> deck3 = new ArrayList<Card>();
		deck3.add(card5);
		deck3.add(card4);
		hand.drawCard(deck3);
		assertEquals(card5, hand.maxCard);

		List<Card> deck4 = new ArrayList<Card>();// encore une fois
		deck4.add(card2);
		deck4.add(card4);
		hand.drawCard(deck4);
		assertEquals(card4, hand.maxCard);

	}

}