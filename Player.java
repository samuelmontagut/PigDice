
public class Player {
	
	private int totalPoints = 0;
	private String name;
	
	public Player(String n) {
		name = n;
	}
	
	public void addPoints(int p) {
		totalPoints = totalPoints + p;
	}
	
	public int pointsGetter() {
		return totalPoints;
	}
	
	public String playerName() {
		return name;
	}
	public String toString() {
		return name + "has " + totalPoints + " total points";
	}

}
