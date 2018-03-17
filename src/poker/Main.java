package poker;

/**
 * @author Groupe A
 * @date 2018-3-17
 * To launch the game
 * 
 * Sample input:
 * 
 * Main 1:  
 * 2Tr 6Ca 3Ca 8Tr APi 
 * Main 2:  
 * 3Tr 6Pi 2Ca 8Co ACo 
 * 
 * Sample output:
 * Egalite 
 */
public class Main {

	public static void main(String[] args) {
		Croupier me=new Croupier();
		me.startGame();

	}
}
