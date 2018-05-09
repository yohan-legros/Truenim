package testsHuman;

import static org.junit.Assert.*;

import org.junit.Test;

import human.Board;
import human.HumanPlayer;
import human.Move;

public class BoardTest {

	@Test
	public void testAuTourDePlayer1() {
		HumanPlayer player1 = new HumanPlayer ("a");
		HumanPlayer player2 = new HumanPlayer ("b");
		assertEquals("a", Board.auTourDe(2, player1, player2));
	}
	
	@Test
	public void testAuTourDePlayer2() {
		HumanPlayer player1 = new HumanPlayer ("a");
		HumanPlayer player2 = new HumanPlayer ("b");
		assertEquals("b", Board.auTourDe(1, player1, player2));
	}
	
	@Test
	public void testApplyMove() {
		int [] board = new int [] {1, 7, 3};
		
		Board.applyMove(new Move (2, 2), board);
		assertEquals(5, board[1]);
		Board.applyMove(new Move (1, 1), board);
		assertEquals(0, board[0]);
	}

	@Test
	public void testWinnerA() {
		assertEquals("a", Board.winner(18, "a", "b"));
	}
	
	@Test
	public void testWinnerB() {
		assertEquals("b", Board.winner(7, "a", "b"));
	}
}
