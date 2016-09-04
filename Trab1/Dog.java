package pkg;

public class Dog extends Thread {

	private char color;
	private Hunter dono;
	private int coins;
	private Pot currentPot;
	private Forest bosque;
	
	public Dog(Hunter _dono) {
		coins = 0;
		dono = _dono;
		color = dono.getColor();
	}
	public void run() {
		currentPot = bosque.getPot(0);
		while(coins <= 50) {
			coins += currentPot.CatchCoin();
			System.out.println("cachorro "+ color+ "pegou moeda no : "+bosque.PotAt(currentPot) +", "+coins);
			try {
				Dog.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			currentPot = currentPot.randomPot();
			System.out.println("mudou de pot esse arrombado");
		}
	}
	public void setBosque(Forest _bosque) {
		bosque = _bosque;
	}
	public void setColor(char _color) {
		color = _color;
	}
}
