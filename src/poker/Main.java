package poker;

/**
 * @author Groupe A
 * @date 2018-3-17
 * To launch the game
 * 
 * Sample input:
 * Player1: 
 * 2H 3D 5S 9C KD  
 * Player2: 
 * 2C 3H 4S 8C AH
 * 
 * Sample output:
 * player2 win! High Card : AH 
 */
public class Main {

	public static void main(String[] args) {
		Croupier me=new Croupier();
		me.startGame();

	}
}
