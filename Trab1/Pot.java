package pkg;
import java.util.ArrayList;

public class Pot {
	
	private int coins;
	private boolean isBeingUsed = false;
	private ArrayList<Pot> possiblePaths = new ArrayList<Pot>();
	private ArrayList<Dog> sleepingDogs = new ArrayList<Dog>();
	
	public Pot() {
		coins = 4;
	}
	
	//Operações relacionada com as moedas do pote.
	public int getCoins() {
		return coins;
	}
	public void setCoins(int value) {
		coins = value;
	}
	
	//Operações relacionadas com o pote em si.
	public boolean IsBeingUsed() {
		return isBeingUsed;
	}
	public void setUsed(boolean _value) {
		isBeingUsed = _value;
	}
	public void setPossiblePaths(Pot e) {
		possiblePaths.add(e);
	}
	public Pot randomPot() {
		return possiblePaths.get((int) (Math.random()*possiblePaths.size()));
	}
	
	//Operações relacionadas com os cachorros que estão dormindo no pote.
	public void AddSleepingDog(Dog e) {
		sleepingDogs.add(e);
	}
	public void WakeDog(Dog e) {
		sleepingDogs.remove(e);
	}
	public int SleepingDogAmmount() {
		return sleepingDogs.size();
	}
	public Dog getSleepingDogAt(int _index) {
		return sleepingDogs.get(_index);
	}
	public boolean isEmpty() {
		return sleepingDogs.isEmpty();
	}
}