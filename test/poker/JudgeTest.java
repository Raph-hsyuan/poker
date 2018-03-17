package poker;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static poker.Rank.*;
import static poker.Suit.*;

/**
 * @author Groupe A
 * @date 2018-3-17
 */

class JudgeTest {
	Judge testJudge = new Judge();
	Hand hand = new Hand();
	static HashMap<Suit, HashMap<Rank, Card>> myCards = new HashMap<>();

	Card getCard(Rank rank, Suit suit) {
		return myCards.get(suit).get(rank);
	}

	ArrayList<Card> toCardList(Rank rank1, Suit suit1, Rank rank2, Suit suit2, Rank rank3, Suit suit3, Rank rank4,
			Suit suit4, Rank rank5, Suit suit5) {

		ArrayList<Card> mylist = new ArrayList<>();
		mylist.add(new Card(rank1, suit1));
		mylist.add(new Card(rank2, suit2));
		mylist.add(new Card(rank3, suit3));
		mylist.add(new Card(rank4, suit4));
		mylist.add(new Card(rank5, suit5));
		return mylist;

	}

	/**
	 * Build All Cards
	 */
	@BeforeAll
	static void initialCard() {
		for (Suit suit : Suit.values())
			for (Rank rank : Rank.values()) {
				HashMap<Rank, Card> keyRank = new HashMap<>();
				keyRank.put(rank, new Card(rank, suit));
				myCards.put(suit, keyRank);
			}

	}

	@Test
	void testPaireD() {
		ArrayList<Card> c9Tr_9Ca_RCa_DPi_VCo = new ArrayList<>();
		c9Tr_9Ca_RCa_DPi_VCo = toCardList(NINE, TREFLE, NINE, CARREAU, ROI, CARREAU, DAME, PIQUE, VALET, COEUR);
		ArrayList<Card> c9Co_9Pi_RTr_DCa_VTr = new ArrayList<>();
		c9Co_9Pi_RTr_DCa_VTr = toCardList(NINE, COEUR, NINE, PIQUE, ROI, TREFLE, DAME, CARREAU, VALET, TREFLE);
		ArrayList<Card> c9Tr_9Ca_10Co_5Co_4Pi = new ArrayList<>();
		c9Tr_9Ca_10Co_5Co_4Pi = toCardList(NINE, TREFLE, NINE, CARREAU, TEN, COEUR, FIVE, COEUR, FOUR, PIQUE);
		ArrayList<Card> c9Co_9Pi_10Tr_8Co_4Ca = new ArrayList<>();
		c9Co_9Pi_10Tr_8Co_4Ca = toCardList(NINE, COEUR, NINE, PIQUE, TEN, TREFLE, EIGHT, COEUR, FOUR, CARREAU);
		ArrayList<Card> c8Tr_8Ca_RCa_DPi_3Co = new ArrayList<>();
		c8Tr_8Ca_RCa_DPi_3Co = toCardList(EIGHT, TREFLE, EIGHT, CARREAU, ROI, CARREAU, DAME, PIQUE, THREE, COEUR);
		ArrayList<Card> cVCo_VPi_RPi_DCo_3Ca = new ArrayList<>();
		cVCo_VPi_RPi_DCo_3Ca = toCardList(VALET, COEUR, VALET, PIQUE, ROI, PIQUE, DAME, COEUR, THREE, CARREAU);

		assertTrue(testJudge.paireDetector(c9Tr_9Ca_RCa_DPi_VCo) == testJudge.paireDetector(c9Co_9Pi_RTr_DCa_VTr));
		assertTrue(testJudge.paireDetector(c9Tr_9Ca_10Co_5Co_4Pi) < testJudge.paireDetector(c9Co_9Pi_10Tr_8Co_4Ca));
		assertTrue(testJudge.paireDetector(c8Tr_8Ca_RCa_DPi_3Co) < testJudge.paireDetector(cVCo_VPi_RPi_DCo_3Ca));
	}

	@Test
	void testBrelanD() {
		ArrayList<Card> c2Co_2Tr_2Ca_ACo_RCa = new ArrayList<>();
		c2Co_2Tr_2Ca_ACo_RCa = toCardList(TWO, COEUR, TWO, TREFLE, TWO, CARREAU, ACE, COEUR, ROI, CARREAU);
		ArrayList<Card> c3Tr_3Co_3Pi_ACa_RTr = new ArrayList<>();
		c3Tr_3Co_3Pi_ACa_RTr = toCardList(THREE, TREFLE, THREE, COEUR, THREE, PIQUE, ACE, CARREAU, ROI, TREFLE);
		ArrayList<Card> cRTr_RCa_RCo_3Tr_8Ca = new ArrayList<>();
		cRTr_RCa_RCo_3Tr_8Ca = toCardList(ROI, TREFLE, ROI, CARREAU, ROI, COEUR, THREE, TREFLE, EIGHT, CARREAU);
		ArrayList<Card> cVCa_VTr_VPi_ATr_2Co = new ArrayList<>();
		cVCa_VTr_VPi_ATr_2Co = toCardList(VALET, CARREAU, VALET, TREFLE, VALET, PIQUE, ACE, TREFLE, TWO, COEUR);

		assertTrue(testJudge.brelanDetector(c2Co_2Tr_2Ca_ACo_RCa) < testJudge.brelanDetector(c3Tr_3Co_3Pi_ACa_RTr));
		assertTrue(testJudge.brelanDetector(cRTr_RCa_RCo_3Tr_8Ca) > testJudge.brelanDetector(cVCa_VTr_VPi_ATr_2Co));
	}

	@Test
	void testPaire2D() {
		ArrayList<Card> cAPi_ACa_RCo_RTr_DTr = new ArrayList<>();
		cAPi_ACa_RCo_RTr_DTr = toCardList(ACE, PIQUE, ACE, CARREAU, ROI, COEUR, ROI, TREFLE, DAME, TREFLE);
		ArrayList<Card> cACo_ATr_RPi_RCa_DCa = new ArrayList<>();
		cACo_ATr_RPi_RCa_DCa = toCardList(ACE, COEUR, ACE, TREFLE, ROI, PIQUE, ROI, CARREAU, DAME, CARREAU);
		ArrayList<Card> cAPi_ACa_RCo_RTr_10Co = new ArrayList<>();
		cAPi_ACa_RCo_RTr_10Co = toCardList(ACE, PIQUE, ACE, CARREAU, ROI, COEUR, ROI, TREFLE, TEN, COEUR);
		ArrayList<Card> cACo_ATr_RPi_RCa_9Co = new ArrayList<>();
		cACo_ATr_RPi_RCa_9Co = toCardList(ACE, COEUR, ACE, TREFLE, ROI, PIQUE, ROI, CARREAU, NINE, COEUR);
		ArrayList<Card> c10Pi_10Ca_7Co_7Tr_3Co = new ArrayList<>();
		c10Pi_10Ca_7Co_7Tr_3Co = toCardList(TEN, PIQUE, TEN, CARREAU, SEVEN, COEUR, SEVEN, TREFLE, THREE, COEUR);
		ArrayList<Card> c10Co_10Tr_8Ca_8Pi_3Ca = new ArrayList<>();
		c10Co_10Tr_8Ca_8Pi_3Ca = toCardList(TEN, COEUR, TEN, TREFLE, EIGHT, CARREAU, EIGHT, PIQUE, THREE, CARREAU);
		ArrayList<Card> c6Pi_6Ca_2Co_2Tr_ATr = new ArrayList<>();
		c6Pi_6Ca_2Co_2Tr_ATr = toCardList(SIX, PIQUE, SIX, CARREAU, TWO, COEUR, TWO, TREFLE, ACE, TREFLE);
		ArrayList<Card> c5Tr_5Ca_4Tr_4Co_ACo = new ArrayList<>();
		c5Tr_5Ca_4Tr_4Co_ACo = toCardList(FIVE, TREFLE, FIVE, CARREAU, FOUR, TREFLE, FOUR, COEUR, ACE, COEUR);

		assertTrue(testJudge.paire2Detector(cAPi_ACa_RCo_RTr_DTr) == testJudge.paire2Detector(cACo_ATr_RPi_RCa_DCa));
		assertTrue(testJudge.paire2Detector(cAPi_ACa_RCo_RTr_10Co) > testJudge.paire2Detector(cACo_ATr_RPi_RCa_9Co));
		assertTrue(testJudge.paire2Detector(c10Pi_10Ca_7Co_7Tr_3Co) < testJudge.paire2Detector(c10Co_10Tr_8Ca_8Pi_3Ca));
		assertTrue(testJudge.paire2Detector(c6Pi_6Ca_2Co_2Tr_ATr) > testJudge.paire2Detector(c5Tr_5Ca_4Tr_4Co_ACo));
	}

	@Test
	void testCarreD() {
		ArrayList<Card> c8Tr_8Ca_8Co_8Pi_10Tr = new ArrayList<>();
		c8Tr_8Ca_8Co_8Pi_10Tr = toCardList(EIGHT, TREFLE, EIGHT, CARREAU, EIGHT, COEUR, EIGHT, PIQUE, TEN, TREFLE);
		ArrayList<Card> c7Tr_7Ca_7Co_7Pi_10Ca = new ArrayList<>();
		c7Tr_7Ca_7Co_7Pi_10Ca = toCardList(SEVEN, TREFLE, SEVEN, CARREAU, SEVEN, COEUR, SEVEN, PIQUE, TEN, CARREAU);
		ArrayList<Card> cATr_ACa_ACo_APi_3Tr = new ArrayList<>();
		cATr_ACa_ACo_APi_3Tr = toCardList(ACE, TREFLE, ACE, CARREAU, ACE, COEUR, ACE, PIQUE, THREE, TREFLE);
		ArrayList<Card> c2Tr_2Ca_2Co_2Pi_RTr = new ArrayList<>();
		c2Tr_2Ca_2Co_2Pi_RTr = toCardList(TWO, TREFLE, TWO, CARREAU, TWO, COEUR, TWO, PIQUE, ROI, TREFLE);

		assertTrue(testJudge.carreDetector(c8Tr_8Ca_8Co_8Pi_10Tr) > testJudge.carreDetector(c7Tr_7Ca_7Co_7Pi_10Ca));
		assertTrue(testJudge.carreDetector(cATr_ACa_ACo_APi_3Tr) > testJudge.carreDetector(c2Tr_2Ca_2Co_2Pi_RTr));
	}

	@Test
	void testSuiteD() {
		ArrayList<Card> cAPi_RCa_DTr_VTr_10Pi = new ArrayList<>();
		cAPi_RCa_DTr_VTr_10Pi = toCardList(ACE, PIQUE, ROI, CARREAU, DAME, TREFLE, VALET, TREFLE, TEN, PIQUE);
		ArrayList<Card> cATr_RCo_DCa_VPi_10Tr = new ArrayList<>();
		cATr_RCo_DCa_VPi_10Tr = toCardList(ACE, TREFLE, ROI, COEUR, DAME, CARREAU, VALET, PIQUE, TEN, TREFLE);
		ArrayList<Card> c8Tr_7Ca_6Pi_5Ca_4Tr = new ArrayList<>();
		c8Tr_7Ca_6Pi_5Ca_4Tr = toCardList(EIGHT, TREFLE, SEVEN, CARREAU, SIX, PIQUE, FIVE, CARREAU, FOUR, TREFLE);
		ArrayList<Card> cQCa_JPi_10Tr_9Tr_8Co = new ArrayList<>();
		cQCa_JPi_10Tr_9Tr_8Co = toCardList(DAME, CARREAU, VALET, PIQUE, TEN, TREFLE, NINE, TREFLE, EIGHT, COEUR);

		assertTrue(testJudge.suiteDetector(cAPi_RCa_DTr_VTr_10Pi) == testJudge.suiteDetector(cATr_RCo_DCa_VPi_10Tr));
		assertTrue(testJudge.suiteDetector(c8Tr_7Ca_6Pi_5Ca_4Tr) < testJudge.suiteDetector(cQCa_JPi_10Tr_9Tr_8Co));
	}

	@Test
	void testfullD() {
		ArrayList<Card> c3Co_3Ca_3Pi_ACa_ATr = new ArrayList<>();
		c3Co_3Ca_3Pi_ACa_ATr = toCardList(THREE, COEUR, THREE, CARREAU, THREE, PIQUE, ACE, CARREAU, ACE, TREFLE);
		ArrayList<Card> c4Ca_4Tr_4Tr_5Ca_5Tr = new ArrayList<>();
		c4Ca_4Tr_4Tr_5Ca_5Tr = toCardList(FOUR, CARREAU, FOUR, TREFLE, FOUR, TREFLE, FIVE, CARREAU, FIVE, TREFLE);
		ArrayList<Card> c7Co_7Ca_7Pi_RCa_RCo = new ArrayList<>();
		c7Co_7Ca_7Pi_RCa_RCo = toCardList(SEVEN, COEUR, SEVEN, CARREAU, SEVEN, PIQUE, ROI, CARREAU, ROI, COEUR);
		ArrayList<Card> cDCo_DCa_DPi_RPi_RTr = new ArrayList<>();
		cDCo_DCa_DPi_RPi_RTr = toCardList(DAME, COEUR, DAME, CARREAU, DAME, PIQUE, ROI, PIQUE, ROI, TREFLE);

		assertTrue(testJudge.fullDetector(c3Co_3Ca_3Pi_ACa_ATr) < testJudge.fullDetector(c4Ca_4Tr_4Tr_5Ca_5Tr));
		assertTrue(testJudge.fullDetector(c7Co_7Ca_7Pi_RCa_RCo) < testJudge.fullDetector(cDCo_DCa_DPi_RPi_RTr));
	}

	@Test
	void testColorD() {
		ArrayList<Card> cATr_10Tr_9Tr_7Tr_3Tr = new ArrayList<>();
		cATr_10Tr_9Tr_7Tr_3Tr = toCardList(ACE, TREFLE, TEN, TREFLE, NINE, TREFLE, SEVEN, TREFLE, THREE, TREFLE);
		ArrayList<Card> cACa_10Ca_9Ca_7Ca_3Ca = new ArrayList<>();
		cACa_10Ca_9Ca_7Ca_3Ca = toCardList(ACE, CARREAU, TEN, CARREAU, NINE, CARREAU, SEVEN, CARREAU, THREE, CARREAU);
		ArrayList<Card> cDTr_VTr_7Tr_4Tr_3Tr = new ArrayList<>();
		cDTr_VTr_7Tr_4Tr_3Tr = toCardList(DAME, TREFLE, VALET, TREFLE, SEVEN, TREFLE, FOUR, TREFLE, THREE, TREFLE);
		ArrayList<Card> cDCa_10Ca_7Ca_4Ca_3Ca = new ArrayList<>();
		cDCa_10Ca_7Ca_4Ca_3Ca = toCardList(DAME, CARREAU, TEN, CARREAU, SEVEN, CARREAU, FOUR, CARREAU, THREE, CARREAU);
		ArrayList<Card> cAPi_9Pi_8Pi_4Pi_3Pi = new ArrayList<>();
		cAPi_9Pi_8Pi_4Pi_3Pi = toCardList(ACE, PIQUE, NINE, PIQUE, EIGHT, PIQUE, FOUR, PIQUE, THREE, PIQUE);
		ArrayList<Card> cRCo_VCo_10Co_7Co_6Co = new ArrayList<>();
		cRCo_VCo_10Co_7Co_6Co = toCardList(ROI, COEUR, VALET, COEUR, TEN, COEUR, SEVEN, COEUR, SIX, COEUR);

		assertTrue(testJudge.colorDetector(cATr_10Tr_9Tr_7Tr_3Tr) == testJudge.colorDetector(cACa_10Ca_9Ca_7Ca_3Ca));
		assertTrue(testJudge.colorDetector(cDTr_VTr_7Tr_4Tr_3Tr) > testJudge.colorDetector(cDCa_10Ca_7Ca_4Ca_3Ca));
		assertTrue(testJudge.colorDetector(cAPi_9Pi_8Pi_4Pi_3Pi) > testJudge.colorDetector(cRCo_VCo_10Co_7Co_6Co));
	}

	@Test
	void testqfD() {
		ArrayList<Card> cRTr_DTr_VTr_10Tr_9Tr = new ArrayList<>();
		cRTr_DTr_VTr_10Tr_9Tr = toCardList(ROI, TREFLE, DAME, TREFLE, VALET, TREFLE, TEN, TREFLE, NINE, TREFLE);
		ArrayList<Card> cRPi_DPi_VPi_10Pi_9Pi = new ArrayList<>();
		cRPi_DPi_VPi_10Pi_9Pi = toCardList(ROI, PIQUE, DAME, PIQUE, VALET, PIQUE, TEN, PIQUE, NINE, PIQUE);
		ArrayList<Card> c10Tr_9Tr_8Tr_7Tr_6Tr = new ArrayList<>();
		c10Tr_9Tr_8Tr_7Tr_6Tr = toCardList(TEN, TREFLE, NINE, TREFLE, EIGHT, TREFLE, SEVEN, TREFLE, SIX, TREFLE);
		ArrayList<Card> c8Co_7Co_6Co_5Co_4Co = new ArrayList<>();
		c8Co_7Co_6Co_5Co_4Co = toCardList(EIGHT, COEUR, SEVEN, COEUR, SIX, COEUR, FIVE, COEUR, FOUR, COEUR);
		ArrayList<Card> c6Co_5Co_4Co_3Co_2Co = new ArrayList<>();
		c6Co_5Co_4Co_3Co_2Co = toCardList(SIX, COEUR, FIVE, COEUR, FOUR, COEUR, THREE, COEUR, TWO, COEUR);
		ArrayList<Card> cACa_RCa_DCa_VCa_10Ca = new ArrayList<>();
		cACa_RCa_DCa_VCa_10Ca = toCardList(ACE, CARREAU, ROI, CARREAU, DAME, CARREAU, VALET, CARREAU, TEN, CARREAU);

		assertTrue(testJudge.qfDetector(cRTr_DTr_VTr_10Tr_9Tr) == testJudge.qfDetector(cRPi_DPi_VPi_10Pi_9Pi));
		assertTrue(testJudge.qfDetector(c10Tr_9Tr_8Tr_7Tr_6Tr) > testJudge.qfDetector(c8Co_7Co_6Co_5Co_4Co));
		assertTrue(testJudge.qfDetector(c6Co_5Co_4Co_3Co_2Co) < testJudge.qfDetector(cACa_RCa_DCa_VCa_10Ca));
	}

	/**
	 * Integrative Test
	 */
	@Test
	void testJudger() {
		ArrayList<Card> cATr_DCa_8Pi_7Pi_3Ca = new ArrayList<>();
		cATr_DCa_8Pi_7Pi_3Ca = toCardList(ACE, TREFLE, DAME, CARREAU, EIGHT, PIQUE, SEVEN, PIQUE, THREE, CARREAU);
		ArrayList<Card> cACa_DPi_8Ca_7Tr_3Co = new ArrayList<>();
		cACa_DPi_8Ca_7Tr_3Co = toCardList(ACE, CARREAU, DAME, PIQUE, EIGHT, CARREAU, SEVEN, TREFLE, THREE, COEUR);
		ArrayList<Card> cRPi_DCo_10Ca_5Co_2Pi = new ArrayList<>();
		cRPi_DCo_10Ca_5Co_2Pi = toCardList(ROI, PIQUE, DAME, COEUR, TEN, CARREAU, FIVE, COEUR, TWO, PIQUE);
		ArrayList<Card> cRCa_DTr_VCo_9Ca_7Co = new ArrayList<>();
		cRCa_DTr_VCo_9Ca_7Co = toCardList(ROI, CARREAU, DAME, TREFLE, VALET, COEUR, NINE, CARREAU, SEVEN, COEUR);
		ArrayList<Card> c9Tr_9Ca_RCa_DPi_VCo = new ArrayList<>();
		c9Tr_9Ca_RCa_DPi_VCo = toCardList(NINE, TREFLE, NINE, CARREAU, ROI, CARREAU, DAME, PIQUE, VALET, COEUR);
		ArrayList<Card> c2Co_2Tr_2Ca_ACo_RCa = new ArrayList<>();
		c2Co_2Tr_2Ca_ACo_RCa = toCardList(TWO, COEUR, TWO, TREFLE, TWO, CARREAU, ACE, COEUR, ROI, CARREAU);
		ArrayList<Card> cAPi_ACa_RCo_RTr_DTr = new ArrayList<>();
		cAPi_ACa_RCo_RTr_DTr = toCardList(ACE, PIQUE, ACE, CARREAU, ROI, COEUR, ROI, TREFLE, DAME, TREFLE);
		ArrayList<Card> c8Tr_7Ca_6Pi_5Ca_4Tr = new ArrayList<>();
		c8Tr_7Ca_6Pi_5Ca_4Tr = toCardList(EIGHT, TREFLE, SEVEN, CARREAU, SIX, PIQUE, FIVE, CARREAU, FOUR, TREFLE);
		ArrayList<Card> cATr_10Tr_9Tr_7Tr_3Tr = new ArrayList<>();
		cATr_10Tr_9Tr_7Tr_3Tr = toCardList(ACE, TREFLE, TEN, TREFLE, NINE, TREFLE, SEVEN, TREFLE, THREE, TREFLE);
		ArrayList<Card> c3Co_3Ca_3Pi_ACa_ATr = new ArrayList<>();
		c3Co_3Ca_3Pi_ACa_ATr = toCardList(THREE, COEUR, THREE, CARREAU, THREE, PIQUE, ACE, CARREAU, ACE, TREFLE);
		ArrayList<Card> c8Tr_8Ca_8Co_8Pi_10Tr = new ArrayList<>();
		c8Tr_8Ca_8Co_8Pi_10Tr = toCardList(EIGHT, TREFLE, EIGHT, CARREAU, EIGHT, COEUR, EIGHT, PIQUE, TEN, TREFLE);
		ArrayList<Card> c6Co_5Co_4Co_3Co_2Co = new ArrayList<>();
		c6Co_5Co_4Co_3Co_2Co = toCardList(SIX, COEUR, FIVE, COEUR, FOUR, COEUR, THREE, COEUR, TWO, COEUR);

		Hand hATr_DCa_8Pi_7Pi_3Ca = new Hand();
		Hand hACa_DPi_8Ca_7Tr_3Co = new Hand();
		Hand hRPi_DCo_10Ca_5Co_2Pi = new Hand();
		Hand hRCa_DTr_VCo_9Ca_7Co = new Hand();
		Hand h9Tr_9Ca_RCa_DPi_VCo = new Hand();
		Hand h2Co_2Tr_2Ca_ACo_RCa = new Hand();
		Hand hAPi_ACa_RCo_RTr_DTr = new Hand();
		Hand h8Tr_7Ca_6Pi_5Ca_4Tr = new Hand();
		Hand hATr_10Tr_9Tr_7Tr_3Tr = new Hand();
		Hand h3Co_3Ca_3Pi_ACa_ATr = new Hand();
		Hand h8Tr_8Ca_8Co_8Pi_10Tr = new Hand();
		Hand h6Co_5Co_4Co_3Co_2Co = new Hand();

		hATr_DCa_8Pi_7Pi_3Ca.drawCard(cATr_DCa_8Pi_7Pi_3Ca);// same1
		hACa_DPi_8Ca_7Tr_3Co.drawCard(cACa_DPi_8Ca_7Tr_3Co);// same2
		hRPi_DCo_10Ca_5Co_2Pi.drawCard(cRPi_DCo_10Ca_5Co_2Pi);// high card
		hRCa_DTr_VCo_9Ca_7Co.drawCard(cRCa_DTr_VCo_9Ca_7Co);// high card
		h9Tr_9Ca_RCa_DPi_VCo.drawCard(c9Tr_9Ca_RCa_DPi_VCo);// 1 pair
		h2Co_2Tr_2Ca_ACo_RCa.drawCard(c2Co_2Tr_2Ca_ACo_RCa);// brelan
		hAPi_ACa_RCo_RTr_DTr.drawCard(cAPi_ACa_RCo_RTr_DTr);// 2 pair
		h8Tr_7Ca_6Pi_5Ca_4Tr.drawCard(c8Tr_7Ca_6Pi_5Ca_4Tr);// suit8
		hATr_10Tr_9Tr_7Tr_3Tr.drawCard(cATr_10Tr_9Tr_7Tr_3Tr);// couleur
		h3Co_3Ca_3Pi_ACa_ATr.drawCard(c3Co_3Ca_3Pi_ACa_ATr);// full
		h8Tr_8Ca_8Co_8Pi_10Tr.drawCard(c8Tr_8Ca_8Co_8Pi_10Tr);// Carre
		h6Co_5Co_4Co_3Co_2Co.drawCard(c6Co_5Co_4Co_3Co_2Co);// QF

		assertEquals("Egalite", testJudge.judger(hATr_DCa_8Pi_7Pi_3Ca, hACa_DPi_8Ca_7Tr_3Co));// tie
		assertEquals("La main 2 gagne avec High Card : RCa", testJudge.judger(hRPi_DCo_10Ca_5Co_2Pi, hRCa_DTr_VCo_9Ca_7Co));// High
		assertEquals("La main 2 gagne avec deux Paire : R et A", testJudge.judger(h9Tr_9Ca_RCa_DPi_VCo, hAPi_ACa_RCo_RTr_DTr));// 2Pair>Pair
		assertEquals("La main 2 gagne avec brelan de 2", testJudge.judger(hAPi_ACa_RCo_RTr_DTr, h2Co_2Tr_2Ca_ACo_RCa));// Brelan>2Pair
		assertEquals("La main 2 gagne avec suit de 8", testJudge.judger(hAPi_ACa_RCo_RTr_DTr, h8Tr_7Ca_6Pi_5Ca_4Tr));// Suit>Brelan
		assertEquals("La main 2 gagne avec Couleur", testJudge.judger(h8Tr_7Ca_6Pi_5Ca_4Tr, hATr_10Tr_9Tr_7Tr_3Tr));// Couleur>Suit
		assertEquals("La main 1 gagne avec full : 3 sur A", testJudge.judger(h3Co_3Ca_3Pi_ACa_ATr, hATr_10Tr_9Tr_7Tr_3Tr));// Carre>Full
		assertEquals("La main 2 gagne avec carre de 8", testJudge.judger(h3Co_3Ca_3Pi_ACa_ATr, h8Tr_8Ca_8Co_8Pi_10Tr));// Carre>Full
		assertEquals("La main 1 gagne avec Quinte Flush de 6", testJudge.judger(h6Co_5Co_4Co_3Co_2Co, h8Tr_8Ca_8Co_8Pi_10Tr));// QF>Carre
	}

}
