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
	Card cTWO_TREFLE = new Card(Rank.TWO,Suit.TREFLE);
	Card cFIVE_TREFLE = new Card(Rank.FIVE,Suit.TREFLE);
	Card cFOUR_TREFLE = new Card(Rank.FOUR,Suit.TREFLE);
	Card cVALET_TREFLE = new Card(Rank.VALET,Suit.TREFLE);
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Test
	public void test1WrongDraw3() throws RuntimeException{
		ArrayList<Card> fourCards = new ArrayList<Card>();
		fourCards.add(cTWO_TREFLE);
		fourCards.add(cFIVE_TREFLE);
		fourCards.add(cFOUR_TREFLE);
		fourCards.add(cFIVE_TREFLE);
	    Throwable t = null;
	    try{
			hand.drawCard(fourCards);
	    }catch(Exception ex){
	        t = ex;
	    }
	        
	    assertNotNull(t);
	    assertTrue(t instanceof RuntimeException);
	    assertTrue(t.getMessage().contains("Le nombre de carte n'est pas valide"));

	}

	@Test
	public void test1WrongDraw1() throws RuntimeException{
		ArrayList<Card> sixCards = new ArrayList<Card>();
		sixCards.add(cTWO_TREFLE);
		sixCards.add(cTWO_TREFLE);
		sixCards.add(cTWO_TREFLE);
		sixCards.add(cTWO_TREFLE);
		sixCards.add(cTWO_TREFLE);
		sixCards.add(cFIVE_TREFLE);
	    Throwable t = null;
	    try{
			hand.drawCard(sixCards);
	    }catch(Exception ex){
	        t = ex;
	    }        
	    assertNotNull(t);
	    assertTrue(t instanceof RuntimeException);
	    assertTrue(t.getMessage().contains("Le nombre de carte n'est pas valide"));
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
	    assertTrue(t.getMessage().contains("Le nombre de carte n'est pas valide"));
	}

	@Test
	public void test1RightDraw() {
		System.setOut(new PrintStream(outContent));
		ArrayList<Card> c2Tr_5Tr_VTr_VTr_2Tr = new ArrayList<Card>();
		String expected = "Le Main: 2Tr 5Tr VTr VTr 2Tr ";
		c2Tr_5Tr_VTr_VTr_2Tr.add(cTWO_TREFLE);
		c2Tr_5Tr_VTr_VTr_2Tr.add(cFIVE_TREFLE);
		c2Tr_5Tr_VTr_VTr_2Tr.add(cVALET_TREFLE);
		c2Tr_5Tr_VTr_VTr_2Tr.add(cVALET_TREFLE);
		c2Tr_5Tr_VTr_VTr_2Tr.add(cTWO_TREFLE);
		hand.drawCard(c2Tr_5Tr_VTr_VTr_2Tr);
		assertEquals(c2Tr_5Tr_VTr_VTr_2Tr.get(0), hand.getCard().get(0));
		assertEquals(c2Tr_5Tr_VTr_VTr_2Tr.get(1), hand.getCard().get(1));
		assertEquals(c2Tr_5Tr_VTr_VTr_2Tr.get(2), hand.getCard().get(2));
		hand.printHand();
		assertEquals(expected, outContent.toString());
	}

	@Test
	public void testCompareto() {
		ArrayList<Card> c5Tr_5Tr_4Tr_VTr_VTr = new ArrayList<Card>();
		c5Tr_5Tr_4Tr_VTr_VTr.add(cFIVE_TREFLE);
		c5Tr_5Tr_4Tr_VTr_VTr.add(cFIVE_TREFLE);
		c5Tr_5Tr_4Tr_VTr_VTr.add(cFOUR_TREFLE);
		c5Tr_5Tr_4Tr_VTr_VTr.add(cVALET_TREFLE);
		c5Tr_5Tr_4Tr_VTr_VTr.add(cVALET_TREFLE);
		hand.drawCard(c5Tr_5Tr_4Tr_VTr_VTr);
		assertEquals(cVALET_TREFLE, hand.maxCard);

		ArrayList<Card> c2Tr_4Tr_5Tr_5Tr_2Tr = new ArrayList<Card>();// encore une fois
		c2Tr_4Tr_5Tr_5Tr_2Tr.add(cTWO_TREFLE);
		c2Tr_4Tr_5Tr_5Tr_2Tr.add(cFOUR_TREFLE);
		c2Tr_4Tr_5Tr_5Tr_2Tr.add(cFIVE_TREFLE);
		c2Tr_4Tr_5Tr_5Tr_2Tr.add(cFIVE_TREFLE);
		c2Tr_4Tr_5Tr_5Tr_2Tr.add(cTWO_TREFLE);
		hand.drawCard(c2Tr_4Tr_5Tr_5Tr_2Tr);
		assertEquals(cFIVE_TREFLE, hand.maxCard);

	}

}
