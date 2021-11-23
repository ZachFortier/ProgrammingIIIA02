package linked_data_structures;

public class Game {
	
	SinglyLinkedList<Character> wordLetters = new SinglyLinkedList<Character>();
	SinglyLinkedList<Character> guessedLetters = new SinglyLinkedList<Character>();
	SinglyLinkedList<Character> wordLine = new SinglyLinkedList<Character>();
	SinglyLinkedList<Character> failedLetters = new SinglyLinkedList<Character>();
	
	char guess;
	int guesses = 0;
	boolean allGood = true;
	
	String playerName;//----------------------------------------------------------------------------------------------------------
	int playerGamesPlayed;
	int playerGamesWon;
	
	public void setPlayerName(String name) {
		playerName = name;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setGamesPlayed(int played) {                                                                         //PlayerInfo
		playerGamesPlayed = played;
	}
	public int getGamesPlayed() {
		return playerGamesPlayed;
	}
	public void setGamesWon(int won) {
		playerGamesWon = won;
	}
	public int getGamesWon() {
		return playerGamesWon;
	}//---------------------------------------------------------------------------------------------------------------------------
	
	
	public void setWord(String w) {
		
		for(int i = 0; i < w.length(); i++) {
			
			wordLetters.add(w.charAt(i));
			
		}
	}//SetWord-------------------------------------------------------------------------------------------------------------------
	
	public String toString(SinglyLinkedList<Character> list) {
		String listString = "" ;
		for(int i = (list.getLength() - 1); i >= 0; i--) {
			
			listString += (list.getElementAt(i) + " ");
			
		}
		
		return listString;
		
	}//toString
	
	
	public int getNumberOfGuesses() {
		
		return guesses;
		
	}//getNumberOfGuesses-----------------------------------------------------------------------------------------------------------
	
	public void resetGuesses() {
		
		guesses = 0;
		
	}//ResetGuesses-----------------------------------------------------------------------------------------------------------------
	
	
	public void updatePlayerWins() {
		
		playerGamesWon = playerGamesWon + 1;
		
	}//updatePlayerWins-------------------------------------------------------------------------------------------------------------
	
	
	public void makeWordLine() {
		
		for(int i = 0; i < (wordLetters.getLength()); ++i) {
			
			wordLine.add('_');
		
		}//for
	}//makewordline------------------------------------------------------------------------------------------------------------------
	
public void checkAnswer(char guess) {
		
	for(int i = 0; i < wordLetters.getLength(); i++)
		
	if(guess == wordLetters.getElementAt(i)) {
		wordLine.add(guess, i);   
		wordLine.remove(i + 1);
	}

		                                                                       
}//check answer----------------------------------------------------------------------------------------------------------------------

public void numberOfGuesses(char guess) {
	boolean keepGoing = false;
	
	for(int i = 0; i < wordLetters.getLength(); i++)
		
		if(guess == wordLetters.getElementAt(i)) {
			keepGoing = true;
	}
	
	if(keepGoing == false) {
		guesses = guesses + 1;
	}
}//numberOfGuesses------------------------------------------------------------------------------------------------------------------

public void failedGuesses(char guess) {
	
	boolean passed = false;
	
	for(int i = 0; i < wordLetters.getLength(); i++) {
		
			if(guess == wordLetters.getElementAt(i)) {
				passed = true;
			}//if
		
	}//for
	
	if(passed == false) {
		failedLetters.add(guess);
	}
	
}// failedGuesses()---------------------------------------------------------------------------------------------------------------

public boolean checkWin() {
	allGood = true;
	for(int i = 0; i < wordLine.getLength(); i++) {
		
		if(wordLine.getElementAt(i) == '_') {
			allGood = false;
		}
	}
	
	return allGood;
}//checkWin()--------------------------------------------------------------------------------------------------------------------

public void getHint() {
	
boolean goahead = false;

	
	while(goahead == false) {
		
		int r = (int) (Math.random() * (wordLetters.getLength()));
		
		if(wordLine.getElementAt(r) == '_') {
			
			guessedLetters.add(wordLetters.getElementAt(r));
			wordLine.add(wordLetters.getElementAt(r), r);   
			wordLine.remove(r + 1);
			
			
			goahead = true;
			
			for(int i = 0; i < wordLetters.getLength(); i++) {
				
				if(wordLetters.getElementAt(r) == wordLetters.getElementAt(i)) {
					
					wordLine.add(wordLetters.getElementAt(i), i);
					wordLine.remove(i + 1);
					
				}//if
				
			}//for
			
		}//if
		
	}//while
			

		
	    guesses = guesses + 1;
	
	
}//getHint()--------------------------------------------------------------------------------------------------------------------------


public void resetFailedGuesses() {
	
	while(failedLetters.getLength() > 0) {
		failedLetters.remove(0);
	}
	
}// failedGuesses()-----------------------------------------------------------------------------------------------------------------

public void resetGuessedLetters() {
	
	while(guessedLetters.getLength() > 0) {
		guessedLetters.remove(0);
	}
}// resetGuessedLetters()-----------------------------------------------------------------------------------------------------------

public void resetWordLine() {
	
	while(wordLine.getLength() > 0) {
		wordLine.remove(0);
	}                                              
	
}//ResetWordLine--------------------------------------------------------------------------------------------------------------------

public void resetWordLetters() {
	
	while(wordLetters.getLength() > 0) {
		wordLetters.remove(0);
	}                                              
	
}//ResetWordLetters--------------------------------------------------------------------------------------------------------------------

public void addGuessedLetters(char guess) {
	
	guessedLetters.add(guess);
	
}//addGuessedLetters()--------------------------------------------------------------------------------------------------------------

public boolean checkGuessedLetter(char guess) {
	
	boolean letterGuessed = false;
	
	for(int i = 0; i < guessedLetters.getLength(); i++) {
		
		if(guess == guessedLetters.getElementAt(i)) {
			letterGuessed = true;
		}
		
	}
	return letterGuessed;
	
}//checkGuessedLetter---------------------------------------------------------------------------------------------------------------

public void fillWordLine() {
	
	for(int i = 0; i < wordLetters.getLength(); i++) {
		
		if((wordLetters.getElementAt(i) != 'a') && (wordLetters.getElementAt(i) != 'b') && (wordLetters.getElementAt(i) != 'c') && (wordLetters.getElementAt(i) != 'd') && (wordLetters.getElementAt(i) != 'e') && (wordLetters.getElementAt(i) != 'f') && (wordLetters.getElementAt(i) != 'g') && (wordLetters.getElementAt(i) != 'h') && (wordLetters.getElementAt(i) != 'i') && (wordLetters.getElementAt(i) != 'j') && (wordLetters.getElementAt(i) != 'k') && (wordLetters.getElementAt(i) != 'l') && (wordLetters.getElementAt(i) != 'm') && (wordLetters.getElementAt(i) != 'n') && (wordLetters.getElementAt(i) != 'o') && (wordLetters.getElementAt(i) != 'p') && (wordLetters.getElementAt(i) != 'q') && (wordLetters.getElementAt(i) != 'r') && (wordLetters.getElementAt(i) != 's') && (wordLetters.getElementAt(i) != 't') && (wordLetters.getElementAt(i) != 'u') && (wordLetters.getElementAt(i) != 'v') && (wordLetters.getElementAt(i) != 'w') && (wordLetters.getElementAt(i) != 'x') && (wordLetters.getElementAt(i) != 'y') && (wordLetters.getElementAt(i) != 'z')) {
		
			wordLine.add(wordLetters.getElementAt(i), i);
			wordLine.remove(i + 1);
			
		}
	}
	
}

public boolean checkLength(String word) {
	boolean isGood = true;
	if(word.length() < 4 || word.length() > 14) {
		isGood = false;
	}
	return isGood;
}//checkLenght-----------------------------------------------------------------------------------------------------------------------

}
