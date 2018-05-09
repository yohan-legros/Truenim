package testsSmartbot;

import static org.junit.Assert.*;

import org.junit.Test;

import smartbot.Console;
import smartbot.Move;

public class isInvalidMoveTest {
	
	int [] t = new int [] {1, 0};

	@Test
	public void shouldReturnTrueIfTheRowDoesntExist() {
		assertTrue(Console.isInvalidMove(new Move (10, 1), t));
	}
	
	@Test
	public void shouldReturnTrueIfTheNumberOfMatchesIsInvalid() {
		assertTrue(Console.isInvalidMove(new Move (1, 6), t));
	}
	
	@Test
	public void shouldReturnTrueIfTheRowIsEmpty() {
		assertTrue(Console.isInvalidMove(new Move (2, 2), t));
	}
	
	@Test
	public void shouldReturnTrueIfTheNumberOfMatchesInTheBoardIsNotSufficient() {
		assertTrue(Console.isInvalidMove(new Move (1, 3), t));
	}

}
