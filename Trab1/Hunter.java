package pkg;

public class Hunter extends Thread{

	private int totalCoins;
	private Forest bosque;
	private Dog[] dogs;
	private char color;
	
	public Hunter(char _color, Forest _bosque) {
		bosque = _bosque;
		totalCoins = 0;
		color = _color;
		dogs = new Dog[2];
	}
	public char getColor () {
		return color;
	}
	public String getStringColor() {
		switch (color) {
			case 'y':
				return "amarelo";
			case 'b':
				return "azul";
			case 'g':
				return "verde";
			default :
				return null;
		}
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
	public void run() {
		dogs[0].run();
		if (dogs[0].isAlive() == false) {
			totalCoins += dogs[0].getCoins();
			dogs[0].setCoins(0);
			dogs[1].run();
		}
		if (dogs[1].isAlive() == false) {
			totalCoins += dogs[1].getCoins();
			dogs[1].setCoins(0);
			dogs[0].run();
		}
		totalCoins += dogs[0].getCoins();
		dogs[0].setCoins(0);
		bosque.setWinnerOrder(this);
	}
}
