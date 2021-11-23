package linked_data_structures;

public class Player {
	
	String name;
	int numberGamesPlayed;
	int numberGamesWon;
	
public Player() {
	
	name = "unknown";
	numberGamesPlayed = 0;
	numberGamesWon = 0;
	
}//Player() base constructor

public Player(String n, int play, int won) {
	
	name = n;
	numberGamesPlayed = play;
	numberGamesWon = won;
	
	
}//Player(name) constructor

public void setName(String n) {
	
	name = n;
	
}//setName

public void setGamesPlayed(int p) {
	
	numberGamesPlayed = p;
	
}//setGamesPlayed

public void setGamesWon(int w) {
	
	numberGamesWon = w;
	
}//setGamesWon

public String getName() {
	
	return name;
}//getName

public int getGamesPlayed() {
	
	return numberGamesPlayed;
}//getGamesPlayed

public int getGamesWon() {
	
	return numberGamesWon;
}//getGamesWon

}//Player
