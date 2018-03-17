package poker;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * @author Groupe A
 * @date 2018-3-10
 */
public class HandTest {

	Hand hand = new Hand();
	Card cTWO_CLUB = new Card(Rank.TWO,Suit.CLUB);
	Card cFIVE_CLUB = new Card(Rank.FIVE,Suit.CLUB);
	Card cFOUR_CLUB = new Card(Rank.FOUR,Suit.CLUB);
	Card cJACK_CLUB = new Card(Rank.JACK,Suit.CLUB);
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Test
	public void test1WrongDraw3() throws RuntimeException{
		ArrayList<Card> fourCards = new ArrayList<Card>();
		fourCards.add(cTWO_CLUB);
		fourCards.add(cFIVE_CLUB);
		fourCards.add(cFOUR_CLUB);
		fourCards.add(cFIVE_CLUB);
	    Throwable t = null;
	    try{
			hand.drawCard(fourCards);
	    }catch(Exception ex){
	        t = ex;
	    }
	        
	    assertNotNull(t);
	    assertTrue(t instanceof RuntimeException);
	    assertTrue(t.getMessage().contains("The number of the cards is not valid"));

	}

	@Test
	public void test1WrongDraw1() throws RuntimeException{
		ArrayList<Card> sixCards = new ArrayList<Card>();
		sixCards.add(cTWO_CLUB);
		sixCards.add(cTWO_CLUB);
		sixCards.add(cTWO_CLUB);
		sixCards.add(cTWO_CLUB);
		sixCards.add(cTWO_CLUB);
		sixCards.add(cFIVE_CLUB);
	    Throwable t = null;
	    try{
			hand.drawCard(sixCards);
	    }catch(Exception ex){
	        t = ex;
	    }        
	    assertNotNull(t);
	    assertTrue(t instanceof RuntimeException);
	    assertTrue(t.getMessage().contains("The number of the cards is not valid"));
	}

	@Test
	public void test1WrongDraw2() throws RuntimeException {
		ArrayList<Card> noCard = new ArrayList<Card>();
		Throwable t = null;
	    try{
			hand.drawCard(noCard);
	    }catch(Exception ex){
	        t = ex;
	    }        
	    assertNotNull(t);
	    assertTrue(t instanceof RuntimeException);
	    assertTrue(t.getMessage().contains("The number of the cards is not valid"));
	}

	@Test
	public void test1RightDraw() {
		System.setOut(new PrintStream(outContent));
		ArrayList<Card> c2C_5C_JC_JC_2C = new ArrayList<Card>();
		String expected = "HAND: 2C 5C JC JC 2C ";
		c2C_5C_JC_JC_2C.add(cTWO_CLUB);
		c2C_5C_JC_JC_2C.add(cFIVE_CLUB);
		c2C_5C_JC_JC_2C.add(cJACK_CLUB);
		c2C_5C_JC_JC_2C.add(cJACK_CLUB);
		c2C_5C_JC_JC_2C.add(cTWO_CLUB);
		hand.drawCard(c2C_5C_JC_JC_2C);
		assertEquals(c2C_5C_JC_JC_2C.get(0), hand.getCard().get(0));
		assertEquals(c2C_5C_JC_JC_2C.get(1), hand.getCard().get(1));
		assertEquals(c2C_5C_JC_JC_2C.get(2), hand.getCard().get(2));
		hand.printHand();
		assertEquals(expected, outContent.toString());
	}

	@Test
	public void testCompareto() {
		ArrayList<Card> c5C_5C_4C_JC_JC = new ArrayList<Card>();
		c5C_5C_4C_JC_JC.add(cFIVE_CLUB);
		c5C_5C_4C_JC_JC.add(cFIVE_CLUB);
		c5C_5C_4C_JC_JC.add(cFOUR_CLUB);
		c5C_5C_4C_JC_JC.add(cJACK_CLUB);
		c5C_5C_4C_JC_JC.add(cJACK_CLUB);
		hand.drawCard(c5C_5C_4C_JC_JC);
		assertEquals(cJACK_CLUB, hand.maxCard);

		ArrayList<Card> c2C_4C_5C_5C_2C = new ArrayList<Card>();// encore une fois
		c2C_4C_5C_5C_2C.add(cTWO_CLUB);
		c2C_4C_5C_5C_2C.add(cFOUR_CLUB);
		c2C_4C_5C_5C_2C.add(cFIVE_CLUB);
		c2C_4C_5C_5C_2C.add(cFIVE_CLUB);
		c2C_4C_5C_5C_2C.add(cTWO_CLUB);
		hand.drawCard(c2C_4C_5C_5C_2C);
		assertEquals(cFIVE_CLUB, hand.maxCard);

	}

}
