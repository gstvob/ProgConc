package pkg;
import java.util.ArrayList;

public class Pot {
	
	private int coins;
	private ArrayList<Pot> possiblePaths = new ArrayList<Pot>();
	private ArrayList<Dog> groundedDogs = new ArrayList<Dog>();
	
	public Pot() {
		coins = 4;
	}
	public int getCoins() {
		return coins;
	}
	public void setPossiblePaths(Pot e) {
		possiblePaths.add(e);
	}
	public int CatchCoin() {
		if (coins == 0) {
			return 0;
		} else if (coins - 3 < 0) {
			coins = 0;
			return 1;
		} else {
			coins -= 3;
			return 3;
		}
	}
	public Pot randomPot() {
		return possiblePaths.get((int) (Math.random()*possiblePaths.size()));
	}
	public void AddGroundedDog(Dog e) {
		groundedDogs.add(e);
	}
}
