package pkg;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args) {
		
		ArrayList<Dog> dogsThread= new ArrayList<Dog>();
		
		Hunter hunter1 = new Hunter('b');
		Hunter hunter2 = new Hunter('y');
		Hunter hunter3 = new Hunter('g');
		
		Dog dog1 = new Dog(hunter1);
		Dog dog2 = new Dog(hunter1);
		Dog dog3 = new Dog(hunter2);
		Dog dog4 = new Dog(hunter2);
		Dog dog5 = new Dog(hunter3);
		Dog dog6 = new Dog(hunter3);
		
		ExecutorService exec = Executors.newFixedThreadPool(3);
		Forest bosqueza1 = new Forest();
		
		dogsThread.add(dog1);
		dogsThread.add(dog2);
		dogsThread.add(dog3);
		dogsThread.add(dog4);
		dogsThread.add(dog5);
		dogsThread.add(dog6);
		
		for (int i = 0; i < dogsThread.size(); i++) {
			dogsThread.get(i).setBosque(bosqueza1);
		}
		
		exec.execute(dog1);
		exec.execute(dog3);
		exec.execute(dog5);
	}
}
