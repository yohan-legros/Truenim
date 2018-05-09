package testsHuman;

import static org.junit.Assert.*;

import org.junit.Test;

import human.Console;
import human.Move;

public class isInvalidMoveTest {
	
	private int [] board = new int [] {1, 2, 3, 0};
	
	@Test
	public void shouldReturnTrueIfTheRowDoesntExist() {
		assertTrue(Console.isInvalidMove(new Move (5, 2), board));
	}
	
	@Test
	public void shouldReturnTrueIfTheNumberOfMatchesIsInvalid() {
		assertTrue(Console.isInvalidMove(new Move (2, 4), board));
	}
	
	@Test
	public void shouldReturnTrueIfTheRowIsEmpty() {
		assertTrue(Console.isInvalidMove(new Move (4, 1), board));
	}
	
	@Test
	public void shouldReturnTrueIfTheNumberOfMatchesInTheBoardIsNotSufficient() {
		assertTrue(Console.isInvalidMove(new Move (1, 3), board));
	}
}
