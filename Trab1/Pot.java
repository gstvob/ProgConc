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
	public int getCoins() {
		return coins;
	}
	public void setCoins(int value) {
		coins = value;
	}
	public void setPossiblePaths(Pot e) {
		possiblePaths.add(e);
	}
	public int CatchCoin() {
		if (coins <= 0) {
			return 0;
		} else if (coins == 1){
			coins -= 1;
			return 1;
		} else {
			coins -= 3;
			return 3;
		}
	}
	public boolean IsBeingUsed() {
		return isBeingUsed;
	}
	public void setUsed(boolean _value) {
		isBeingUsed = _value;
	}
	public Pot randomPot() {
		return possiblePaths.get((int) (Math.random()*possiblePaths.size()));
	}
	public boolean isEmpty() {
		return sleepingDogs.isEmpty();
	}
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
}