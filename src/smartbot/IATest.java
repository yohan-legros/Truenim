package smartbot;

import static org.junit.Assert.*;

import org.junit.Test;

public class IATest {

	Config c = new Config ();
	
	@Test
	public void testBotMoveNoyau() {
		int [] t = new int [] {0, 3, 5, 4};
		c.remplirConfig(12);
		assertEquals(2, IA.botMove(t, c).getLigne_move());
		assertEquals(3, IA.botMove(t, c).getNb_allumettes());
	}
	
	@Test
	public void testBotMoveCoupDattente() {
		int [] t = new int [] {0, 2, 2, 5};
		c.remplirConfig(9);
		assertEquals(2, IA.botMove(t, c).getLigne_move());
		assertEquals(1, IA.botMove(t, c).getNb_allumettes());
	}
	
	@Test
	public void testBotMoveNoSufficientMatches () {
		int [] t = new int [] {1, 1, 2};
		c.remplirConfig(4);
		assertEquals(1, IA.botMove(t, c).getLigne_move());
		assertEquals(1, IA.botMove(t, c).getNb_allumettes());
	}

	@Test
	public void testFindRow() {
		int [] t = new int [] {1, 0, 2, 7};
		assertEquals(1, IA.findRow(t, 1));
		assertEquals(3, IA.findRow(t, 2));
		assertEquals(4, IA.findRow(t, 7));
		assertEquals(0, IA.findRow(t, 10));
		
	}

}
