/* An extension of the ImprovedUpperYazi which adds the lower half of the score card to the game.
 * It also allows for two more players to play. 
 * 
 * @author Emily Kathryn Grimes
 * @version 1.0
 */

import java.util.*;

public class LowerYazi extends ImprovedUpperYazi
{
	
	
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		//determine number of players
		System.out.println("How many will be playing today?");
		int numPlayers = keyboard.nextInt();
		
		//collect player's names
		//generate player's score cards
		String[] playerName = new String[numPlayers];
		for(int i = 1; i <= numPlayers; i++)
		{
			System.out.println("Please enter your name, player number " + (i) + ". . .");
			playerName[i-1] = keyboard.next();
			//how can i clearly create new variables for each loop?
			//int [] player_i_score = createPlayerScoreCard(playerName[i-1]);
			//System.out.println(player_i_score);
		}
		
		
		
		keyboard.close();
		//or should I make an unlimited number of players?
	}
	
	
	
	/* Creates a blank integer array that represents the score card for the player
	 * each time a player is added to the game at the start of play.
	 * 
	 * @param name A String that represents the player's name.
	 * @return blankScoreCard An integer array with each cell in it set to negative one. 
	 * 
	 */
	public static int[] createPlayerScoreCard(String name)
	{
		int[] blankScoreCard = new int[13];
		
		//set each cell in the score card to -1, since zero is a legal score
		//essentially flags each cell as unused
		for(int i = 0; i < 13; ++i)
		{
			blankScoreCard[i] = -1;
		}
		
		return blankScoreCard;
	}
	
	//scores 3 of a kind -- sum of dice
	
	//scores 4 of a kind -- sum of dice
	
	//scores a full house -- 25 points
	
	//scores a small straight -- 30 points
	 
	//scores a large straight -- 40 points
	
	//scores a yazi! -- 50 points
	
	//gives a bonus to an upper score of 63 -- 35 points
	
}
