package testSeptica;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import septica.Game;
import septica.Player;

public class TestGame {

	private Game game;
	
	@Before
	public void setUpBefore() throws Exception {
		game = new Game();
		game.addPlayer(0);
		game.addPlayer(1);
		game.addPlayer(2);
	}

	@Test
	public void testAddPlayerInt() {
		game.addPlayer(4);
		Player p1 = game.getPlayerById(4);
		Player p2 = game.getPlayerByIndex(3);
		int nr = game.getNumberOfPlayers();
		assertEquals(p1, p2);
		assertEquals(nr, 4);
	}

	@Test
	public void testStartGame() {
		game.startGame();
		for (int i = 0; i < 3; i++) {
			int nr = game.getPlayerCards(i);
			assertEquals(nr, 4);
		}
		int number = game.getNumberOfCards();
		assertEquals(number, 20);
	}

	@Test
	public void testDealCards() {
		game.dealCards();
		int number = game.getNumberOfCards();
		assertEquals(number, 29);
	}

	@Test
	public void testPlayHand() {
		game.addPlayer(3);
		game.dealCards();
		String[] cards = new String[4];
		cards[0] = "14-T";
		cards[1] = "13-T";
		cards[2] = "12-T";
		cards[3] = "11-T";
		boolean ok = game.playHand(cards, false);
		assertEquals(ok, false);
	}

	@Test
	public void testCanContinue() {
		game.dealCards();
		Player p = game.getPlayerByIndex(0);
		boolean ok = game.canContinue(p, 14);
		assertEquals(ok, true);
	}

	@Test
	public void testWinHand() {
		game.addPlayer(3);
		game.dealCards();
		String[] cards = new String[4];
		cards[0] = "14-T";
		cards[1] = "13-T";
		cards[2] = "12-T";
		cards[3] = "11-T";
		game.playHand(cards, false);
		game.winHand();
		assertEquals((int) game.getPlayerByIndex(0).getScore(), 1);
		assertEquals((int) game.getPlayerByIndex(1).getScore(), 0);
		assertEquals((int) game.getPlayerByIndex(2).getScore(), 1);
		assertEquals((int) game.getPlayerByIndex(3).getScore(), 0);
	}

	@Test
	public void testEndOfGame() {
		boolean end = game.endOfGame();
		assertEquals(end, false);
	}

	@Test
	public void testGetCurrentHand() {
		String str = game.getCurrentHand(3);
		assertEquals(str, null);
	}

	@Test
	public void testGetFirstPlayer() {
		int i = game.getFirstPlayer();
		assertEquals(i, 0);
	}

}
