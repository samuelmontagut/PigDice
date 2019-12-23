import java.util.*;
import java.util.concurrent.TimeUnit;

public class PigDiceGame {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Dice die1 = new Dice();
		Dice die2 = new Dice();
		
		System.out.println("Would you like to play Pig Dice? Y/N");
		char playing = scan.next().charAt(0);
		if (playing == 'y' || playing == 'Y') {
			System.out.println("OK good, you'll have a lot of fun.");
			System.out.println("Would you like to hear the rules of Pig Dice? Y/N");
			char rules = scan.next().charAt(0);
			if (rules == 'y' || rules == 'Y') {
				System.out.println("Players start with 0 points\r\n" + 
						"·         A player rolls two six sided dice. After each roll, the player may choose to roll again or pass the turn\r\n" + 
						"·         If neither die shows a 1, their sum is added to the round score.\r\n" + 
						"·         If exactly one die shows a 1, the player scores nothing, their round total is lost, and their turn ends.\r\n" + 
						"·         If double 1s are rolled, the player’s total score is lost, and their turn ends.\r\n" + 
						"·         If a player passes the round score is added to their total score, and the next player takes their turn.\r\n" + 
						"·         The game ends when a player reaches 100 total points.");
				System.out.println("");
			}
			System.out.println("Type in your name: ");
			String playerName = scan.next();
			Player player1 = new Player(playerName);
			Player computer = new Player("Computer");
			System.out.println("Ok, " + player1.playerName() + ", We will roll a die, it it lands on 1,2, or 3 I'll start otherwise you can go fisrt");
			die1.roll();
			System.out.println(die1.getNumber() + "\n");
			if (die1.getNumber() <= 3) {
				System.out.println("OK, I'll go first\n");
				while (player1.pointsGetter() < 100 && computer.pointsGetter() < 100) {
					int computeRound = 0;
					int playeRound = 0;
					int points = 0;
					boolean computerDone = false;
					boolean playerDone = false;
					while (computeRound < 20 && computerDone == false ) {
						die2.roll();
						die1.roll();
						System.out.println("Die one: " + die1.getNumber() + "\nDie two: " + die2.getNumber());
						points = die2.getNumber() + die1.getNumber();
						if (die2.getNumber() == 1 && die1.getNumber() != 1 || die1.getNumber() ==1 && die2.getNumber() != 1) {
							computerDone = true;
							computeRound = 0;
							System.out.println("I rolled a  one, so my turn is over");
							
							
						}
						else if (die2.getNumber() == 1 && die1.getNumber() == 1) {
							computer.addPoints(-(computer.pointsGetter()));
							computerDone = true;
							computeRound = 0;
							System.out.println("I rolled a double one, so my turn is over and I lose all points in the round.\n");
						}
						else {
							computeRound = computeRound + points;
							System.out.println("The number of points in my round is: " + computeRound + "\n");
							
						}
						
					}
					computer.addPoints(computeRound);
					System.out.println("My total points is: " + computer.pointsGetter() + "\n");
					System.out.println("");
					while (playerDone == false) {
						System.out.println("Do you wan to roll? Y/N");
						char rolling = scan.next().charAt(0);
						if(rolling == 'y' || rolling == 'Y') {
							die2.roll();
							die1.roll();
							System.out.println("Die one: " + die1.getNumber() + "\nDie two: " + die2.getNumber());
							points = die2.getNumber() + die1.getNumber();
							if ((die2.getNumber() == 1 && die1.getNumber() != 1) || (die1.getNumber() == 1 && die2.getNumber() != 1)) {
								playerDone = true;
								playeRound = 0;
								System.out.println("You rolled a one, so your turn is over and you lose all your points for the round.\n");
								System.out.println("The total number of points yo have is: " + player1.pointsGetter() + "\n");
							}
							else if (die2.getNumber() == 1 && die1.getNumber() == 1) {
								player1.addPoints(-(player1.pointsGetter()));
								playerDone = true;
								playeRound = 0;
								System.out.println("Your rolled a double one, so your turn is over and you lose all points.\n");
								System.out.println("The total number of points yo have is: " + player1.pointsGetter() + "\n");
							}
							else {
								playeRound = playeRound + points;
								System.out.println("The total number of points in the round is: " + playeRound);
							}
						}
						if (rolling == 'n' || rolling == 'N') {
							player1.addPoints(playeRound);
							System.out.println("The total number of points you have is: " + player1.pointsGetter() + "\n");
							playerDone = true;
						}
					}
				}
			}
			else if (die1.getNumber() >= 4) {
				while (player1.pointsGetter() < 100 && computer.pointsGetter() < 100) {
					int computeRound = 0;
					int playeRound = 0;
					int points = 0;
					boolean computerDone = false;
					boolean playerDone = false;
					while (playerDone == false) {
						System.out.println("Do you wan to roll? Y/N");
						char rolling = scan.next().charAt(0);
						if(rolling == 'y' || rolling == 'Y') {
							die2.roll();
							die1.roll();
							System.out.println("Die one: " + die1.getNumber() + "\nDie two: " + die2.getNumber());
							points = die2.getNumber() + die1.getNumber();
							if ((die2.getNumber() == 1 && die1.getNumber() != 1) || (die1.getNumber() == 1 && die2.getNumber() != 1)) {
								playerDone = true;
								playeRound = 0;
								System.out.println("You rolled a one, so your turn is over and you lose all your points for the round.\n");
								System.out.println("The total number of points yo have is: " + player1.pointsGetter() + "\n");
							}
							else if (die2.getNumber() == 1 && die1.getNumber() == 1) {
								player1.addPoints(-(player1.pointsGetter()));
								playerDone = true;
								playeRound = 0;
								System.out.println("Your rolled a double one, so your turn is over and you lose all points.\n");
								System.out.println("The total number of points yo have is: " + player1.pointsGetter() + "\n");
							}
							else {
								playeRound = playeRound + points;
								System.out.println("The total number of points in the round is: " + playeRound);
							}
						}
						if (rolling == 'n' || rolling == 'N') {
							player1.addPoints(playeRound);
							System.out.println("The total number of points yo have is: " + player1.pointsGetter() + "\n");
							playerDone = true;
						}
					}
					while (computeRound < 20 && computerDone == false ) {
						System.out.println("It's my turn.");
						die2.roll();
						die1.roll();
						System.out.println("Die one: " + die1.getNumber() + "\nDie two: " + die2.getNumber());
						points = die2.getNumber() + die1.getNumber();
						if (die2.getNumber() == 1 && die1.getNumber() != 1 || die1.getNumber() ==1 && die2.getNumber() != 1) {
							computerDone = true;
							computeRound = 0;
							System.out.println("I rolled a  one, so my turn is over");
							
							
						}
						else if (die2.getNumber() == 1 && die1.getNumber() == 1) {
							computer.addPoints(-(computer.pointsGetter()));
							computerDone = true;
							computeRound = 0;
							System.out.println("I rolled a double one, so my turn is over and I lose all points in the round\n.");
						}
						else {
							computeRound = computeRound + points;
							System.out.println("The total number of points in the round is: " + computeRound);
							
						}
						
					}
					computer.addPoints(computeRound);
					System.out.println("My total points is: " + computer.pointsGetter() + "\n");
					System.out.println("");
					
				}
				if(player1.pointsGetter() >= 100) {
					System.out.println("\nYou're the winner");
				}
				else {
					System.out.println("I beat you!!!");
				}
			}
			
			
		}
		

	}

}
