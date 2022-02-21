import java.io.*;

/**Play a game of Frogger!
 * 
 * @author Emily
 *
 */
public class Driver 
{
	final static int PAUSE_IN_MILLISECONDS = 1000; // 1/2 second
	
	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception
	{
		InputStreamReader input = new InputStreamReader(System.in);
		
		//create the grid and game objects
		Controller controller = new Controller();
		
		//Display the grid to the player
		//controller.displayGame();
		
		//Show the player the instructions
		System.out.println("Up is W, Down is S, Left is A, Right is D. . .You're the *, and the > will get you. So don't get smashed!");
		
		//Loop will exit upon the user losing (getting smashed)
		while(true)
		{
			//Player can move the frog on the grid
			controller.moveFrog(input);
			
			if(controller.frogOutOfBounds())
			{
				System.out.println("GAME OVER!");
				System.exit(1);
			}
			
			//Determines if the frog has won 
			if (controller.frogWins())
			{
				controller.displayGame(); // ?
				System.out.println("You win!");
				System.exit(1);
			}
			
			//see if a truck smashed the frog
			if (controller.frogAndTrucksCollide())
			{
				System.out.println("GAME OVER X|");
				System.exit(1);
			}
			
			//move the trucks? why now?
			controller.moveTrucks();
			
			//see if a truck smashed the frog
			if (controller.frogAndTrucksCollide())
			{
				System.out.println("GAME OVER X|");
				System.exit(1);
			}
			
			//If the user hasn't won or lost yet, keep going
			controller.displayGame();
			
			//show instructions again
			System.out.println("Up is W, Down is S, Left is A, Right is D.");
			
			//pause for less than a second to let the player think
			Thread.sleep(PAUSE_IN_MILLISECONDS);
		} //end while loop
		
	} // end of main
}
