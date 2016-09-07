package pkg;

public class Dog extends Thread {

	private int coins;
	private char color;

	private String stringColor;
	private Hunter dono;
	private Pot currentPot;
	private Forest bosque;

	public Dog(char _cor) {
		color = _cor;
		stringColor = "vermelho";
	}

	public Dog(Hunter _dono) {
		coins = 0;
		dono = _dono;
		color = dono.getColor();
		switch (color) {
		case 'y':
			stringColor = "amarelo";
			break;
		case 'b':
			stringColor = "azul";
			break;
		case 'g':
			stringColor = "verde";
			break;
		default:
			break;
		}
	}
	
	@Override
	public void run() {
		currentPot = bosque.getPot(0);
		while (coins < 20) {
			if (currentPot.getCoins() == 0) {
				try {
					System.out.println("Cachorro " + stringColor + " dormiu no pote " + bosque.PotAt(currentPot));
					currentPot.AddSleepingDog(this);
					sleep(Main.timeUnit * 60);
				} catch (InterruptedException e1) {
					System.out.println("INTERROMPEU");
					if (currentPot.getCoins() == 0) {
						try {
							sleep(Main.timeUnit * 3);
						} catch (InterruptedException e) {
						}
					} else {
						coins += bosque.CatchCoins(currentPot);
					}
				}
				System.out.println("Cachorro " + stringColor + " acordou");
				currentPot = currentPot.randomPot();
			}
			coins += bosque.CatchCoins(currentPot);
			try {
				System.out.println("Cachorro " + stringColor + " pegou moeda do pote " + bosque.PotAt(currentPot)+ ", Total de moedas: "+coins);
				sleep(Main.timeUnit);
			} catch (InterruptedException e) {
			}
			currentPot = currentPot.randomPot();
		}
	}

	public void setCoins(int value) {
		coins = value;
	}

	public int getCoins() {
		return coins;
	}
	public void setBosque(Forest _bosque) {
		bosque = _bosque;
	}

	public void setColor(char _color) {
		color = _color;
	}
}
