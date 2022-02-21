/*
 * 	one credit per month
 *	each book has
 * a title,
 * a length in hours and mins, and
 * a number of credits needed 
 * program should read data for books and choose one that is the best value in terms of minutes per credit
 * it should end on sentinel END
 * 
 */
import java.util.Scanner;
public class LaudibleBestValueChooser 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		//store the method output as a variable
		String bestValueTitle = readAndFindBestValueBook(keyboard);
		
		System.out.println("Your best value book is " + bestValueTitle + ". Happy Listening!");
	}
	
	public static String readAndFindBestValueBook(Scanner input)
	{
		//read input, including title, length, and credits
		//title is on 1 line, and the numbers on a new line
		
		String title;
		int hours;
		int minutes;
		int credits;
		
		//use a priming read--ask the user for data before the loop begins
		//the only way to get sentinels to work properly is to read the data at the bottom of the while loop for the next execution
		
		//Priming reads
		System.out.println("Enter the title of your book. Please only use one line.");
		System.out.println("Now please enter the hours, minutes, and credits--in that order, please."
											 + "Then press return to add more data.");
		
		title = input.nextLine();
		hours = input.nextInt();
		minutes = input.nextInt();
		credits = input.nextInt();
		input.nextLine(); //read in the carriage return at the end of the line
		
		double maximumMinutesPerCredit = (double)((hours * 60 + minutes) / credits);
		String bestValueBookSoFar = title;
				
		do
		{
			
			//calculate value of books
			double minutesPerCredit = (double)((hours * 60 + minutes) / credits);
						
			//determines the name of the best value--most mins per credit
			if (minutesPerCredit > maximumMinutesPerCredit)
			{
				bestValueBookSoFar = title;
				maximumMinutesPerCredit = minutesPerCredit;
			}
						
			//Priming reads
			System.out.println("Enter the title of your book. Enter END to stop.");
			System.out.println("Now please enter the hours, minutes, and credits--in that order, please.");
						
			title = input.nextLine();
			if (!title.equalsIgnoreCase("END"))
			{
				hours = input.nextInt();
				minutes = input.nextInt();
				credits = input.nextInt();
				input.nextLine(); //read in the carriage return at the end of the line
			}
			
			
		}while (!title.equalsIgnoreCase("END"));
				
		return bestValueBookSoFar;
	}
}

