package pkg;

public class Hunter {

	private int totalCoins;
	private Dog[] dogs;
	private char color;
	
	public Hunter(char _color) {
		totalCoins = 0;
		color = _color;
		dogs = new Dog[2];
	}
	public char getColor() {
		return color;
	}
	public void paintDogs() {
		for(int i = 0; i < dogs.length; i++) {
			dogs[i].setColor(color);
		}
	}
	public void addCoins(int value) {
		totalCoins += value;
	}
	public int getTotalCoin() {
		return totalCoins;
	}
}
