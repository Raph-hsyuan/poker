package poker;

import static org.junit.jupiter.api.Assertions.*;

//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;

import org.junit.jupiter.api.Test;
/**
 * @author Groupe A
 * @date 2018-3-11
 */
class CroupierTest {
//	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	Croupier test=new Croupier();
	@Test
	void testToRank() {
		assertEquals(Rank.ACE,test.toRank("A"));
		assertEquals(Rank.EIGHT,test.toRank("8"));
		assertEquals(Rank.FIVE,test.toRank("5"));
	}
	
	@Test
	void testToSuit() {
		assertEquals(Suit.CLUB,test.toSuit("C"));
		assertEquals(Suit.SPADE,test.toSuit("S"));
		assertEquals(Suit.HEART,test.toSuit("H"));
	}
	
	
//	/**
//	 * With the help of StackOverFlow:
//	 * https://stackoverflow.com/questions/1647907/
//	 * junit-how-to-simulate-system-in-testing
//	 */
//	@Test
//	void testStart(){
//		System.setOut(new PrintStream(outContent));
//		String data="2H 3D 5S 9C KD\n2C 3H 4S 8C AH\n";
//		System.setIn(new ByteArrayInputStream(data.getBytes()));
//		test.startGame();
//		assertEquals("???????????",outContent.toString());
//	}

}
