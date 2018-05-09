package testsHuman;

import static org.junit.Assert.*;

import org.junit.Test;

import human.HumanPlayer;

public class HumanPlayerTest {

	@Test
	public void testHumanPlayer() {
		HumanPlayer player = new HumanPlayer();
		assertNull(player.getName());
	}

}
