/*
 * allows an advertiser to select from a list of known valid email addresses based on user age
 *  
 * enter the desired age range (minimum to maximum, inclusive), 
 * and then print out the email address of everyone who is in that age range
 * 
 * read data from a file called “Demographics.txt”, stored in the project directory of eclipse that contains data in the following format:
 * email-address age
 *
 *
 *
 *main
 *  
 * create file
 * what is your target audience? Tell us their age range.
 * Lowest age in the range:
 * Highest age in the range:
 * 
 * 
 * method
 * read from a demographics.txt file 
 * read ints into an arraylist object*
 * 
 * method 2?
 * 
 *
 *
 *   minnieMouse@disney.org 75
 *   mickeyMouse@disney.org 78 
 *   goofy@disney.org 50
 *
 *
 *
 */
import java.util.*;
import java.io.*;

public class SampleMidterm2 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		
		Scanner file = new Scanner(new File("Demographics.txt"));
		Scanner keyboard = new Scanner(System.in);
		
		
		System.out.println("");
		int min = keyboard.nextInt();
		System.out.println("");
		int max = keyboard.nextInt();
		
		ArrayList<String> email = findEmails(file, min, max);
		
		System.out.println("These are the emails you are looking for:");
		for (int i=0; i<email.size(); i++)
		{
			System.out.println(email.get(i));
		}
		
		file.close();
		keyboard.close();
				
	}

	public static ArrayList<String> findEmails(Scanner input, int minAge, int maxAge)
	{
		
		//create an ArrayList
		ArrayList<String> result = new ArrayList<String>();
		
		//Scan the file for minAge and maxAge within a range
		while (input.hasNextLine())
		{
		String email = input.next();
		int age = input.nextInt();
			//include emails associated with the target ages in the ArrayList
			if (age >= minAge && age <= maxAge)
			{
				result.add(email);
			}
		input.nextLine(); // get rid of newline character?
		}
		
		return result; //result is a list of emails in the target range
	}

}
