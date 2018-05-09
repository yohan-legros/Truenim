package testsSmartbot;

import static org.junit.Assert.*;

import org.junit.Test;

import smartbot.GameState;

public class GameStateTest {

	@Test
	public void testGetStick() {
		GameState plateau = new GameState(4);
		assertEquals(4, plateau.getStick(4).length);
		assertEquals(72, plateau.getStick(72).length);
	}

	@Test
	public void testRepeat() {
		assertEquals("|", GameState.repeat(1));
		assertEquals("|||||", GameState.repeat(5));
		assertEquals("", GameState.repeat(0));
	}

}
