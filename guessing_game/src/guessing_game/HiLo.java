
package guessing_game;
import java.util.Scanner;

public class HiLo {

	public static void main(String[] args) {
		// 
		Scanner scan = new Scanner(System.in);
		
		//play again variable
		String playAgain = "";
		
		//game loop
		
		do {
		
			//create rundom number
			int rNum = (int)(Math.random()*100 + 1);
			System.out.println(rNum);
			
			int guess = 0;
			System.out.println("Guess a number");
			
			while (guess != rNum ) {
							
				// get the user guess
				guess = scan.nextInt();
				if(guess < rNum) 
					System.out.println("Too low, guess again");
				
				else if(guess > rNum) 
					System.out.println("Too high, guess again");
				
				else 
					System.out.println("Correct!");
				
			}
			System.out.println("Would you like to play again");
			playAgain = scan.next();
		} while(playAgain.equalsIgnoreCase("Y"));
		
		System.out.println("Thanks for playing");
	}
}
