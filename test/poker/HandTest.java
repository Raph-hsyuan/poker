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
	Card card11 = new Card(Rank.JACK);    
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	// @Ignore
	// @Test
	// public void testGetCard() {
	// Card r2Card = new Card(Rank.TWO);
	// hand.drawCard(r2Card);
	// assertEquals(Rank.TWO, hand.getCard().getRank());
	// }

	@Test(expected = java.lang.RuntimeException.class)
	public void test1WrongDraw3() {//测试只能加三张牌
		List<Card> deck3 = new ArrayList<Card>();
		deck3.add(card2);
		deck3.add(card5);
		deck3.add(card4);
		deck3.add(card11);
		hand.drawCard(deck3);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void test1WrongDraw1() {
		List<Card> deck1 = new ArrayList<Card>();
		deck1.add(card2);
		hand.drawCard(deck1);
	}
	
	@Test(expected = java.lang.RuntimeException.class)
    public void test1WrongDraw2() {
        List<Card> deck2 = new ArrayList<Card>();
        deck2.add(card2);
        deck2.add(card5);
        hand.drawCard(deck2);
    }

	@Test
	public void test1RightDraw() {
		System.setOut(new PrintStream(outContent));
		List<Card> deck3 = new ArrayList<Card>();
		String expected = "HAND:  2   5   11";
		deck3.add(card2);
		deck3.add(card5);
		deck3.add(card11);
		hand.drawCard(deck3);
		assertEquals(deck3.get(0), hand.getCard().get(0));
		assertEquals(deck3.get(1), hand.getCard().get(1));
		assertEquals(deck3.get(2), hand.getCard().get(2));
		hand.printHand();
		assertEquals(expected, outContent.toString());
	}

	@Test
	public void testCompareto() {
		List<Card> deckTest1 = new ArrayList<Card>();
		deckTest1.add(card5);
		deckTest1.add(card4);
		deckTest1.add(card11);
		hand.drawCard(deckTest1);
		assertEquals(card11, hand.maxCard);

		List<Card> deckTest2 = new ArrayList<Card>();// encore une fois
		deckTest2.add(card2);
		deckTest2.add(card4);
		deckTest2.add(card5);
		hand.drawCard(deckTest2);
		assertEquals(card5, hand.maxCard);

	}

}
