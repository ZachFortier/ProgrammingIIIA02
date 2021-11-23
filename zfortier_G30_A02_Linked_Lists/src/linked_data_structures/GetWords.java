package linked_data_structures;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GetWords {
	
	Game game = new Game();
	private Scanner dReader;
	
	SinglyLinkedList<String> randomWords = new SinglyLinkedList<String>();
	
	public void makeList() //---------------------------------------------------------------------------------------
	{
		try {
			dReader = new Scanner(new File("dictionary.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: Dictionairy.txt was not found");
		} catch (IOException e) {
			System.out.println("ERROR: Error opening Dictionairy.txt : " + e.getMessage());
		}
		
		while (dReader.hasNext()) {
			
			randomWords.add(dReader.nextLine());
		}	
	}// make list---------------------------------------------------------------------------------------------------
	
	public String pickWord() {
		 int max = randomWords.getLength();
	     int min = 1;
	     int range = max - min + 1;
	     int rand = (int)(Math.random() * range);
	     
	     String theWord = randomWords.getElementAt(rand);
	     return theWord;
	}//pick word-----------------------------------------------------------------------------------------------------
	
	public void getListLength() {
		System.out.print(randomWords.getLength() + "\n");
	}//get list length-----------------------------------------------------------------------------------------------
	
	public void resetWords() {
		while(randomWords.getLength() > 0) {
			randomWords.remove(0);
		}
	}//reset words---------------------------------------------------------------------------------------------------
	
	public void listWords() {
		for(int i = 0; i < randomWords.getLength(); i++) {
			System.out.print(randomWords.getElementAt(i)+ "");
		}
	}//list words----------------------------------------------------------------------------------------------------
	
	
	
}
