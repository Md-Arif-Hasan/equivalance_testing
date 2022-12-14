package it.unibas.test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.unibas.tennisgame.DuplicatedPlayerException;
import it.unibas.tennisgame.Game;
import it.unibas.tennisgame.GameHasAlreadyBeWonException;
import it.unibas.test.PlayerTest;

public class GameTest {

	
	
	@Test
	public void testSamePlayer1() throws DuplicatedPlayerException {
		
		Game game = new Game(PlayerTest.FEDERER,PlayerTest.NADAL);
		String name1 = game.getPlayerName1();
		assertEquals(PlayerTest.FEDERER, name1);
		
	}
	
	@Test
	public void testSamePlayer2() throws DuplicatedPlayerException {
		
		Game game = new Game(PlayerTest.FEDERER,PlayerTest.NADAL);
		String name2 = game.getPlayerName2();
		assertEquals(PlayerTest.NADAL, name2);
		
	}
	
	@Test(expected=DuplicatedPlayerException.class)
	public void testGameWithDuplicatedPlayer() throws Exception
	{
		new Game(PlayerTest.FEDERER, PlayerTest.FEDERER);
		
	}
	
	@Test
	public void testGameAtBeginning() throws Exception{
		Game game = new Game(PlayerTest.FEDERER, PlayerTest.NADAL);
		String status = game.getGameStatus();
		assertEquals("Federer love - Nadal love", status);
		
	}
	
	@Test
	public void testWinner() throws Exception{
		Game game = new Game(PlayerTest.FEDERER, PlayerTest.NADAL);
		String player1=game.getPlayerName1();
		game.incrementPlayerScore(player1);
		game.incrementPlayerScore(player1);
		game.incrementPlayerScore(player1);
		game.incrementPlayerScore(player1);
		String status = game.getGameStatus();
		assertEquals("Federer wins", status);
		
	}

	
	
	
	
	
	/* 0, 15, 30 point gular jonno ei test rakhsi  
	*
	* It can be :
	* Federer love - Nadal love
	* Federer fifteen - Nadal love
	* Federer thirty - Nadal love
	*
	* Federer love - Nadal fifteen
	* Federer fifteen - Nadal fifteen
	* Federer thirty - Nadal fifteen
	*
	* Federer love - Nadal thirty
	* Federer fifteen - Nadal thirty
	* Federer thirty - Nadal thirty
	*
	* Federer love - Nadal forty
	* Federer fifteen - Nadal forty
	* Federer thirty - Nadal forty
	*
	*
	* etc.................
	*
	* */
	
	
	
	
	@Test
	public void testPlayer1FifteenPlayer2Love() throws Exception{
		Game game = new Game(PlayerTest.FEDERER, PlayerTest.NADAL);
		String player1=game.getPlayerName1();
		game.incrementPlayerScore(player1);
		String status = game.getGameStatus();
		assertEquals("Federer fifteen - Nadal love", status);
		
	}
	
	
	
	@Test
	public void testPlayerDraw() throws Exception{
		Game game = new Game(PlayerTest.FEDERER, PlayerTest.NADAL);
		String player1=game.getPlayerName1();
		game.incrementPlayerScore(player1);
		game.incrementPlayerScore(player1);
		game.incrementPlayerScore(player1);
		String player2=game.getPlayerName2();

		game.incrementPlayerScore(player2);
		game.incrementPlayerScore(player2);
		game.incrementPlayerScore(player2);
		
		String status = game.getGameStatus();
		assertEquals("Deuce", status);
		
	}
	
	
	
	@Test
	public void testAdvantage() throws Exception{
		Game game = new Game(PlayerTest.FEDERER, PlayerTest.NADAL);
		String player1=game.getPlayerName1();
		game.incrementPlayerScore(player1);
		game.incrementPlayerScore(player1);
		game.incrementPlayerScore(player1);
		
		String player2=game.getPlayerName2();

		game.incrementPlayerScore(player2);
		game.incrementPlayerScore(player2);
		game.incrementPlayerScore(player2);
		
		game.incrementPlayerScore(player1);

		String status = game.getGameStatus();
		assertEquals("Advantage Federer", status);
		
	}
	
	
	@Test
	public void incrementTest() throws Exception{
		Game game2 = new Game(PlayerTest.FEDERER, PlayerTest.NADAL);
		
		String player1=game2.getPlayerName1();
		game2.incrementPlayerScore(player1);
		game2.incrementPlayerScore(player1);
		
		String player2=game2.getPlayerName2();
		game2.incrementPlayerScore(player2);
		
		String status = game2.getGameStatus();
		assertEquals("Federer thirty - Nadal fifteen", status);

		
	}
	
	
}
