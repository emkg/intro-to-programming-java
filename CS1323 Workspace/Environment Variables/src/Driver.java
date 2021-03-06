import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Driver 
{
	/** Read the environment variables from a file. The file name is the first command line argument.
	 * 
	 * @param args The file name.
	 * @throws FileNotFoundException If a file by that name is not found in the Project Home Directory.
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		Dictionary environment = new Dictionary();
		Scanner keyboard = new Scanner(System.in);
		
		if (args.length == 0)
		{
			System.out.println("No config file was found.");
		}
		else
		{
			String fileName = args[0];
					
			while(true) //infinite loop is intentional
			{
				System.out.println("Enter the variable name to see environment variable."
						+ " Variable=value to add a new one or QUIT to exit.");
				String line = keyboard.nextLine();
				if (line.equalsIgnoreCase("QUIT"))
				{
					System.exit(0); //0 means that the exit is not in error or due to a problem; everything is OK.
				}
				else if(line.contains("="))
				{
					addToDictionary(line, environment);
				}
				else
				{
					//Search the file for the variable
					readFile(fileName, environment);
					System.out.println(environment.getValue(line));
					System.out.println();
				}//end of search else
			}//end of while true
		}//end of else--args has a size.
		
		System.out.print(environment);
		
		keyboard.close();
	}
	
	/**
	 * 
	 * @param line
	 * @param env
	 */
	public static void addToDictionary(String line, Dictionary env)
	{
		int indexEquals = line.indexOf("=");
		
		//An indexEquals of -1 means there was no equal sign, thus no pair was entered, 
		//and nothing can be added to the dictionary.
		if(indexEquals == -1)
			return;
		
		String key = line.substring(0, indexEquals);
		String value = line.substring(indexEquals, (line.length()));
		env.put(key, value);
	}
	
	/**
	 * 
	 * @param fileName
	 * @param env
	 * @throws FileNotFoundException
	 */
	public static void readFile(String fileName, Dictionary env) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File(fileName));
		while(file.hasNextLine())
		{
			String line = file.nextLine();
			addToDictionary(line, env);
		}
		
		file.close();
	}
}
