import java.util.Scanner;
import java.util.Arrays;

public class UpperYazi 
{
	static final int TURNS = 6;
	static final int DICE = 5;
	static int[] dice = new int[DICE];
	static int[] playerOneScores = new int[TURNS]; //create two score cards with TURNS possible scores, includes totals of upper and lower
	static int[] playerTwoScores = new int[TURNS];
	static int suitNumber;
	
/* Allows two users to play a version of yazi that only includes the top half of the score for a regular game.
 * 
 * Each turn is scored by the sum of the suit of the 5 dice that occurs the most.
 * 
 * Each turn has three rolls.
 * Each roll, the player chooses which dice to keep and which to roll again.
 * 
 * At the end of the turn, the score is the sum of the single suit that appears most.
 * 
 *If a player scores a total of at least 63 points in these boxes, 
 *a bonus of 35 points is added to the total score.  
 *
 */
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		String namePlayer1;
		String namePlayer2;
		
		System.out.println("Enter the first player's name.");
		namePlayer1 = keyboard.nextLine();
		System.out.println("Enter the second player's name.");
		namePlayer2 = keyboard.nextLine();
		
		Arrays.fill(playerOneScores, -1); //the negative one tells us that a score has not been tallied
		Arrays.fill(playerTwoScores, -1);
		
		playOneGame(namePlayer1, playerOneScores, namePlayer2, playerTwoScores, keyboard);
		
		keyboard.close();
	}
	
	/* Play one turn of the game
	 * 
	 * @param dice A static array of integers that randomly shuffle between the numbers 1 and 6
	 * @param score A static array of intgers which hold the scores of each player
	 * @param keyboard A scanner that is attached to the keyboard
	 * @param name A String that is taken from the user as the player's name
	 * 
	 * @return sumOfDice An integer that equals the player's score at the end of a turn
	 */
	public static int playOneTurn(int[] dice, int[] score, Scanner keyboard, String name)
	{
		
		System.out.println(name + ", it's your turn. . .");
		System.out.println(); //spacing for the output; makes it easier to read
		System.out.println("First roll. . .");
		System.out.println();
				
		rollDice(dice);
		showDice(dice);
		
		System.out.println();
		System.out.println("For Roll 2, which suit would you like to play for,"
				+ " 1, 2, 3, 4, 5, or 6?");
		suitNumber = keyboard.nextInt();
		
		
		//also need to correct boundaries
		//could this also be a method?
		while (score[suitNumber-1] != -1) //enforces scoring one of each suit per game
		{
			System.out.println("You can't rescore a suit...");
			System.out.println("Please choose a suit you haven't chosen yet...");
			suitNumber = keyboard.nextInt();
		}
		
		System.out.println();
		rollDiceAgain(dice, suitNumber);
		showDice(dice);
		System.out.println();
				
		System.out.println("For your third roll, "
					+ "which suit would you like to play for, 1, 2, 3, 4, 5, or 6?");
		suitNumber = keyboard.nextInt();
		
		System.out.println();
		rollDiceAgain(dice, suitNumber);
		showDice(dice);
		System.out.println();
				
		System.out.println("Your score is " + sumOfDice(dice, suitNumber) + "!");
		return sumOfDice(dice, suitNumber);
	}
	
	/* Gets the static integer stored for each turn of the game. Determines what suit of the dice was scored
	 * in a previous turn so that the same suit cannot be scored twice for one user in a game.
	 * 
	 * @param There are no command line arguments
	 * @return suitNumber An integer that is static but which changes after every turn is played.
	 */
	public static int getSuitNumber()
	{
		return suitNumber;
	}
	
	/* Plays a whole game with two players. There is no advantage to playing first or second.
	 * 
	 * @param name1 A String that is taken from the user to be the first player's name
	 * @param name1Score An integer array that stores the first player's scores
	 * @param name2 A String that is taken from the user to be the second player's name
	 * @param name2Score An integer array that stores the second player's scores
	 * @param keyboard A Scanner that is attached to the keyboard
	 */
	public static void playOneGame(String name1, int[] name1Score, String name2, int[] name2Score, Scanner keyboard)
	{
		int sumDice;
		for(int i = 0; i < TURNS; i++)
		{
			//System.out.println(name1 + ", your score so far is: " + showScore(playerOneScores) + ".");
			showScore(name1Score, name1);
			sumDice = playOneTurn(dice, name1Score, keyboard, name1);
			Arrays.fill(name1Score, (getSuitNumber()-1), getSuitNumber(), sumDice);
			showScore(name1Score, name1);
			
			showScore(name2Score, name2);
			sumDice = playOneTurn(dice, name2Score, keyboard, name2);
			Arrays.fill(name2Score, (getSuitNumber()-1), getSuitNumber(), sumDice);
			showScore(name2Score, name2);
		}
		//should this be a declare winner method?
		int score1 = calculateTotalScore(name1Score);
		int score2 = calculateTotalScore(name2Score);
		
		if (score1 > score2)
			System.out.println(name1 + " wins!");
		else if (score2 > score1)
			System.out.println(name1 + " wins!");
		else if (score1 == score2)
			System.out.println("Wow, it's a tie! That's statistically improbable! Neat!");
	}
	
	/* Shows the user, specifically by name, her or his current score card,
	 * tells the user which die suits have not yet been scored, and provides a total score so far.
	 * 
	 * @param score An integer array of the user's scores
	 * @param name A String that equals the user's name
	 */
	public static void showScore(int[] score, String name)
	{
		for(int i = 0; i < score.length; i++)
		{
			if (score[i] != -1)
				System.out.println("Score of " + (i+1) + "s: " + score[i]);
			else
				System.out.println("The score of " + (i+1) + " has not been used yet.");
		}
		
		System.out.println(name + ", your total score so far is " + calculateTotalScore(score));
	}
	
	/* Shows the values of each integer in the dice array which are randomly generated from 1 to 6, inclusive
	 *
	 * @param dice A static integer array of a size set by the static final value DICE
	 */
	public static void showDice(int[] dice)
	{
		for (int i = 0; i < DICE; i++)
		{
			//unit indexing the dice for the user
			System.out.println("Die #" + (i+1) + " = " + dice[i]);
		}
	}
	
	/* Adds up the scores stored in each cell of the player's score array. A score of -1
	 * is never included. A score of -1 means that the suit has not yet been scored. It is 
	 * essentially a zero in terms of the score card.
	 * 
	 * @param score An integer array that stores the user's scores
	 *  
	 */
	public static int calculateTotalScore(int[] score)
	{
		int sum = 0;
		
		//adds all the scores that are not -1. Scores of -1 indicate no score has been made in that index.
		for (int i = 0; i < score.length; i++)
		{
			if (score[i] != -1)
			{
				sum = sum + score[i];
			}//end if
		}//end for
		
		return sum;
	}
	
	/* Rolls the dice once a suit has been chosen. The dice that equal the chosen suit will not be
	 * rolled so the player can keep the dice she likes.
	 * 
	 * @param dice A static integer array of randomly generated numbers between 1 and 6 of a fixed size, or
	 * 				number of dice
	 * @param suitNumber The number on the dice that the player wishes to keep in order to score that suit
	 */
	public static void rollDiceAgain (int[] dice, int suitNumber)
	{
		for(int i=0; i<dice.length; i++)
		{
			if (dice[i] != suitNumber)
				dice[i] = (int)(Math.random()*6.0) + 1;
		}	
	}
	
	/* Rolls the dice--generates random whole numbers between 1 and 6 for each cell of the static
	 * integer array called dice.
	 * 
	 * @param dice The static integer array of fixed size that represents the dice in the game
	 *  
	 */
	public static void rollDice(int[] dice)
	{
		//fills the dice array with random dice suits
		for(int i=0; i<dice.length; i++)
		{
			dice[i] = (int)(Math.random()*6.0) + 1;
		}	
	}
	
	/* Adds the dice of the chosen suit number in order to generate the user's score for one turn.
	 * 
	 * @param dice The static integer array of fixed size that represents the dice in the game
	 * @param suitNumber The number on the dice that the player wishes to keep in order to score that suit
	 * 
	 * @return sum The sum of the dice that equal the suitNumber
	 */
	public static int sumOfDice(int[] dice, int suitNumber)
	{
		int sum = 0;
		//only adds the dice that match the chosen suit
		for (int i=0; i < dice.length; i++)
		{
			if (dice[i] == suitNumber)
			{
				sum = sum + dice[i];
			}
		}
		
		return sum;
	}
	
}
