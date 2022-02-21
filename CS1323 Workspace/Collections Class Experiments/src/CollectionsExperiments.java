import java.util.*;
import java.awt.Point;
import java.lang.*;

public class CollectionsExperiments 
{
	final static int SIZE = 10;
	
	public static void main(String[] args)
	{
		//experiment1(); // prints the values 1-10 from an ArrayList with a single instruction
		//experiment2(); // creates an ArrayList that contains the number 1-10 in random order by shuffling the numbers after they have been sorted.
		//experiment3(); //performs linear search for the number 5 in myList
		//experiment4(); //sorting in one line with the Collections class
		//experiment5(); //can we sort an array of point objects? -- answer no.
		//experiment6(); //binary search for faster results
		experiment7(); //finding min and max values

	}
	
	public static void experiment1()
	{
		ArrayList<Integer> myList = new ArrayList<Integer>(10);
		for (int i = 0; i < 10; i++)
		{
			myList.add(new Integer(i+1));
		}
		
		System.out.println(myList);
		
	}
	
	public static void experiment2()
	{
		ArrayList<Integer> myList = new ArrayList<Integer>(10);
		for (int i = 0; i < 10; i++)
		{
			myList.add(new Integer(i+1));
		}
		Collections.shuffle(myList);
		System.out.println(myList);
	}
	
	public static void experiment3()
	{
		//will check for frequency of a specific value in the list then creates a 
		//sublist composed of the target value and searches the list for the first 
		//value of that sublist within the first list
		ArrayList<Integer> myList = new ArrayList<Integer>(10);
		for (int i = 0; i < 10; i++)
		{
			myList.add(new Integer(i+1));
		}
		Collections.shuffle(myList);
		
		System.out.println(myList);
		
		Integer value = new Integer(5);
		if (Collections.frequency(myList, value) == 0)
			System.out.println("5 is not in the list.");
		else
			System.out.println("I found 5.");
		
		ArrayList <Integer> target = new ArrayList<Integer>(1);
		
		target.add(value);
		
		int index = Collections.indexOfSubList(myList, target);
		
		if (index == -1)
			System.out.println("5 is not in the list.");
		else
			System.out.println("I found 5 at index " + index + ".");
	}
	
	public static void experiment4()
	{
		//shows us a shuffled list, 
		//then sorts the list and shows that sorted list
		
		ArrayList<Integer> myList = new ArrayList<Integer>(10);
		for (int i = 0; i < 10; i++)
		{
			myList.add(new Integer(i+1));
		}
		Collections.shuffle(myList);
		System.out.println(myList);
		
		Collections.sort(myList);
		System.out.println(myList);	
	}
	
	public static void experiment5()
	{
		ArrayList<Point> myList = new ArrayList<Point>(10);
		for (int i = 0; i < 10; i++)
		{
			myList.add(new Point((i+1), (i+1)));
		}
		Collections.shuffle(myList);
		System.out.println(myList);
		
		//Collections.sort(myList); remove comment to see error.
		//System.out.println(myList);	
	}
	
	public static void experiment6()
	{
		ArrayList<Integer> myList = new ArrayList<Integer>(10);
		for (int i = 0; i < 10; i++)
		{
			myList.add(new Integer(i+1));
		}
		Collections.shuffle(myList);
		System.out.println(myList);
		
		Collections.sort(myList);
		System.out.println(myList);	
		Integer value = new Integer(5);
		
		System.out.println(Collections.binarySearch(myList, value));
	}
	
	public static void experiment7()
	{
		ArrayList<Integer> myList = new ArrayList<Integer>(10);
		for (int i = 0; i < 10; i++)
		{
			myList.add(new Integer(i+1));
		}
		Collections.shuffle(myList);
		System.out.println(myList);
		
		System.out.println("The minimum value is " + Collections.min(myList));
		System.out.println("The maximum value is " + Collections.max(myList));
	}
	
}
