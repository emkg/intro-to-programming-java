/* Age   
int userAge;
String userName;
final int WEIRD_HR_CONSTANT = 220;
final double LOW_PERCENT = 0.65;
final double HIGH_PERCENT = 0.85;
final double TEN_SECONDS =  10.0/60.0;

subtract your age from 220
target heart rate should == 65 to 85% of 220-userAge
people count their pulse for about 10 seconds
*/

import java.util.Scanner;
public class TargetHeartRate 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		//get user age and name
		int userAge;
		String userName;
		
		System.out.println("Please enter your age.");
		userAge = keyboard.nextInt();
		keyboard.nextLine();
		
		System.out.println("Please enter your name.");
		userName = keyboard.nextLine();
		
		/*
		 * Echo inputs back to user
		 * System.out.println("Hello, " + userName + ".");
		 * System.out.println("You told me that your age is " + userAge 	+ ".");
		 *
		 */
		
		
		//perform calculation of user heart rate min and max
		
		//first define constants
		final int WEIRD_HR_CONSTANT = 220;
		final double LOW_PERCENT = 0.65;
		final double HIGH_PERCENT = 0.85;
		final double TEN_SECONDS =  10.0 / 60.0;
		
		//second defining the variables with calculations in them
		int weirdValue = WEIRD_HR_CONSTANT - userAge;	
		double lowHeartRate = weirdValue * LOW_PERCENT;
		double highHeartRate = weirdValue * HIGH_PERCENT;
		
		int tenSecondLow = (int)(lowHeartRate * TEN_SECONDS + 0.5);
		int tenSecondHigh = (int)(highHeartRate * TEN_SECONDS + 0.5);
			
		
		//show target heart rates to user
		System.out.println("Hi " + userName + ", at your target heart rate, you should count between " 
							+ tenSecondLow + " and " + tenSecondHigh + " pulse beats every ten seconds.");
		
	}
}
