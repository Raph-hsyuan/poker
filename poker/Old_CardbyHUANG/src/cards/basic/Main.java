package cards.basic;

/**
 * Launch the game
 * @author HUANG Shenyuan
 * @version 2017.12.29
 */
public class Main {

	public static void main(String[] args) {
		Game game = new Game("Tomy", "Jack", "Jerry", "Seiya", "HUANG");// New
																		// Game
		game.gameStart();// Start Game
	}

}
