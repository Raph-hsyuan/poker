package poker;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HandTest {

    Hand hand = new Hand();
    @Test
    public void testGetCard() {
        Card r2Card = new Card(Rank.TWO);
        hand.drawCard(r2Card);
        assertEquals(Rank.TWO, hand.getCard());
    }

}
