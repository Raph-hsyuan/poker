package poker;

/**
 * @author Groupe A
 * @date 2018-3-10
 */
public enum Suit {
	TREFLE("Tr"), CARREAU("Ca"), COEUR("Co"), PIQUE("Pi");
	private String name;

	Suit(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
