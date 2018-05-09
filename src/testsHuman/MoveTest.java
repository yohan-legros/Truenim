package testsHuman;

import static org.junit.Assert.*;

import org.junit.Test;

import human.Move;

public class MoveTest {

	@Test
	public void testMove() {
		Move m = new Move (5, 2);
		assertEquals(5, m.getLigne_move());
		assertEquals(2, m.getNb_allumettes());
	}

}
