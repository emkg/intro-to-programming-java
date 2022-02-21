
import java.util.Scanner;
public class CellPhone 
{
	
	public static void main(String [] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		//Decided to store money in pennies because pennies are indivisible
		int planMinutes;
		int monthlyCostPennies;
		int additionalMinutesPennies;
		String planName;
		
		//defines variables for Super Saver plan
		planMinutes = 500;
		monthlyCostPennies = 3999;
		additionalMinutesPennies = 5;
		
		planName = "Super Saver";

		//Get input from user
		int talkMinutes;
		System.out.println("Please enter the number of minutes you talk each month.");
		talkMinutes = keyboard.nextInt();
		
		//allows users to correct negative input
		while (talkMinutes < 0)
		{
			System.out.println("If you really talk so little, then all plans that charge for minutes are a bad deal for you. "
					+ "I cannot compute negative minutes beyond this point.");
			System.out.println("Please enter a postive number of minutes you talk each month.");
			talkMinutes = keyboard.nextInt();
			keyboard.nextLine(); // read in the newline at the end of the integer again and again
		}
		
		int totalCostPenniesSuperSaver;
		
		//calculates the total cost
		if (talkMinutes > planMinutes)
		{
				totalCostPenniesSuperSaver = monthlyCostPennies 
						+ additionalMinutesPennies * (talkMinutes - planMinutes);
		}
		else
		{
				totalCostPenniesSuperSaver = monthlyCostPennies; 
		}
		
		//Tells the user the output
		System.out.println("The total cost for the " + planName + " plan is $" 
				+ totalCostPenniesSuperSaver/100.0);
	
		
		//Redefines variables for Big Talker plan
		planMinutes = 1000;
		monthlyCostPennies = 5999;
		additionalMinutesPennies = 3;
		planName = "Big Talker";
		
		//calculates the total cost
		int totalCostPenniesBigTalker; 
		
		if (talkMinutes > planMinutes)
		{
				totalCostPenniesBigTalker = monthlyCostPennies 
						+ additionalMinutesPennies * (talkMinutes - planMinutes);
		}
		else
		{
				totalCostPenniesBigTalker = monthlyCostPennies; 
		}
		
		//Tells the user the output
		System.out.println("The total cost for the " + planName + " plan is $" 
				+ totalCostPenniesBigTalker/100.0);
		System.out.println("");
		
		//makes a decisions for the user
		if (totalCostPenniesSuperSaver < totalCostPenniesBigTalker)
		{
				System.out.println("You will save more money with the Super Saver plan.");
		}
		else
		{
				System.out.println("You will save more money with the Big Talker plan.");
		}
	}
	
}
