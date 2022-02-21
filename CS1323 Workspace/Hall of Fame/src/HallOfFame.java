import java.lang.*;
import java.util.*;


public class HallOfFame 
{
	final static int SIZE = 5; //how many names should be in the hall of fame?
	final static int GAMES = 10;
	
	public static void main (String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		String playerName = "";
		//Set up of arrays and initialization of data
		String[] winnersNames = new String[SIZE];
		int[] highScores = new int[SIZE];
		
		for (int i = 0; i < highScores.length; i++)
		{
			highScores[i] = -i-1;
			winnersNames[i] = "";
		}
		
		//play the game to populate hall of fame
		for (int j = 0; j < GAMES; j++)
		{
			System.out.println("Please enter your name, player...");
			playerName = keyboard.nextLine();
			int score = playGame();
			addToHallOfFame(playerName, score, highScores, winnersNames);
			System.out.println(playerName + " scored " + score + "!");
			System.out.println();
			showHallOfFame(winnersNames, highScores);
			System.out.println();
			System.out.println();//easier to read output with spaces added
		}
				
	}
	
	public static void showHallOfFame(String[] names, int[]highScores)
	{
		System.out.println("HALL OF FAME");
		for (int i = 0; i < highScores.length; i++)
		{
			if(highScores[i] > 0)
				System.out.println("" + (i + 1) + ": " + names[i] + " scored " + highScores[i] + "!");
		}
	}

	public static boolean addToHallOfFame(String playerName, int score, int[] highScores, String[] names)
	{
		int index = highScores.length-1;
		
		boolean hallOfFame = false;
		
		while (index >= 0)
		{   
			//check to see if current player belongs in the hall of fame
			if (score > highScores[index])
			{
				hallOfFame = true;
				//if we are not at the end of the array
				if(index < highScores.length-1)
				{
					highScores[index + 1] = highScores[index];
					names[index + 1] = names[index];
				}
				highScores[index] = score;
				names[index] = playerName;
				
			}
			
			index--;
		}
		
		return hallOfFame;
	}
	
	public static int playGame()
	{
		final int HIGH_SCORE = 10000;
		return (int)(Math.random()*HIGH_SCORE);
	}
}

