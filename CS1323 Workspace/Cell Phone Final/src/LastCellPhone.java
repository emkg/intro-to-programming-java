/*
 *This program is identical to FiveCellPhonePlans except a second additional method allows users to correct negative inputs for double types.
 *Also, the calculation of total cost is a method as well 
 *
 * */


import java.util.Scanner;

public class LastCellPhone 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		//Decided to store money in pennies because pennies are indivisible
		int planMinutes = 0;
		int monthlyCostPennies = 0;
		int additionalMinutesPennies = 0;
		String planName = "";
		int talkMinutes = 0;
		
			
		//Get input from user
		System.out.println("Please enter the number of minutes you talk each month.");
		talkMinutes = getPositiveInt(keyboard);
		keyboard.nextLine(); // read in the newline at the end of the integer
							
		double smallestPlanCostPennies = 1000000000.0; //arbitrarily big number
		String cheapestPlanName = ""; 
				
		//Read in variables from command line
		System.out.println("Please tell me the name of the cell phone plan.");
		planName = keyboard.nextLine();
		
		do
		{
		System.out.println("Please enter the plan's monthly cost.");
		monthlyCostPennies = (int)(getPositiveDouble(keyboard) * 100.0 + 0.5);
		keyboard.nextLine(); // read in the newline at the end of the integer
			
		System.out.println("Please enter the plan minutes.");
		planMinutes = getPositiveInt(keyboard);
		keyboard.nextLine(); // read in the newline at the end of the integer
			
		System.out.println("Praytell, what does this plan charge for each additional minute?");
		additionalMinutesPennies = (int)(getPositiveDouble(keyboard) * 100.0 + 0.5);
		keyboard.nextLine(); // read in the newline at the end of the integer
		
		int totalCostPennies = getPlanCostPennies(talkMinutes, planMinutes, monthlyCostPennies, additionalMinutesPennies);		
		System.out.println("The total cost for the " + planName + " plan is $" + totalCostPennies/100.0);
		
		//determines cheapest plan
		if (totalCostPennies < smallestPlanCostPennies)
		{
			smallestPlanCostPennies = totalCostPennies;
			cheapestPlanName = planName;
		}
		
		System.out.println("");
		
		keyboard.nextLine();
		
		//asks user if s/he has more plans to look at
		System.out.println("If you have more plans to compare, please enter the name of the next plan now. "
							+ "Otherwise, enter END to get results.");
		
		planName = keyboard.nextLine();
		}while (!planName.equalsIgnoreCase("END"));
			
		if (planName.equalsIgnoreCase("END"))
		{
			System.out.println("");
			System.out.println("The least expensive plan of these is " + cheapestPlanName + ".");
			System.out.println("And it is only gonna cost you $" + smallestPlanCostPennies/100.0 + ".");
			System.out.println("Voila! Have a nice day...");
		} //end if END
		
	}//end method 1
 
		
	public static double getPositiveDouble(Scanner input)
	{
		double result = -1.0;
		while (result <= 0.0)
		{
			result = input.nextDouble();
			if (result <= 0.0)
			{
				System.out.println("Please enter a value greater than zero.");
			}
		}
		
		return result;
	}//end method 2
	
	public static int getPositiveInt(Scanner input)
	{
		int result = -1;
		while (result <= 0)
		{
			result = input.nextInt();
			if (result <= 0)
			{
				System.out.println("Please enter a value greater than zero.");
			}
		}
		
		return result;
	}//end method 3
	
	public static int getPlanCostPennies(int talkMinutes, int planMinutes, int monthlyCostPennies, int additionalMinutesPennies)
	{
		int totalCostPennies;
		
		//calculates the total cost and tells user for each plan
		if (talkMinutes > planMinutes)
		{
			totalCostPennies = monthlyCostPennies + additionalMinutesPennies * (talkMinutes - planMinutes);
		} // end if talkMinutes
		else
		{
			totalCostPennies = monthlyCostPennies; 
		} //end else from if talkMinutes
											
		return totalCostPennies;
	} //end method 4
	
} // end of LastCellPhone Class
