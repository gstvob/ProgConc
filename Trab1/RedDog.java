package pkg;

public class RedDog extends Thread {

	static final String color = "vermelho";
	private Forest bosque;
	public RedDog(Forest _bosque) {
		bosque = _bosque;
	}
	public void run (){
		//System.out.println("Cachorro vermelho saiu");
		for (int i = 0; i < 20; i++) {
			if (bosque.getPot(i).getCoins() == 0 && bosque.getPot(i).isEmpty() == false) {
				bosque.AddCoin(i);
				for (int j = 0; j < bosque.getPot(i).SleepingDogAmmount(); j++) {
					bosque.getPot(i).getSleepingDogAt(j).interrupt();
				}
			}
		}
	}
}


