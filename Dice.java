import java.util.*;

public class Dice {
	
	Random rand = new Random();
	private int number;
	
	public Dice() {
		
	}
	
	public void roll() {
		number = rand.nextInt(6) +1 ;
	}
	
	public int getNumber() {
		return number;
	}

}
