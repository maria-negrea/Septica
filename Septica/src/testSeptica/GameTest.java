package testSeptica;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import septica.Game;

public class GameTest {

	static Game game;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		game = new Game();
		game.addPlayer(0, "AlinaB");
		game.addPlayer(1, "Maria");
		game.addPlayer(2, "Andrei");
		game.addPlayer(3, "AlinaZ");
	}

	@Test
	public void testStartGame() {
		game.startGame();
		
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

}
