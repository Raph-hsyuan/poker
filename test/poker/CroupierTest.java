package poker;

import static org.junit.jupiter.api.Assertions.*;
import static poker.Suit.*;

import java.util.ArrayList;

import static poker.Rank.*;
import org.junit.jupiter.api.Test;
/**
 * @author Groupe A
 * @date 2018-3-11
 */
class CroupierTest {
//	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	Croupier croupier=new Croupier();
	@Test
	void testToRank() {
		assertEquals(ACE,croupier.toRank("A"));
		assertEquals(EIGHT,croupier.toRank("8"));
		assertEquals(FIVE,croupier.toRank("5"));
	}
	
	@Test
	void testToSuit() {
		assertEquals(TREFLE,croupier.toSuit("Tr"));
		assertEquals(PIQUE,croupier.toSuit("Pi"));
		assertEquals(COEUR,croupier.toSuit("Co"));
	}
	
	@Test
	void testToCard() {
		ArrayList<Card> cKPi_APi_2Tr= new ArrayList<>();
		cKPi_APi_2Tr.add(new Card(ROI,PIQUE));
		cKPi_APi_2Tr.add(new Card(ACE,PIQUE));
		cKPi_APi_2Tr.add(new Card(TWO,TREFLE));
		String[] nKPi_APi_2Tr = { "RPi", "APi", "2Tr" };
		for(int i=0;i<3;i++) {
		assertEquals(cKPi_APi_2Tr.get(i).getRank(),croupier.toCards(nKPi_APi_2Tr).get(i).getRank());
		assertEquals(cKPi_APi_2Tr.get(i).getSuit(),croupier.toCards(nKPi_APi_2Tr).get(i).getSuit());
		}
	}

}
