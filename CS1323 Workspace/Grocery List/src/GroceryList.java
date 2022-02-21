/*Want to make a grocery list utility in which items of the list can be stored perpetually.
 * There needs to be 
 * --menu control
 * --the ability to add items
 * --show those items to the user
 * --delete items
 * --read
 * --write
 * --exit
 * 
 * 
 * will use an ArrayList<String>
 * 
 * menu driven program
 * ADD, DELETE, SHOW, EXIT, FILENAME 
 */

import java.util.*;
import java.io.*;

public class GroceryList 
{
	
	//static means class data, not with the instance; final means constant.
	protected final static String FILENAME = "myCurrentList.txt";
	protected final static int ADD = 1;
	protected final static int DELETE = 2;
	protected final static int SHOW = 3;
	protected final static int SAVE = 8;
	
	/*public GroceryList()
	{
		
	}
	*/
	public static int selectFromMenu(Scanner input)
	{
		int choice = 0;
		System.out.println("Please choose: ");
		System.out.println(ADD + " . . Add new item");
		System.out.println(DELETE + " . . Delete an item");
		System.out.println(SHOW + " . . Show the list");
		System.out.println(SAVE + " . . Save your list");
		
		choice = input.nextInt();
		input.nextLine();
		
		return choice;
	}
	
	public static void main(String args[]) throws FileNotFoundException 
	{
		ArrayList<String> myList; 
		myList = readListFromFile();
		Scanner keyboard = new Scanner(System.in);
		
		int choice = 0;
		while(choice != SAVE)
		{
			choice = selectFromMenu(keyboard);
			if(choice == ADD)
			{
				addItemToList(myList, keyboard); 
			}
			else if(choice == DELETE)
			{
				deleteItemFromList(myList, keyboard);
			}
			else if(choice == SHOW)
			{
				showList(myList, keyboard);
			}
		}		
		
		writeListToFile(myList);
		
	}	
	
	public static void addItemToList(ArrayList<String> myList, Scanner keyboard)
	{
		System.out.println("Enter the item name:");
		String name = keyboard.nextLine();
		System.out.println("Please input this number: "  + myList.size() + "");
		int index = keyboard.nextInt();
		
		
		
		myList.add(index, name);
	}
	
	public static void showList(ArrayList<String> myList, Scanner keyboard)
	{		
		int count = 0;
		do
		{
		System.out.println((count+1) + ": " + myList.get(count));
		count++;
		}while (count < myList.size());
	}

	public static void deleteItemFromList(ArrayList<String> myList, Scanner keyboard) throws FileNotFoundException
	{
		System.out.println("Which item number would you like to delete?");
		showList(myList, keyboard); //since this is not a GUI app, users may need to remember
		int index = keyboard.nextInt();
		
		//protects from deletions from out of range
		if (index < 0 || index >= myList.size())
			return;

		myList.remove((index-1)); //since users think in integers, do the hard work for them, index-1
		System.out.println("Ok, deleted!");
			if (myList.size() == 0)
			{
				System.out.println("Your list is empty again!");
			}
			else
			{
				showList(myList, keyboard);
			}
		
	}
	
	public static ArrayList<String> readListFromFile() throws FileNotFoundException
	{
		File file = new File(FILENAME);
		ArrayList<String> result = new ArrayList<String>();
		
		//Check to see if the file exists. If not, return empty ArrayList.
		if (!file.exists())
		{
			return result;
		}
		
		Scanner scanFile = new Scanner(file);
		while (scanFile.hasNextLine())
		{
			String nextLine = scanFile.nextLine();
			result.add(nextLine);
		}
		
		scanFile.close();
		return result;
	}
	
	public static void writeListToFile(ArrayList<String> list) throws FileNotFoundException
	{
		File file = new File(FILENAME);
		PrintWriter printer = new PrintWriter(file);
		
		int index = 0;
		while (index < list.size())
		{
			printer.println(list.get(index));
			index = index + 1;
		}
		
		printer.close();
		
	}
	

}
