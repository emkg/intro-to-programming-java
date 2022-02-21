
/*
 * 	• If user deposits COST_OF_BAR, vend bar
	• If  user deposits > COST_OF_BAR, vend bar, make change
	• if user deposits < COST_OF_BAR, request more money
	
	when COST_OF_BAR = 1.25
	test success for 1, 1.00, 1.25, 1.50
	test fail for input of 1.30. 
		output for change is 0.05000....44.
	
	what happens when COST_OF_BAR = 1.30?
		computer tells user bar costs $1.3
		I added 0 in the string to make it look better...is that ok?
	
	change money to pennies to make integer
	
	when COST_OF_BAR = 130 or 125
	test success for 1, 1.0, 1., 1.25, 1.35
	
	solved change issue by dividing by 100.0 in if/else statements
	
	Want to make the program ask for more money if user inputs less than COST more than once.
	Want to make the program make change if the user puts more than COST 
		after inputing LESS than cost the first time.
	
 */
import java.util.Scanner;
public class GranolaBarsMachine 
{
	public static void main(String [] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		//declare variables in pennies
		final int COST_OF_BAR = 130;
		int money;
			
		//prompt user
		System.out.println("ENTER $" + COST_OF_BAR/100.0 + "0 FOR GRANOLA...");
		money = (int)(keyboard.nextDouble()*100.0+0.5); //change user inputs to pennies in double
		
		//determine whether user needs just a bar, change, or to enter more money
		if (money < COST_OF_BAR)
		{
			System.out.println("Please insert " + (COST_OF_BAR - money)/100.0 + "...");
		}		
		else if (money == COST_OF_BAR) 
		{
			System.out.println("Enjoy!");
		}
		else
		{
			System.out.println("Your change is $" + (money - COST_OF_BAR)/100.0 + ". Thank you!...");
		}
				
	}
}
