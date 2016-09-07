package pkg;

public class RedDog extends Thread {

	static final String color = "vermelho";
	private Forest bosque;

	public RedDog(Forest _bosque) {
		bosque = _bosque;
	}

	public void run() {
		// System.out.println("Cachorro vermelho saiu");
		for (int i = 0; i < 20; i++) {
			if (bosque.getPot(i).getCoins() == 0 && bosque.getPot(i).isEmpty() == false) {
				bosque.AddCoin(i);
				System.out.println("Tem " +bosque.getPot(i).SleepingDogAmmount()+ " cachorro(s) dormindo aqui");
				
				for (int j = 0; j < bosque.getPot(i).SleepingDogAmmount(); j++) {
					System.out.println(
							"Cachorro vermelho acordou um cachorro " + bosque.getPot(i).getSleepingDogAt(j).getColor()
									+ " no pote " + bosque.PotAt(bosque.getPot(i)));
					bosque.getPot(i).getSleepingDogAt(j).interrupt();
					bosque.getPot(i).getSleepingDogAt(j).start();
				}
				bosque.getPot(i).WakeDog(bosque.getPot(i).getSleepingDogAt(0));
				System.out.println("Agora tem " +bosque.getPot(i).SleepingDogAmmount());
			}
		}
	}
}
