package testsSmartbot;

import static org.junit.Assert.*;

import org.junit.Test;

import smartbot.Board;
import smartbot.Config;
import smartbot.HumanPlayer;
import smartbot.IA;
import smartbot.Move;

public class BoardTest {

	@Test
	public void testAuTourDeP1() {
		HumanPlayer p1 = new HumanPlayer ("a");
		IA bot = new IA ();
		assertEquals("a", Board.auTourDe(8, p1, bot));
	}
	
	@Test
	public void testAuTourDuBot() {
		HumanPlayer p1 = new HumanPlayer ("a");
		IA bot = new IA ();
		assertEquals("le bot", Board.auTourDe(11, p1, bot));
	}

	@Test
	public void testApplyMove() {
		int [] t = new int [] {1, 1, 2, 5, 3};
		Config c = new Config ();
		c.remplirConfig(12);
		
		Board.applyMove(new Move (1, 1), t, c);
		assertEquals(0, t[0]);
		assertEquals(11, c.getTete().getElement());
		
		Board.applyMove(new Move (4, 3), t, c);
		assertEquals(2, t[3]);
		assertEquals(8, c.getTete().getElement());
	}

	@Test
	public void testWinnerA() {
		assertEquals("a", Board.winner(6, "a", "b"));
	}
	
	@Test
	public void testWinnerB() {
		assertEquals("b", Board.winner(21, "a", "b"));
	}

	@Test
	public void testTotal_allumettes() {
		assertEquals(6, Board.total_allumettes(new int [] {1, 2, 3}));
		assertEquals(23, Board.total_allumettes(new int [] {4, 10, 0, 9}));
		assertEquals(0, Board.total_allumettes(new int [] {0, 0, 0, 0}));
	}

}
