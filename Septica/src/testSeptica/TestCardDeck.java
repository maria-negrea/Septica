package testSeptica;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import septica.Card;
import septica.CardDeck;
import septica.Player;

public class TestCardDeck {

	private CardDeck deck;
	
	@Before
	public void setUpBefore() throws Exception {
		deck = new CardDeck();
	}

	@Test
	public void testSize() {
		int number = deck.size();
		assertEquals(number, 32);
	}

	@Test
	public void testShuffle() {
		deck.shuffle();
		CardDeck cd = new CardDeck();
		List<Card> l1 = deck.cards();
		List<Card> l2 = cd.cards();
		int count = 0;
		for (Card c1 : l1)
			for (Card c2 : l2) 
				if (c1.getSymbol() == c2.getSymbol() 
				&& c1.getValue() == c2.getValue()) {
					count++;
					break;
				}
		assertEquals(count, 32);
	}

	@Test
	public void testDeal() {
		Player p = new Player(0);
		deck.deal(p);
		deck.deal(p);
		deck.deal(p);
		int number = deck.size();
		assertEquals(number, 29);
	}

	@Test
	public void testCut() {
		Player p = new Player(0);
		for (int i = 0; i < 7; i ++)
			deck.deal(p);
		int count = deck.cut(new Player(1));
		assertEquals(count, 1);
	}

}
