package testsSmartbot;

import static org.junit.Assert.*;

import org.junit.Test;

import smartbot.Config;

public class ConfigTest {
	
	Config c = new Config ();

	@Test
	public void testRemplirConfig1() {
		c.remplirConfig(5);
		
		assertEquals(5, c.getTete().getElement());
		assertEquals(2, c.getTete().getSuivant().getSuivant().getSuivant().getElement());
		
		assertTrue(c.getTete().isNoyau());
		assertFalse(c.getTete().getSuivant().getSuivant().isNoyau());
	}
	
	@Test
	public void testRemplirConfig2() {
		c.remplirConfig(20);
		
		assertEquals(20, c.getTete().getElement());
		assertEquals(19, c.getTete().getSuivant().getElement());
		
		assertFalse(c.getTete().isNoyau());
		assertTrue(c.getTete().getSuivant().getSuivant().getSuivant().isNoyau());
	}

	@Test
	public void testAjouterEnTete() {
		c.remplirConfig(8);
		
		c.ajouterEnTete(6);
		assertEquals(6, c.getTete().getElement());
		assertFalse(c.getTete().isNoyau());
		assertEquals (8, c.getTete().getSuivant().getElement());
		
		c.ajouterEnTete(15);
		assertEquals(15, c.getTete().getElement());
		assertFalse(c.getTete().isNoyau());
		assertEquals(6, c.getTete().getSuivant().getElement());
	}

	@Test
	public void testSupprNoeud() {
		c.remplirConfig(25);
		
		c.supprNoeud(24);
		assertEquals(24, c.getTete().getElement());
		assertFalse(c.getTete().isNoyau());
		
		c.supprNoeud(1);
		assertEquals(1, c.getTete().getElement());
		assertTrue(c.getTete().isNoyau());
		assertNull(c.getTete().getSuivant());
	}
}
