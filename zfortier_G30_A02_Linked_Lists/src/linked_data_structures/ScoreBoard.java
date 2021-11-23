package linked_data_structures;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ScoreBoard {
	
	Player found;
	DoublyLinkedList<Player> playerList = new DoublyLinkedList<Player>();
	
	public boolean checkUser(String user) { //-------------------------------------------------------------------
		boolean allGood = true;
		
		if(playerList.getLength() != 0) {
			
			for(int i = 0; i < playerList.getLength(); i++) {
				
				if(user.equals(playerList.getElementAt(i).getName())) {
					
					allGood = false;
					
				}//if
			}//for
		}//if
		
		return allGood;
		
	}//Check User---------------------------------------------------------------------------------------------
	
	
	public void addNewUser(String user) {
		
		playerList.add(new Player(user, 0, 0));
		
	}//addNewUser----------------------------------------------------------------------------------------------
	
	public void updateInfo(String user, int played, int won) {
		
		if(playerList.getLength() != 0) {
			
			for(int i = 0; i < playerList.getLength(); i++) {
				
				if(user.equals(playerList.getElementAt(i).getName())) {
					
					playerList.remove(i);
					
					playerList.add(new Player(user, played, won));
				}//if
			}//for
		}//if
		
	}//updateInfo----------------------------------------------------------------------------------------------
	
	public Player findPlayer(String user) {
		
		if(playerList.getLength() != 0) {
			
			for(int i = 0; i < playerList.getLength(); i++) {
				
				if(user.equals(playerList.getElementAt(i).getName())) {
					
				found = playerList.getElementAt(i);
					
				}//if
			}//for
		}//if
		
		return found;
		
	}//findPlayer -----------------------------------------------------------------------------------------------
	
	public boolean checkLength(String word) {
		boolean isGood = true;
		if(word.length() < 3 || word.length() > 14) {
			isGood = false;
		}
		return isGood;
	}//checkLenght-----------------------------------------------------------------------------------------------------------------------
	
	public void serializable() {
		
		String filename = "savedLister.ser";
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            for(int i = 0; i < playerList.getLength(); i++) {
            	
            
            out.writeObject(playerList.getElementAt(i));
            out.close();
            file.close();
            }
            System.out.println("Object has been serialized");
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }
        	
	}//serializable ------------------------------------------------------------------------------------------------
	
	public void deserializable() throws IOException, ClassNotFoundException {
		
		FileInputStream file = new FileInputStream("savedLister.ser");
		ObjectInputStream in = new ObjectInputStream(file);
		
		playerList.add((Player)in.readObject());
		
	}//deserializable-----------------------------------------------------------------------------------------------
	
	
	
	

}//ScoreBoard
