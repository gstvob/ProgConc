package pkg;

public class Dog extends Thread {

	private int coins;
	private int threshold = 20;
	private char color;

	private Coordinator coordenador = new Coordinator();
	private String stringColor;
	private Hunter dono;
	private Pot currentPot;
	private Forest bosque;

	public Dog(Hunter _dono, Forest _bosque) {
		coins = 0;
		dono = _dono;
		color = dono.getColor();
		bosque = _bosque;
		currentPot = bosque.getPot(0);
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

	public void setThreshold(int value) {
		threshold = value;
	}
	public int getCoins() {
		return coins;
	}

	public void setCoins(int value) {
		coins = value;
	}

	public String getColor() {
		return stringColor;
	}

	public void Sleep(int value) {
		try {
			sleep(value);
		} catch (InterruptedException e) {
		}
	}

	public void run() {
		while (coins < threshold) {
			currentPot.setUsed(true);

			if (currentPot.getCoins() == 0) {
				
				try {
					System.out.println("Cachorro " + stringColor + " dormiu no pote " + bosque.PotAt(currentPot));
					currentPot.AddSleepingDog(this);
					currentPot.setUsed(false);
					sleep(Main.timeUnit * 60);
				} catch (InterruptedException e1) {
					if (currentPot.getCoins() == 0) {
						try {
							System.out.println("Dormiu denovo porque tinha outro dormindo aqui");
							sleep(Main.timeUnit * 3);
						} catch (InterruptedException e) {}
					}
					coins += bosque.CatchCoins(currentPot);
					System.out.println("Cachorro " + stringColor + " acordou e pegou a moeda no pote "
							+ bosque.PotAt(currentPot) + " total moedas: " + coins);
				}
				currentPot.WakeDog(this);
				try {
					sleep(Main.timeUnit);
				} catch (InterruptedException e) {}
				currentPot = coordenador.ReleaseResource(currentPot.randomPot(), this);
			} else {
				
				coins += bosque.CatchCoins(currentPot);
				try {
					System.out.println("Cachorro " + stringColor + " pegou moeda do pote " + bosque.PotAt(currentPot)
							+ ", Total de moedas: " + coins);
					sleep(Main.timeUnit);
				} catch (InterruptedException e) {
				}
				currentPot.setUsed(false);
				currentPot = coordenador.ReleaseResource(currentPot.randomPot(), this);
			}
		}
	}
}
