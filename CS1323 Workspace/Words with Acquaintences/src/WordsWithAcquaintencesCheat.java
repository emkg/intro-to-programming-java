import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class WordsWithAcquaintencesCheat 
{
	public static ArrayList<String> readDictionaryFromFile(String fileName) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File(fileName));
		ArrayList<String> dictionary = new ArrayList<String>(0);
		
		while (file.hasNextLine())
		{
			String name = file.nextLine();
			dictionary.add(name);
		}
				
		file.close();
		return dictionary;

	}
	
	public static ArrayList<String> findAllMatches(String letters, int wildCards, ArrayList<String> dictionary)
	{
		ArrayList<String> result = new ArrayList<String>(0);
		//search for a match for each word in dictionary, one word at a time
		for (int i = 0; i < dictionary.size(); i++)
		{
			String word = dictionary.get(i);
			int matches = countMatches(word, letters);
			//if the num char matches plus num wildCards exceeds the number of letters in word, add it to result
			if (matches + wildCards >= word.length())
			{
				result.add(word);
			}
		}
		//letters is StringBuilder bc we have to add and remove chars as they are/are not found
		return result;
	}
	
	public static int countMatches(String word, String letters)
	{
		
		//step through the word one char at a time
		int matches = 0;
		StringBuilder dynamicLetters = new StringBuilder(letters);
		for (int i = 0; i < word.length(); i++)
		{
			//myChar is the letter at index 0-end of String
			String myChar = "" + word.charAt(i);
			int indexOfMyChar = dynamicLetters.indexOf(myChar);
			
			//if the current letter in word is in letters, remove it from letters and increase matches by 1
			if (indexOfMyChar != -1)
			{
				dynamicLetters.deleteCharAt(indexOfMyChar);
				matches ++;
			}
		}
	
		//matches is the number of chars removed
		
		return matches;	
	}
	
	static String GetLettersFromUser(Scanner keyboard)
	{
		
		System.out.println("Enter some letters with no spaces please...");
		String letters = keyboard.nextLine();
		
		return letters;
	}
	
	static int GetNumberFromUser(Scanner keyboard)
	{
		System.out.println("Enter a number of wild cards...");
		int wildCards = keyboard.nextInt();
		keyboard.nextLine(); //get rid of end of line char
		
		return wildCards;
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		
		Scanner keyboard = new Scanner(System.in);
		
		String letters = GetLettersFromUser(keyboard);
		int wildCards = GetNumberFromUser(keyboard);
				
		String fileName = "Dictionary.txt";		

		ArrayList<String> dictionary = readDictionaryFromFile(fileName);
		ArrayList<String> chosenWords = findAllMatches(letters, wildCards, dictionary);
		System.out.println(chosenWords);
	}
}