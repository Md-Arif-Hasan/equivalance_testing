package it.unibas.tennisgame;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {
	
	Player player = new Player("arif kala para na", 4);
	Player player2 = new Player("Siam", 3);
	@Test
	public void test() {
		
		assertFalse(player.isTieWith(player2));
	}
	
	public void test2() {
		player2.incrementScore();
		assertTrue(player.isTieWith(player2));
	}

}
