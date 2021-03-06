import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UPCRecall 
{
	public static void main(String [] arguments) throws FileNotFoundException
	{
		Scanner keyboard = new Scanner(System.in);
		File file = new File("UPCRecalled.txt");
		
		long UPC;
		System.out.println("Enter the product UPC or -1 to exit.");
		UPC = keyboard.nextLong();
		
		while (UPC != -1)
		{
			ArrayList<Long> result = readUPCFile(file);
			if(UPCWasRecalled(result, UPC))
			{
				System.out.println("That product has been recalled.");
				break;
			}
			else
			{
				System.out.println("That product has NOT been recalled.");
				break;
			}
		}
		
		keyboard.close();
		System.exit(1);
		
		
	}
	
	public static ArrayList<Long> readUPCFile(File file) throws FileNotFoundException
	{
		ArrayList<Long> result = new ArrayList<Long>();
		Scanner reader = new Scanner(file);
		
		while (reader.hasNext())
		{
			result.add(reader.nextLong());
		}
		
		
		reader.close();
		return result;
	}
	
	public static boolean UPCWasRecalled(ArrayList<Long> result, long UPC)
	{
			
		for (long upc : result)
		{
			if (upc == UPC)
				return true;
		}
		
		return false;
	}
	
}
