package pkg;

public class RedDog extends Thread {
	
	private Forest bosque;

	public RedDog(Forest _bosque) {
		bosque = _bosque;
	}

	/*!
	 * @brief método que fará o cachorro vermelho passar por todos os potes e  
	 */
	public void run() {
		
		for (int i = 0; i < 20; i++) {
			
			if (bosque.getPot(i).getCoins() == 0 && bosque.getPot(i).isEmpty() == false) {
				bosque.AddCoin(i);				
				
				for (int j = 0; j < bosque.getPot(i).SleepingDogAmmount(); j++) {
					System.out.println(
							"Cachorro vermelho acordou um cachorro " + bosque.getPot(i).getSleepingDogAt(j).getColor()
									+ " no pote " + bosque.PotAt(bosque.getPot(i)));
					bosque.getPot(i).getSleepingDogAt(j).interrupt();
					bosque.getPot(i).getSleepingDogAt(j).start();
				}
				bosque.getPot(i).WakeDog(bosque.getPot(i).getSleepingDogAt(0));
			}
		}
	}
}
