/*
 * In the upper section, each box is scored by summing the total number of dice faces matching that box. 
 * For example, if a player were to roll three "twos," the score would be recorded as 6 in the twos box. 
 * If a player scores a total of at least 63 points in these boxes, a bonus of 35 points is added to the 
 * upper section score. Though 63 points corresponds to three-of-a-kind for each of the six dice faces, 
 * a common way to get the bonus is rolling four (or five, often using a "Yahtzee as a joker") of a 
 * larger number so that fewer of the smaller numbers are needed (a player can earn the bonus even if he 
 * or she scores a "0" in an upper section box).
 * 
 * Category	        Description     	                                    Score	              
 * Three-Of-A-Kind	At least three dice showing the same face	           Sum of all dice	
 * Four-Of-A-Kind	At least four dice showing the same face	           Sum of all dice	
 * Full House	    A three-of-a-kind and a pair	                         25	
 * Small Straight	Four sequential dice (1-2-3-4, 2-3-4-5, or 3-4-5-6)	     30	
 * Large Straight	Five sequential dice (1-2-3-4-5 or 2-3-4-5-6)            40 
 * Yahtzee	        All five dice showing the same face                      50 - First Yahtzee only	
 * 
 * Chance	        Any combination-- often acts as discard box for a turn 
 *                  that will not fit in another category (thus the name), 
 *                  although during a lucky game it can be used to record 
 *                  a high score.	                                        Sum of all dice	
 *                  
 *                  
 * roll 5 dice up to 3 times
 */


import java.util.*;

public class UpperYazi 
{
	static final int TURNS = 6;
	static final int DICE = 5;
	
	public static void main(String[]args)
	{
		Scanner keyboard = new Scanner(System.in);
		String namePlayer1;
		String namePlayer2;
		
		System.out.println("Enter the first player's name.");
		namePlayer1 = keyboard.nextLine();
		System.out.println("Enter the second player's name.");
		namePlayer2 = keyboard.nextLine();
		
		int[] playerOneScores = new int[TURNS]; //create two score cards with TURNS possible scores, includes totals of upper and lower
		int[] playerTwoScores = new int[TURNS];
		
		keyboard.close();
	}
}
	
	
