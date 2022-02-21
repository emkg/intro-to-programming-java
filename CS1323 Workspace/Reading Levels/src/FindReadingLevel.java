import java.util.*;
import java.io.*;


public class FindReadingLevel 
{
	/*
	 * 
	 */
	public static int findFleschKincaidIndex(String fileName) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File(fileName));
		String line;
		String [] words;
		
		int wordCount = 0;
		int sentenceCount = 0;
		int syllableCount = 0;
				
		while (file.hasNextLine())
		{
			line = file.nextLine();
			if (!line.isEmpty())
			{
				words = line.split(" ");
				for(int i = 0; i < words.length; ++i)
				{
					++wordCount;
					if(words[i].contains(".") || words[i].contains("!") || words[i].contains("?"))
						++sentenceCount;
					
					syllableCount += countSyllables(words[i]);
					
				} //end for
			} //end if !isEmpty
		} // end while
		
		file.close();
		
		return (int)(Math.round(((wordCount * .39)/sentenceCount) + (11.8 * (syllableCount/wordCount)) - 15.59));
	}
	
	/*
	 * 
	 */
	public static int countSyllables(String word)
	{
		//create a stringBuilder since strings are immutable
		StringBuilder sb = new StringBuilder(word);
		for (int i = 1; i < sb.length(); ++i)
		{
			if (isVowel(sb.charAt(i)) && isVowel(sb.charAt(i-1)))
			{
				//remove consecutive vowels
				sb.deleteCharAt(i);
			}
		}
		
		if (sb.length() == 0)
			return 0;
		
		//remove trailing vowels that are not 'y'
		int lastChar = sb.length() - 1; //for cleaner code
		if (isVowelNotY(sb.charAt(lastChar)))
			sb.deleteCharAt(lastChar);
		
		//count vowels
		int vowelCount = 0;
		for (int i = 0; i < sb.length(); ++i)
		{
			if(isVowel(sb.charAt(i)))
				++vowelCount;
		}
		
		if (vowelCount == 0)
			return 1;
		
		return vowelCount;
	}
	
	/*
	 * 
	 */
	public static boolean isVowel(char c)
	{
		if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y')
			return true;
		
		return false;
	}
	
	/*
	 * 
	 */
	public static boolean isVowelNotY(char c)
	{
		return isVowel(c) && c != 'y';
	}
	
	/*
	 * 
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter the name of file which contains the story for which you would like"
				+ "to determine the reading level...");
		String fileName = keyboard.next();
		System.out.println("The Flesch-Kincaid reading level for this work is " + findFleschKincaidIndex(fileName) + "...");
		keyboard.close();
	}
}
