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
		
		boolean alguemGanhou = false;
		Forest bosque = new Forest();
		ArrayList<Dog> dogsThread= new ArrayList<Dog>();
		
		//boolean finished = false;
		//char winner = 'n';
		
		Hunter cacador1 = new Hunter('b');
		Hunter cacador2 = new Hunter('y');
		Hunter cacador3 = new Hunter('g');
		
		Dog cachorro1 = new Dog(cacador1);
		Dog cachorro2 = new Dog(cacador1);
		Dog cachorro3 = new Dog(cacador2);
		Dog cachorro4 = new Dog(cacador2);
		Dog cachorro5 = new Dog(cacador3);
		Dog cachorro6 = new Dog(cacador3);
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
		
		for (int i = 0; i < dogsThread.size(); i++) {
			dogsThread.get(i).setBosque(bosque);
		}
		
		exec.execute(cachorro1);
		exec.execute(cachorro3);
		exec.execute(cachorro5);
		
		while (alguemGanhou == false) {
			schedExec.schedule(redDog, timeUnit*2, TimeUnit.MILLISECONDS);
		}
		schedExec.shutdown();
	}
}


