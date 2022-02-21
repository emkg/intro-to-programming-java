/*	• calculate grade
	• five midterms with 100 pts
		drop the lowest
		weight others equally
	• grade structure
		pass = >=70
		  fail = < 70
*/

import java.util.Scanner;

public class MidtermGrades 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		double calculatedGrade = readAndCalculateGrades(input);
		int borderlineBetweenGrades = 70;
		System.out.println("The average grade was " + calculatedGrade);
		
		if (calculatedGrade < (borderlineBetweenGrades - 0.5)) //allows the computer to round up grades of 69.5
		{
			System.out.println("Oy! You failed.");
		}
		else
		{
			System.out.println("You Pass!");
		}
	}
	
	public static  double readAndCalculateGrades(Scanner keyboard)
	{
		int nextMidtermGrade = 0;
		double calculatedGrade = 0.0;
		int lowestMidtermGrade = Integer.MAX_VALUE;
		int count = 0;
		
		while (count < 5)
		{
			System.out.println("Enter the next grade: ");
			nextMidtermGrade = keyboard.nextInt();
			calculatedGrade = calculatedGrade + nextMidtermGrade;
			if (nextMidtermGrade < lowestMidtermGrade)
			{
				lowestMidtermGrade = nextMidtermGrade;
			}
			count++; //prevent infinite loop
		}
		
		calculatedGrade = calculatedGrade - lowestMidtermGrade;
				
		return calculatedGrade/4.0;
	}
	
}


