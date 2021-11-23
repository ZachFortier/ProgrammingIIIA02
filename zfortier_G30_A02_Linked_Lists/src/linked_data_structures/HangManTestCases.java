package linked_data_structures;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HangManTestCases {

	@Test                                                   //Test for correct letters in wordLine
	void test1() {
		Game game = new Game();
		game.setWord("skate");
		
		assertEquals(game.wordLetters.getElementAt(0), 'e');
		assertEquals(game.wordLetters.getElementAt(1), 't');
		assertEquals(game.wordLetters.getElementAt(2), 'a');
		assertEquals(game.wordLetters.getElementAt(3), 'k');
		assertEquals(game.wordLetters.getElementAt(4), 's');
	}
	
	
	@Test                                                   //Test for length of wordLetters and WordLine
	void test2() {
		Game game = new Game();
		game.setWord("word");
		game.makeWordLine();
		assertEquals(game.wordLetters.getLength(), 4);
		assertEquals(game.wordLine.getLength(), 4);
	}
	
	
	@Test                                                   //Test that non alphabetical characters get placed in word line
	void test3() {
		Game game = new Game();
		game.setWord("ac/dc");
		game.makeWordLine();
		game.fillWordLine();
		assertEquals(game.wordLine.getElementAt(2), '/');
	}
	
	
	@Test                                                   //Test that letter gets placed in wordline upon guess
	void test4() {
		
		Game game = new Game();
		game.setWord("word");
		game.makeWordLine();
		game.checkAnswer('w');
		
		assertEquals(game.wordLine.getElementAt(3), 'w');
		
	}
	
	
	@Test                                                   //check that a guessed letter gets added to guessed letters
	void test5() {
		
		Game game = new Game();
		game.addGuessedLetters('w');
		assertEquals(game.guessedLetters.getElementAt(0), 'w');
	}
	
	
	@Test                                                   //check that a failed letter gets added to failed letters
	void test6() {
		
		Game game = new Game();
		game.setWord("word");
		game.failedGuesses('l');
		assertEquals(game.failedLetters.getElementAt(0), 'l');
	}	
	
	
	
	@Test                                                   //check that a non failed letter dosent get added to failed letters
	void test7() {
		
		Game game = new Game();
		game.setWord("word");
		game.failedGuesses('l');
		game.failedGuesses('w');
		assertEquals(game.failedLetters.getLength(), 1);
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Test                                                   //Hint takes body part
	void test8() {
		
		Game game = new Game();
		game.setWord("word");
		game.makeWordLine();
		game.getHint();
		assertEquals(game.getNumberOfGuesses(), 1);
		
	}
	
	
	@Test                                                   //Hint provides unused letter
	void test9() {
		
		Game game = new Game();
		assertEquals(game.getNumberOfGuesses(), 0);
		game.setWord("word");
		game.makeWordLine();
		game.getHint();
		assertEquals(game.getNumberOfGuesses(), 1);
		
	}
	
	
	@Test                                                   //Cant lose on hint           <-----------------
	void test10() {
	
		Game game = new Game();
		game.setWord("word");
		game.makeWordLine();
		game.checkAnswer('w');
		game.checkAnswer('o');
		game.checkAnswer('r');
		
		assertEquals(game.checkWin(), false);
		
	}
	
	
	@Test                                                   //Dictionairy reads from file AND file exists          (2 in one)
	void test11() {											//If make list functions then file is being read
		
		GetWords words = new GetWords();
		words.makeList();
		assertTrue(words.randomWords.getLength() != 0);
		
		
	}
	
	
	@Test                                                   //new player must be unique
	void test12() {
		ScoreBoard sb = new ScoreBoard();
		sb.addNewUser("zach");
		assertTrue(sb.checkUser("zach") == false);
		
	}
	
	
	@Test                                                   //min / max player name length
	void test13() {
		
		ScoreBoard sb = new ScoreBoard();
		assertTrue(sb.checkLength("thisisalongnameeeeeeeeeeeeeeeeeeeee") == false);
		assertTrue(sb.checkLength("t") == false);
		
		
	}
	
	
	@Test                                                   //MaxLength word (14)
	void test14() {
		
		Game game = new Game();
		
		assertTrue(game.checkLength("ThisIsWayyyyyyyyyyyyyyyyyyyyyyyyyyyTooooooooooooooooooLonggggggggg") == false);
		
	}
	
	
	@Test                                                   //MinLength word(4)
	void test15() {
		
		Game game = new Game();
		
		assertTrue(game.checkLength("s") == false);
		
	}
	
	
	
	@Test                                                   //Guessable / non guessable filters
	void test16() {
		Game game = new Game();
		game.setWord("ac/dc");
		game.makeWordLine();
		game.fillWordLine();
		assertEquals(game.wordLine.getElementAt(2), '/');
	}
	
	
	
	@Test                                                   //Word is randomly chosen
	void test17() {
		GetWords word = new GetWords();
		word.makeList();
		String test = word.pickWord();
		assertTrue((test != word.pickWord()) || (test != word.pickWord()) || (test != word.pickWord()) || (test != word.pickWord()) || (test != word.pickWord()) || (test != word.pickWord()) || (test != word.pickWord()));
		
	}
	
	
	@Test                                                   //Games won / games played shows correctly
	void test18() {
		
		ScoreBoard sb = new ScoreBoard();
		
		sb.addNewUser("zach");
		sb.updateInfo("zach", 1, 0);
		assertTrue(sb.playerList.getElementAt(0).getName() == "zach" && sb.playerList.getElementAt(0).getGamesPlayed() == 1 && sb.playerList.getElementAt(0).getGamesWon() == 0);
		
	}
	
	
	
	

}
