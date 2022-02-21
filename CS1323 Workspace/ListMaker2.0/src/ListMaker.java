/*
 * To improve the list making class from GroceryList, a few new features will be added.
 * 
 * 	Ability to sort/reorder the list
 * 1. Move up/down
 * 2. Move to position
 * 3. Hashtags
 * 
 */






import java.io.*;
import java.util.*;


public class ListMaker 
{
	final static String FILENAME = "List.txt";
	final static int ADD = 1;
	final static int DELETE = 2;
	final static int SHOW = 3;
	final static int MOVE_UP = 4;
	final static int MOVE_DOWN = 5;
	final static int MOVE_TO_POSITION = 6;
	final static int SEARCH_BY_HASHTAG = 7;
	final static int EXIT = 8;
	
	public static void main(String[] args)
	{
		GroceryList.selectFromMenu(); 
	}
}


	
