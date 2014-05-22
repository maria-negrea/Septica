package testSeptica;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import septica.Game;
import septica.Player;

public class TestGame {

	private static Game game;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		game = new Game();
	}

	@Test
	public void testAddPlayerInt() {
		game.addPlayer(1);
		Player p1 = game.getPlayerById(1);
		Player p2 = game.getPlayerByIndex(0);
		assertEquals(p1, p2);
	}

	@Test
	public void testAddPlayerIntString() {
		fail("Not yet implemented");
	}

	@Test
	public void testStartGame() {
		fail("Not yet implemented");
	}

	@Test
	public void testDealCards() {
		fail("Not yet implemented");
	}

	@Test
	public void testPlayHand() {
		fail("Not yet implemented");
	}

	@Test
	public void testCanContinue() {
		fail("Not yet implemented");
	}

	@Test
	public void testWinHand() {
		fail("Not yet implemented");
	}

	@Test
	public void testEndOfGame() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCurrentHand() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFirstPlayer() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCurrentStatus() {
		fail("Not yet implemented");
	}

}
