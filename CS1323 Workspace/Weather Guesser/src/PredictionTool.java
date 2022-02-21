import java.util.*;
import java.io.*;

public class PredictionTool
{
	public static final boolean TESTING = true; //enter data manually
	public static final String FILE_NAME = "sample.csv";
	public static final int DAYS_IN_YEAR = 365; //no leap years
	public static int[] meanTemp = new int[DAYS_IN_YEAR];
	
	
	public static void main (String[] args) throws FileNotFoundException
	{
		Scanner keyboard = new Scanner(System.in);
		int dayNumber;
		
		if(TESTING)
		{
			dayNumber = getDayNumber(keyboard); //unit index
			dayNumber = dayNumber - 1; //back to zero index
		}
		else
		{
			GregorianCalendar today = new GregorianCalendar();
			dayNumber = today.get(GregorianCalendar.DAY_OF_YEAR); //unit indexed
			dayNumber = dayNumber - 1; //back to zero index
		}
		
		readTempFromFile(meanTemp);
		System.out.println("I reckon the it'll be " + calculateMeanTempOfSameWeek(meanTemp, dayNumber) 
				+ " degrees outside tomorrow.");
	}
	
	public static int getDayNumber(Scanner keyboard)
	{
		System.out.println("Please enter the Gregorian day of the year...");
		System.out.println("For example, Jan 1 is 1 and Feb 1 is 32. Dec 31 is just 365.");
		System.out.println("For now, Feb. 29 does not exist.");
			
		return keyboard.nextInt();
	}
	
	public static double calculateMeanTempOfSameWeek(int[] meanTemp, int dayNumber)//i have no idea why this works
	{
		int indexOfDay = dayNumber - 3;
		int sum = 0;
		int count = 0;
		while (indexOfDay <= dayNumber + 3)
		{
			if ((indexOfDay >= 0) && (indexOfDay < DAYS_IN_YEAR))
			{
				sum = sum + meanTemp[indexOfDay];
				count ++;
			}
			
			indexOfDay++;
		}

		return sum/(double)count;
	}
	
	public static void readTempFromFile(int [] meanTemp) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File(FILE_NAME));
		//read in header
		file.nextLine();//skip header
		for(int i = 0; i < DAYS_IN_YEAR; i++)
		{
			String lineOfFile = file.nextLine();
			String[] fieldsOfLine = lineOfFile.split(",");
			meanTemp[i] = Integer.parseInt(fieldsOfLine[2]);
		}
		
		file.close();
	}
}
