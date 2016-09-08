package pkg;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
	static final int timeUnit = 100;/*<!Constante que indica a quantidade do tempo = 100milisegundos.>*/
	
	/*!
	 * @brief método main que inicializa os caçadores, cachorros e o bosque.
	 */

	public static void main(String[] args) {
		Forest bosque = new Forest();
		ArrayList<Dog> dogsThread = new ArrayList<Dog>();
		Hunter cacador1 = new Hunter('b', bosque);
		Hunter cacador2 = new Hunter('y', bosque);
		Hunter cacador3 = new Hunter('g', bosque);

		Dog cachorro1 = new Dog(cacador1, bosque);
		Dog cachorro2 = new Dog(cacador1, bosque);
		Dog cachorro3 = new Dog(cacador2, bosque);
		Dog cachorro4 = new Dog(cacador2, bosque);
		Dog cachorro5 = new Dog(cacador3, bosque);
		Dog cachorro6 = new Dog(cacador3, bosque);
		RedDog redDog = new RedDog(bosque);

		ExecutorService exec = Executors.newFixedThreadPool(3);
		ScheduledExecutorService schedExec = Executors.newSingleThreadScheduledExecutor();
		cacador1.setDogs(cachorro1, cachorro2);
		cacador2.setDogs(cachorro3, cachorro4);
		cacador3.setDogs(cachorro5, cachorro6);

		dogsThread.add(cachorro1);
		dogsThread.add(cachorro2);
		dogsThread.add(cachorro3);
		dogsThread.add(cachorro4);
		dogsThread.add(cachorro5);
		dogsThread.add(cachorro6);

		exec.execute(cacador1);
		exec.execute(cacador2);
		exec.execute(cacador3);

		while (cacador1.getTotalCoin() < 50 && cacador2.getTotalCoin() < 50 && cacador3.getTotalCoin() < 50) {
			schedExec.schedule(redDog, timeUnit * 2, TimeUnit.MILLISECONDS);
		}
		schedExec.shutdownNow();
		
		bosque.PrintWinner();
		if (bosque.getWinner() == cacador1) {
			if (cacador2.getTotalCoin() >= cacador3.getTotalCoin()) {
				System.out.println("SEGUNDO LUGAR: " +cacador2.getStringColor()+ ", Moedas: "+cacador2.getTotalCoin());
				System.out.println("TERCEIRO LUGAR: " +cacador3.getStringColor()+ ", Moedas: "+cacador3.getTotalCoin());
			} else {
				System.out.println("SEGUNDO LUGAR: " +cacador3.getStringColor()+ ", Moedas: "+cacador3.getTotalCoin());
				System.out.println("TERCEIRO LUGAR: " +cacador2.getStringColor()+ ", Moedas: "+cacador2.getTotalCoin());
			}
		} else if (bosque.getWinner() == cacador2) {
			if (cacador1.getTotalCoin() >= cacador3.getTotalCoin()) {
				System.out.println("SEGUNDO LUGAR: " +cacador1.getStringColor()+ ", Moedas: "+cacador1.getTotalCoin());
				System.out.println("TERCEIRO LUGAR: " +cacador3.getStringColor()+ ", Moedas: "+cacador3.getTotalCoin());
			} else {
				System.out.println("SEGUNDO LUGAR: " +cacador3.getStringColor()+ ", Moedas: "+cacador3.getTotalCoin());
				System.out.println("TERCEIRO LUGAR: " +cacador1.getStringColor()+ ", Moedas: "+cacador1.getTotalCoin());
			}
		} else {
			if (cacador1.getTotalCoin() >= cacador2.getTotalCoin()) {
				System.out.println("SEGUNDO LUGAR: " +cacador1.getStringColor()+ ", Moedas: "+cacador1.getTotalCoin());
				System.out.println("TERCEIRO LUGAR: " +cacador2.getStringColor()+ ", Moedas: "+cacador2.getTotalCoin());
			} else {
				System.out.println("SEGUNDO LUGAR: " +cacador2.getStringColor()+ ", Moedas: "+cacador2.getTotalCoin());
				System.out.println("TERCEIRO LUGAR: " +cacador1.getStringColor()+ ", Moedas: "+cacador1.getTotalCoin());
			}
		}
		System.exit(0);
	}
}
