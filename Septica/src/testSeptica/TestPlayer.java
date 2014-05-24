package testSeptica;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import septica.Card;
import septica.Player;

public class TestPlayer {

	private Player player;
	
	@Before
	public void setUpBefore() throws Exception {
		player = new Player(0);
	}

	@Test
	public void testAddToScore() {
		int score1 = player.getScore();
		player.addToScore(10);
		int score2 = player.getScore();
		assertEquals(score1 + 10, score2);
	}

	@Test
	public void testNumberOfCards() {
		int nr1 = player.numberOfCards();
		player.drawCard(new Card());
		player.drawCard(new Card());
		int nr2 = player.numberOfCards();
		assertEquals(nr1 + 2, nr2);
	}

	@Test
	public void testDrawCard() {
		Card card = new Card((char) 0, 8);
		player.drawCard(card);
		int nr = player.numberOfCards();
		Card c = player.getCard(0);
		assertEquals(nr, 1);
		assertEquals(card, c);
	}

	@Test
	public void testPlayCard() {
		player.drawCard(new Card((char) 0, 8));
		player.drawCard(new Card((char) 0, 10));
		player.drawCard(new Card((char) 0, 7));
		player.drawCard(new Card((char) 0, 11));
		player.playCard(new Card((char) 0, 7));
		int nr = player.numberOfCards();
		assertEquals(nr, 3);
	}

	@Test
	public void testFindCard() {
		player.drawCard(new Card((char) 0, 8));
		player.drawCard(new Card((char) 0, 10));
		player.drawCard(new Card((char) 0, 11));
		boolean ok = player.findCard(11);
		assertEquals(ok, true);
	}

}
