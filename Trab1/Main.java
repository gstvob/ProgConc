package pkg;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
	static final int timeUnit = 100;
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

		while (cacador1.getTotalCoin() < 50 || cacador2.getTotalCoin() < 50 || cacador3.getTotalCoin() < 50) {
			schedExec.schedule(redDog, timeUnit * 2, TimeUnit.MILLISECONDS);
		}
		exec.shutdownNow();
		schedExec.shutdownNow();
		bosque.PrintOutWinner();
		System.exit(0);
	}
}
