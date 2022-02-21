
import java.io.*;
import java.util.*;


public class BestFriend
{
	public static void main(String[] args) throws FileNotFoundException
	{
		
		String fileName = "MyTextMessages.txt";
		ArrayList<String> emails = readAddressesFromFile(fileName);
		
		String BFF = findMostCommonElement(emails);
		System.out.println("Your BFF is " + BFF);
		
		
	}
	
	public static ArrayList<String> readAddressesFromFile(String fileName) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File(fileName));
		ArrayList<String> result = new ArrayList<String>(0);
		
		while (file.hasNextLine())
		{
			String name = file.nextLine();
			result.add(name);
		}
				
		file.close();
		return result;
	}
	
	public static String findMostCommonElement(ArrayList<String> addresses)
	{
		String previousElement = "";
		int currentCount = 1;
		int maxCount = 0;
		String maxElement = addresses.get(0);
		
		for (int i = 0; i<addresses.size(); i++)
		{
			if (addresses.get(i).equals(previousElement))
			{
				currentCount ++;
				if (currentCount > maxCount)
				{
					maxCount = currentCount;
					maxElement = addresses.get(i);
		
				} //second if
			}//first if
			else
			{
				currentCount = 0;
			}
			previousElement = addresses.get(i);
		}//end for loop
		
		
		return maxElement;
	}
}
