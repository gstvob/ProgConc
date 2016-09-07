package pkg;

public class Hunter{

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
	public void setDogs(Dog _dog1, Dog _dog2) {
		dogs[0] = _dog1;
		dogs[1] = _dog2;
	}
	public void addCoins(int value) {
		totalCoins += value;
	}
	public int getTotalCoin() {
		return totalCoins;
	}
}
