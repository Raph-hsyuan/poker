package poker;

import java.io.ByteArrayInputStream;

public class Main {

	public static void main(String[] args) {
		Croupier me=new Croupier();
		String data1="2H 3D 5S 9C KD\n";
		String data2="2C 3H 4S 8C AH\n";
		System.setIn(new ByteArrayInputStream(data1.getBytes()));
		System.setIn(new ByteArrayInputStream(data2.getBytes()));
		me.startGame();

	}
}
