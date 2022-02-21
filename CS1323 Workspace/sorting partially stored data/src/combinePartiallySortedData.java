import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class combinePartiallySortedData 
{
	/* combines sorted and unsorted data into one file. requires files to have the size of the array on line 1.
	 * 
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner keyboard = new Scanner(System.in);
		
		String sortedFileName;
		String unsortedFileName;
		String outputFileName;
		
		System.out.println("Please enter the name of the sorted file...");
		sortedFileName = keyboard.next();
		System.out.println("Please enter the name of the unsorted file...");
		unsortedFileName = keyboard.next();
		System.out.println("What would you like the name of your new file to be?");
		outputFileName = keyboard.next();
		
		Scanner sortedFile = new Scanner(new File(sortedFileName));
		int sortedSize = sortedFile.nextInt();
		sortedFile.nextLine(); // gets rid of newline character
		
		Scanner unsortedFile = new Scanner(new File(unsortedFileName));
		int unsortedSize = unsortedFile.nextInt();
		unsortedFile.nextLine(); // gets rid of newline character
		
		String[] data = readFiles(sortedFile, unsortedFile, sortedSize, unsortedSize);
		sortedFile.close();
		unsortedFile.close();
		
		sortMergeData(data, sortedSize);
		
		saveToFile(outputFileName, data);
		
		keyboard.close();
		
	}
	
	/*
	 * 
	 * 
	 */
	public static void sortMergeData(String [] data, int sortedSize)
	{
		int minIndex;
		
		//walk through one element at a time
		for(int i = 0; i < data.length; ++i)
		{
			//find the next minimum value and put it in the proper position
			minIndex = i;
			
			//if we are still in the sorted data, start at the first element of the unsorted data
			//if we are in the unsorted data, start at the next element
			int next;
			if(i < sortedSize)
				next = sortedSize; // still searching unsorted data
			else
				next = i + 1;
				for( ; next < data.length; ++next)
				{
					if (data[next].compareTo(data[minIndex]) < 0)
						minIndex = next;
				}
			//swap data
			if (minIndex != i)
			{
				String temp = data[minIndex];
				data[minIndex] = data[i];
				data[i] = temp;
			}
			
		}
		return;
	}
	
	/*
	 * 
	 * 
	 */
	public static void saveToFile(String nameOfFile, String[] data) throws FileNotFoundException
	{
		PrintWriter file = new PrintWriter(new File(nameOfFile));
		
		//count duplicates
		int duplicates = 0;
		for(int i = 1; i < data.length; ++i)
		{
			if(data[i].equals(data[i-1]))
					++duplicates;
		}
		
		file.println(data.length-duplicates);
		
		if(data.length != 0)
			file.println(data[0]);
		
		for(int i = 1; i < data.length; ++i)
		{
			if(!data[i].equals(data[i-1]))
					file.println(data[i]);
		}
		
		file.close();
		return;
	}
	
	/*
	 * 
	 */
	public static String[] readFiles(Scanner sortedFile, Scanner unsortedFile, int sortedSize, int unsortedSize) throws FileNotFoundException
	{
		String [] result = new String[sortedSize + unsortedSize];
		
		int i = 0;
		for( ; i < sortedSize && sortedFile.hasNextLine(); ++i)
		{
			result[i] = sortedFile.nextLine();
		}
		
		if(i != sortedSize)
		{
			System.out.println("Something went wrong...the file seems to be corrupted.");
		}
		
		//would it be ok to set i= 0 again instead of adding the previous total to this one?
		for( ; i < (sortedSize + unsortedSize); ++i)
		{
			result[i] = unsortedFile.nextLine();
		}
		
		if(i != sortedSize + unsortedSize)
		{
			System.out.println("Something went wrong...the file seems to be corrupted.");
		}
		
		return result;
	}
}
