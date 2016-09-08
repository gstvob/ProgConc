package pkg;

public class Hunter extends Thread{

	private int totalCoins;
	private char color;
	
	private Forest bosque;
	private Dog[] dogs;
	
	public Hunter(char _color, Forest _bosque) {
		bosque = _bosque;
		totalCoins = 0;
		color = _color;
		dogs = new Dog[2];
	}
	
	//Operações relacionadas a cor do caçador.
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
	//Metodo para setar os cachorros que esse caçador possui
	public void setDogs(Dog _dog1, Dog _dog2) {
		dogs[0] = _dog1;
		dogs[1] = _dog2;
	}
	//Método para retornar quantas moedas esse caçador tem.
	public int getTotalCoin() {
		return totalCoins;
	}
	
	//Método run para executar um cachorro, depois o outro, depois o um até o dono ter 50 moedas
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
			dogs[0].setThreshold(10);
			dogs[0].run();
		}
		totalCoins += dogs[0].getCoins();
		dogs[0].setCoins(0);
		bosque.setWinner(this);
	}
}