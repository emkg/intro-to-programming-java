
import java.util.*;
import java.io.*;

public class ListMaker extends GroceryList
{
	protected final static int MOVE_UP = 4;
	protected final static int MOVE_DOWN = 5;
	protected final static int MOVE_TO_POSITION = 6;
	protected final static int SEARCH_BY_HASHTAG = 7;
	
	/*public ListMaker()
	{
		super(); //I'm not sure where a constructor would come in.
	}
	*/
	
	public static int selectFromMenu(Scanner input)
	{
		int choice = 0;
		System.out.println("Please choose: ");
		System.out.println(ADD + " . . Add new item");
		System.out.println(DELETE + " . . Delete an item");
		System.out.println(SHOW + " . . Show the list");
		System.out.println(MOVE_UP + " . . Promote an item");
		System.out.println(MOVE_DOWN + " . . Demote an item");
		System.out.println(MOVE_TO_POSITION + " . . Rearrange an item");
		System.out.println(SEARCH_BY_HASHTAG + " . . Search the list");
		System.out.println(SAVE + " . . Save your list");
		
		choice = input.nextInt();
		input.nextLine();
		
		return choice;
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner keyboard = new Scanner(System.in);
		ArrayList<String> myList; 
		myList = readListFromFile();
		
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
			else if (choice == MOVE_UP) 
			{
				moveUp(myList, keyboard);
			}
			else if (choice == MOVE_DOWN)
			{
				moveDown(myList, keyboard);
			}
			else if (choice == MOVE_TO_POSITION)
			{
				moveToPosition(myList, keyboard);
			}
			else if (choice == SEARCH_BY_HASHTAG) //still works great
			{
				searchByHashtag(myList, keyboard);
			}
		}		
		
		writeListToFile(myList);
	}
	
	public static void moveUp(ArrayList<String> list, Scanner keyboard)
	{
		showList(list, keyboard); //remind users what is on the list
		System.out.println("Which item would you like to promote?");
		int index = keyboard.nextInt(); //user will be off by one
		index = index - 1; //convert to zero indexing
				
		//check range
		if (index == 0) //can't get higher than the top
			return;
		if (index > 0 && index <= list.size()-1) //between 2nd and very last item
		{
			//perform promotion
			Collections.swap(list, index, index - 1);
			System.out.println("Voila!");
			showList(list, keyboard); //give users feedback on what they just did
		}
		
	}//end of moveUp
	
	public static void moveDown(ArrayList<String> list, Scanner keyboard)
	{
		showList(list, keyboard); // remind users what they put on the list already
		System.out.println("Which item would you like to demote?");
		int index = keyboard.nextInt(); //user will be off by one
		index = index - 1; //convert to zero indexing
				
		//check range
		if (index == list.size()-1) //can't get any lower than the bottom
			return;
		if (index >= 0 && index < list.size()-1) //between the highest and one item higher than bottom
		{
			//perform demotion
			Collections.swap(list, index, index + 1);
			System.out.println("Voila!");
			showList(list, keyboard); //feedback on action performed
		}
	}//end of moveDown
	
	public static void moveToPosition(ArrayList<String> list, Scanner keyboard)
	{
		//reposition directly
		showList(list, keyboard); //always remind user what is already on their list
		System.out.println("Which item would you like you move?");
		int indexToMove = (keyboard.nextInt())-1;
		System.out.println("To which position would you like this item to move?");
		int indexDestination = (keyboard.nextInt()) - 1;
		
		//nothing should happen if user tries to move items from or to out of range
		if (indexToMove < 0 || indexToMove > (list.size()-1))
			return;
		//nothing should happen if user tries to move items from or to out of range
		else if (indexDestination < 0 || indexDestination > (list.size()-1))
			return;
		
		//perform move to position
		//use remove(int index) and add(int index, E element)
	
		String itemToMove = list.get(indexToMove);
		list.remove(indexToMove);		
		list.add(indexDestination, itemToMove);
		showList(list, keyboard);
		
	}

	public static void searchByHashtag(ArrayList<String> list, Scanner keyboard)
	{
		//if items are added with #hashtags then user can sort these items by matching hashtags
		//new ArrayList will keep track of sorted data
		System.out.println("Enter a hashtag category to search...please include #.");
		String hashtag = keyboard.next(); //next since one contiguous word is needed
		keyboard.nextLine(); // if user enters words with spaces, this will skip
		
		//even so, if they forget the # we can't continue so,
		while (!hashtag.contains("#"))
		{
			System.out.println("Dude! I specifically asked for a # in your input. "
					+ "Will you please re-enter your query?");
			hashtag = keyboard.next(); //next since one contiguous word is needed
			keyboard.nextLine(); // if user enters words with spaces, this will skip
		}
		
		//perform search
		ArrayList<String> results = new ArrayList<String>();
		
		for (int i = 0; i < list.size(); i++)
		{
			String listItem = list.get(i);
			if (listItem.contains(hashtag))
			{
				results.add(listItem);
			}//end fill results
			
		}// end for loop
		
		//if no matches, return feedback: no matches :(
		if (results.size() == 0)
		{
			System.out.println("Eh, so I guess I found no matches. That's a bummer. :( ");
			return;
		}
		else
		{
		for (int i = 0; i < results.size(); i++)
			System.out.println(results.get(i));
		}
		
	}// end searchByHashtag method
}
