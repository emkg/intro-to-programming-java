/*
 * something is wrong with this search thing because if my array size is 1 if I go back I get a null reference exception. Not sure why yet.
 */


import java.util.*;
import java.io.*;


public class RefinedSearch 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner keyboard = new Scanner(System.in);
		String fileName;		
 		//This could be put in a loop to allow multiple files to be searched
		
		System.out.println("Please enter the name of the file");
		fileName = keyboard.nextLine();
		
		ArrayList<String> data;  // Notice--no constructor call here--constructed in method
		data = readDataFromFile(fileName);
		
		performSearchRefinement(data, keyboard);
	
	}

	
	public static ArrayList<String> readDataFromFile(String fileName) throws FileNotFoundException
	{
		ArrayList<String> result = new ArrayList<String>();
		Scanner file = new Scanner(new File(fileName));

		// Read the file one line at a time and transfer the data to the newly constructed ArrayList
		
		while (file.hasNextLine())
		{
			String line = file.nextLine();
			result.add(line);
		}
		
		file.close();
		return result;
	}
	
	/*
	 * Adds elements from source that contain the target string to a newly constructed array.
	 * Returns a newly constructed object that only contains the target.
	 * 
	 * @param source May or may not contain target
	 * @param target A value to be sought
	 * 
	 * @return A newly constructed object of Strings that contain the target.
	 */
	
	public static ArrayList<String> search(ArrayList<String> source, String target)
	{
		ArrayList<String> results = new ArrayList<String>();
		
		for(String s: source)
		{
			if (s.contains(target))
			{
				results.add(s);
			}
		}
		return results;
	}
	
	public static void showResult(ArrayList<String> data)
	{
		if(data.size() == 0)
		{
			System.out.println("There are no results to display. . .");
			return;
		}
		
		//for-each loop! neat!
		for (String s: data)
		{
			System.out.println(s);
		}
	
	}

	public static void performSearchRefinement(ArrayList<String> data, Scanner keyboard)
	{
		final int SIZE = 10;
		
		ArrayList<String>[] previousSearches = new ArrayList[SIZE];
		int size = 0; //keeping track of size of array
		
		String answer = "YES";
		
		do
		{
			System.out.println("Enter the String you are searching for, or back to return to previous results.");
			answer = keyboard.nextLine();
			
			if(!answer.equalsIgnoreCase("back"))//refining search
			{
				if (size < SIZE) // if there is space in the array
				{
					previousSearches[size] = data;
					size ++;
				}
				else //array is full
				{
					System.out.println("Backup is disabled because the search is too large.");
				}
				
				data = search(data, answer);
				showResult(data);
				size++;
				
			}
			else // going back
			{
				if(size >= 1)
				{
					data = previousSearches[size-1];
					previousSearches[size-1] = null; //prevents garbage array
					size--;
					showResult(data);
				}
				else
				{
					System.out.println("There is no information to go back to...");
				}
				
			}//end else
			
			System.out.println("Would you like to continue? Yes or no...");
			answer = keyboard.nextLine();
			
			
			if(answer.equalsIgnoreCase("NO"))
			{
				System.out.println("Ok, this was fun though. Let's do it again sometime...");
				return;
			}
			else if(!answer.equalsIgnoreCase("YES"))
			{
				System.out.println("Sorry, does that mean yes or no...?");
				answer = keyboard.nextLine();
			} //end while
					
		}while (answer.equalsIgnoreCase("YES")); //end do-while 
		
		
	}//end performSearchRefinement
	
}//end class
