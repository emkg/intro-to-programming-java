/*
 * MEAN is the literal average. The sum of all values divided by the number of values.
 * MEDIAN is literally is value in the exact middle of the set of values (sorted).
 * MODE is the exact value that occurs most often 
 * (even if every other value occurs once and the mode happens to occur twice). 
 * 
 * If there is not an exact middle, the MEDIAN is the MEAN of the 2 values in the middle.
 * If there is a tie in the MODE category, take the MEAN of the values that tie.
 */
import java.util.Scanner;
import java.io.*;

public class AmbiguousAverage 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter the name of the file that contains your data set.");
		String fileName = keyboard.nextLine();
		
		//get the data
		int[] data = readDataFromFile(fileName);
		
		//Find the "averages"
		double mean = findMean(data);
		double median = findMedian(data);
		double mode = findMode(data);
		
		System.out.println("MEAN : " + mean); //testing
		System.out.println("MEDIAN : " + median); //testing
		System.out.println("MODE : " + mode); //testing
		
		System.exit(0); //testing
		
		System.out.println("Which value would help you lie with statistics to your greatest advantage?");
		System.out.println("The highest or lowest value?");
		System.out.println("Please type either 'highest' or 'lowest'.");
		String response = keyboard.next();
		
		// Report the result to the user
		if ("highest".equalsIgnoreCase(response))
		{
			System.out.println("The largest average is " + Math.max(mean, Math.max(median, mode)));
		}
		else
		{
			System.out.println("The smallest average is " + Math.min(mean, Math.min(median,mode)));
		}
		
		keyboard.close();
	}
	/*
	 *  Reads data from file
	 */
	public static int[] readDataFromFile(String fileName) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File(fileName));
		int[] data = new int[file.nextInt()]; 
		for(int i = 0; i < data.length; ++i)
		{
			data[i] = file.nextInt();
		}
		file.close();
		
		return data;
	}
		
	/*
	 * Calculates MEAN
	 */
	public static double findMean(int[] data)
	{
		double sum = 0.0;
		for(int i = 0; i < data.length; ++i)
		{
			sum += data[i];
		}
		
		//floating-point division 
		return sum/(data.length);
	}

	/*
	 * Calculates MEDIAN
	 * 
	 * For odd sized data set : Steps through values until there is a value 
	 * with the same number of values smaller than and larger than that value.
	 * 
	 *
	 * 
	 */
	public static double findMedian(int[] data)
	{
		double medianSum = 0.0;
		int medianCount = 0;
		
		for(int value = 0; value < data.length; ++value)
		{			
			//count number of values that are smaller and larger
			//than each value in data
			int smallerValues = 0;
			int largerValues = 0;
			int equalValues = 0;
			for(int test = 0; test < data.length; ++test)
			{
				if (data[test] < data[value])
					++smallerValues;
				else if (data[test] == data[value])
					++equalValues;
				else
					++largerValues;
			}	
			
			int half = data.length/2;
			
			//if a value exists where the number of smaller values
			//plus the number of equal values is greater than half
			// && the number of larger values plus the number of 
			//smaller values is greater than half, 
			//then we have found at least one median value
			if(smallerValues + equalValues >= half && largerValues + equalValues >= half)
			{
				
				//add median to a sum of values
				medianSum += data[value];
				//keep track of the number of medians
				++medianCount;
			}
		} //end of first for loop
		
		//average sum of medians and return to user
		return medianSum/medianCount;
	}

	/*
	 * Calculates MODE
	 */
	public static double findMode(int[] data)
	{
		double modeSum = 0;
		int modeCount = 0;
		int maxModeCount = 0;
		//for each value at 0 - data.length in the array, count the number of times the value occurs
		for(int value = 0; value < data.length; ++value)
		{
			int valueCounter = 0;
			for(int count = 0; count < data.length; ++count)
			{
				if(data[value] == data[count])
					++valueCounter;
					
			} // for count
			
			//if valueCounter exceeds current max, this is the new max 
			if(valueCounter > maxModeCount)
			{	
				//reset the max number of modes
				maxModeCount = valueCounter;
				//reset running sum
				modeSum = data[value];
				//increment number of modes
				modeCount= 1;
			}
			//if valueCounter equals the current max, 
			else if(valueCounter == maxModeCount)
			{
				//increment a counter of how many modes there are at present
				++modeCount;
				//add the value to a running sum of values that achieve this max
				modeSum += data[value];
			}	
		}
		
		return modeSum/modeCount;
	}
	

	/*
	 * Determines quality?
	 */
}
