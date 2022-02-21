import java.util.Scanner;
public class CrapsMethods 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		int roll;
		String rollAgain;
		
		//Explains the game to the user!
		
		System.out.println("Roll the dice. If they add up to 7 or 11, that's CRAPS, and you lose!"); 
		System.out.println("But if the sum of your dice is 2, 3, or 12, you win!");
		System.out.println("Until you win or lose, we'll keep rolling!");
		System.out.println("");
		System.out.println("");
		System.out.println("Let's roll!");
		System.out.println("");
		
		do
		{
			//declare dice
			int roll1 = rollDie();
			System.out.println("Dice 1 is " + roll1);
					
			int roll2 = rollDie();
			System.out.println("Dice 2 is " + roll2);
			System.out.println("");
			
			roll = roll1 + roll2;
			
			//determine fate
			if (roll == 7 || roll == 11 )
			{
				System.out.println("That's CRAPS.");
			}else if (roll == 2 || roll == 3 || roll == 12)
				{
					System.out.println("Hey, you won!");
				}else
				{
					System.out.println("Keep rolling...!");
					System.out.println("");
				}
		} while (roll == 4 || roll == 5 || roll == 6 || roll == 8 || roll == 9 || roll == 10 );
					//roll1 + roll2 are not win or lose
		
		
		System.out.println("That was fun. Wanna play again? y or n?");
		rollAgain = keyboard.nextLine();
		
		do 
		{
			do
			{
				//declare dice
				int roll1 = rollDie();
				System.out.println("Dice 1 is " + roll1);
						
				int roll2 = rollDie();
				System.out.println("Dice 2 is " + roll2);
				System.out.println("");
				
				roll = roll1 + roll2;
				
				//determine fate
				if (roll == 7 || roll == 11 )
				{
					System.out.println("That's CRAPS.");
				}else if (roll == 2 || roll == 3 || roll == 12)
					{
						System.out.println("Hey, you won!");
					}else
					{
						System.out.println("Keep rolling...!");
						System.out.println("");
					}
			} while (roll == 4 || roll == 5 || roll == 6 || roll == 8 || roll == 9 || roll == 10 );
						//roll1 + roll2 are not win or lose
		}while (rollAgain == "y"); //end second dowhile 
	
	}//end main
	
	public static int rollDie()
	{
		return (int)(Math.random()*6.0) + 1;
	}
}




