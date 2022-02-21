/*
Foo Corporation needs a program to calculate how much to pay their hourly employees. 
The US Department of Labor requires that employees get paid time and a half for any 
hours over 40 that they work in a single week. For example, 

if an employee works 45 hours, 
	they get 5 hours of overtime, at 1.5 times their base pay. 

The State of Massachusetts requires that hourly employees be paid at least $8.00 an hour. 
Foo Corp requires that an employee not work more than 60 hours in a week. 

An employee gets paid (hours worked) × (base pay), for each hour up to 40 hours. 

For every hour over 40, they get overtime = (base pay) × 1.5. 

The base pay must not be less than the minimum wage ($8.00 an hour). 
If it is, print an error. 

If the number of hours is greater than 60, print an error message. 

Create a new class called FooCorporation. 

Write a method that takes the base pay and hours worked as parameters 
and prints the total pay or an error. Write a main method that calls 
this method for each of these employees: 
						Base Pay       Hours Worked 
		Employee 1 		$7.50 				35 
		Employee 2 		$8.20 				47 
		Employee 3 		$10.00 				73 
		
 
Good luck.
*/
public class FooCorporation 
{
	/**
	 * calculates the total pay per employee for one week.
	 * 
	 * @param wage The hourly rate of pay for the employee
	 * @param hours The number of hours the employee worked in one week.
	 */
	public static double payCheck(double wage, int hours)
	{
		double totalPay = wage * hours;
		if (hours > 40 && hours < 60)
		{
			int overtime = hours - 40;
			totalPay+= overtime * 1.5; 
			return totalPay;
		}
		else if (hours > 60)
			System.out.println("Hours worked exceeds company policy.");
					//+ "There is a problem calculating total pay.");
		if (wage < 8.00)
			System.out.println("Hourly wage violates state law.");
					//+ "There is a problem calculating total pay");
		
		return totalPay;
	}
	
	public static void main(String [] args)
	{
		double emp1Wage = 7.50;
		int emp1Hours = 35;
		
		double emp1Payment = payCheck(emp1Wage, emp1Hours);
		
		System.out.println("Employee 1 total pay is: $" + emp1Payment + ".");
		
		double emp2Wage = 8.20;
		int emp2Hours = 47;
		
		double emp2Payment = payCheck(emp2Wage, emp2Hours);
		
		System.out.println("Employee 2 total pay is: $" + emp2Payment + ".");
		
		double emp3Wage = 10.00;
		int emp3Hours = 73;
		
		double emp3Payment = payCheck(emp3Wage, emp3Hours);
		
		System.out.println("Employee 3 total pay is: $" + emp3Payment + ".");
	}
	
}