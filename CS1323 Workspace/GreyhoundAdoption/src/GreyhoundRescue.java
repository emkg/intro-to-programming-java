import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**Stores the data for a general greyhound rescue organization.
 * 
 * @author Emily
 *
 */
public class GreyhoundRescue 
{
	private ArrayList<Greyhound> adoptableDogs; //dogs available for adoption
	private static final String FILE_NAME = "greyhound.txt"; //the file where the available dogs are listed
	
	/**Construct a rescue with no dogs (initially).
	 * 
	 */
	public GreyhoundRescue()
	{
		adoptableDogs = new ArrayList<Greyhound>();
		
	}

	/**Reads the greyhound data from a source file and adds it to the GreyhoundResucue.
	 * 
	 * @throws FileNotFoundException
	 */
	public void readGreyhoundsFromFile() throws FileNotFoundException
	{
		Scanner file = new Scanner(new File(FILE_NAME));

		int size = file.nextInt(); //first line of file MUST be an int indicating the number of lines in the file for this to work
		file.nextLine(); //moves the scanner to the next line to get rid of the previous int used to determine size	
		
		for(int i = 0; i < size; ++i)
		{
			//reads each line of the file--which are delimited greyhound data--as a single String
			String line = file.nextLine();
			//breaks each delimited line into a String Array of greyhound information
			String[] greyhoundData = line.split(",");
			//construct a Greyhound from each line using the greyhound data in the array
			//data assembled into constructor via the String class trim command
			Greyhound dog = new Greyhound(greyhoundData[0].trim(), Integer.parseInt(greyhoundData[1].trim()), greyhoundData[2].trim(),
					YNU.valueOf(greyhoundData[3].trim()), YNU.valueOf(greyhoundData[4].trim()),YNU.valueOf(greyhoundData[5].trim()));
			
			//add each greyhound to the instance ArrayList
			adoptableDogs.add(dog);		
		}
		
		file.close();
	}
	
	/**
	 * 
	 * @throws FileNotFoundException
	 */
	public void writeGreyhoundsToFile() throws FileNotFoundException
	{
		PrintWriter file = new PrintWriter(new File(FILE_NAME));
		
		//structure the file with the number of dogs in the file as an integer on the first line
		//when the file is read this will be scanned to determine how many lines of the file need to be read
		file.println(adoptableDogs.size());
		
		//print each dog one line at a time
		for (int i = 0; i < adoptableDogs.size(); ++i)
		{
			file.println(adoptableDogs.get(i));
		}
		
		file.close();
	}
	
	/** 
	 * 
	 * @param minAge
	 * @param maxAge
	 * @return
	 */
	public ArrayList<Greyhound> getDogsByAge(int minAge, int maxAge)
	{
		ArrayList<Greyhound> dogsByAge = new ArrayList<Greyhound>();
		
		//step through adoptable dogs one at a time
		for (int i = 0; i < adoptableDogs.size(); ++i)
		{
			//determine if this dog fits in the indicated range
			Greyhound dog = adoptableDogs.get(i);
			int age = dog.getAge();
			
			if (age >= minAge && age <= maxAge)
			{		
				//if so, add to the return list
				dogsByAge.add(dog);
			}
		}
		
		return dogsByAge;
	}
	/**
	 * 
	 * @param hounds
	 * @param minAge
	 * @param maxAge
	 * @return
	 */
	public static ArrayList<Greyhound> getDogsByAge(ArrayList<Greyhound> hounds, int minAge, int maxAge)
	{
		ArrayList<Greyhound> dogsByAge = new ArrayList<Greyhound>();
		
		//step through adoptable dogs one at a time
		for (int i = 0; i < hounds.size(); ++i)
		{
			//determine if this dog fits in the indicated range
			Greyhound dog = hounds.get(i);
			int age = dog.getAge();
			
			if (age >= minAge && age <= maxAge)
			{		
				//if so, add to the return list
				dogsByAge.add(dog);
			}
		}
		
		return dogsByAge;
	}
	
	/**
	 * 
	 * @param sex
	 * @return
	 */
	public ArrayList<Greyhound> getDogsBySex(String sex)
	{
		ArrayList<Greyhound> dogsBySex = new ArrayList<Greyhound>();
		
		//step through adoptable dogs one at a time
		for (int i = 0; i < adoptableDogs.size(); ++i)
		{
			//determine if this dog is the sex the user seeks
			Greyhound dog = adoptableDogs.get(i);
			String sexOfDog = dog.getSex();
			
			if (sexOfDog.equals(sex))
			{		
				//if so, add to the return list
				dogsBySex.add(dog);
			}
		}
		
		return dogsBySex;
	}
	/**
	 * 
	 * @param hounds
	 * @param sex
	 * @return
	 */
	public static ArrayList<Greyhound> getDogsBySex(ArrayList<Greyhound> hounds, String sex)
	{
		ArrayList<Greyhound> dogsBySex = new ArrayList<Greyhound>();
		
		//step through adoptable dogs one at a time
		for (int i = 0; i < hounds.size(); ++i)
		{
			//determine if this dog is the sex the user seeks
			Greyhound dog = hounds.get(i);
			String sexOfDog = dog.getSex();
			
			if (sexOfDog.equals(sex))
			{		
				//if so, add to the return list
				dogsBySex.add(dog);
			}
		}
		
		return dogsBySex;
	}
	/**
	 * 
	 * @param cat
	 * @return
	 */
	public ArrayList<Greyhound> getCatFriendlyDogsOrNot(YNU cat)
	{
		ArrayList<Greyhound> dogsByCatPreference = new ArrayList<Greyhound>();
		
		//step through adoptable dogs one at a time
		for (int i = 0; i < adoptableDogs.size(); ++i)
		{
			//determine if this dog likes cats or not
			Greyhound dog = adoptableDogs.get(i);
			YNU catPreference = dog.getCat();
			
			if (catPreference == cat)
			{		
				//if so, add to the return list
				dogsByCatPreference.add(dog);
			}
		}
		
		return dogsByCatPreference;
	}
	/**
	 * 
	 * @param hounds
	 * @param cat
	 * @return
	 */
	public static ArrayList<Greyhound> getCatFriendlyDogsOrNot(ArrayList<Greyhound> hounds, YNU cat)
	{
		ArrayList<Greyhound> dogsByCatPreference = new ArrayList<Greyhound>();
		
		//step through adoptable dogs one at a time
		for (int i = 0; i < hounds.size(); ++i)
		{
			//determine if this dog likes cats or not
			Greyhound dog = hounds.get(i);
			YNU catPreference = dog.getCat();
			
			if (catPreference == cat)
			{		
				//if so, add to the return list
				dogsByCatPreference.add(dog);
			}
		}
		
		return dogsByCatPreference;
	}
	
	/**
	 * 
	 * @param kid
	 * @return
	 */
	public ArrayList<Greyhound> getKidFriendlyDogsOrNot(YNU kid)
	{
		ArrayList<Greyhound> dogsByKidPreference = new ArrayList<Greyhound>();
		
		//step through adoptable dogs one at a time
		for (int i = 0; i < adoptableDogs.size(); ++i)
		{
			//determine if this dog likes kids or not
			Greyhound dog = adoptableDogs.get(i);
			YNU kidPreference = dog.getKid();
			
			if (kidPreference == kid)
			{		
				//if so, add to the return list
				dogsByKidPreference.add(dog);
			}
		}
		
		return dogsByKidPreference;
	}
	/**
	 * 
	 * @param hounds
	 * @param kid
	 * @return
	 */
	public static ArrayList<Greyhound> getKidFriendlyDogsOrNot(ArrayList<Greyhound> hounds, YNU kid)
	{
		ArrayList<Greyhound> dogsByKidPreference = new ArrayList<Greyhound>();
		
		//step through adoptable dogs one at a time
		for (int i = 0; i < hounds.size(); ++i)
		{
			//determine if this dog likes kids or not
			Greyhound dog = hounds.get(i);
			YNU kidPreference = dog.getKid();
			
			if (kidPreference == kid)
			{		
				//if so, add to the return list
				dogsByKidPreference.add(dog);
			}
		}
		
		return dogsByKidPreference;
	}
	
	/**
	 * 
	 * @param smallDog
	 * @return
	 */
	public ArrayList<Greyhound> getSmallDogFriendsOrNot(YNU smallDog)
	{
		ArrayList<Greyhound> dogsBySmallDogPreference = new ArrayList<Greyhound>();
		
		//step through adoptable dogs one at a time
		for (int i = 0; i < adoptableDogs.size(); ++i)
		{
			//determine if this dog likes small dogs or not
			Greyhound dog = adoptableDogs.get(i);
			YNU smallDogPreference = dog.getSmallDog();
			
			if (smallDogPreference == smallDog)
			{		
				//if so, add to the return list
				dogsBySmallDogPreference.add(dog);
			}
		}
		
		return dogsBySmallDogPreference;
	}
	/**
	 * 
	 * @param hounds
	 * @param smallDog
	 * @return
	 */
	public static ArrayList<Greyhound> getSmallDogFriendsOrNot(ArrayList<Greyhound> hounds, YNU smallDog)
	{
		ArrayList<Greyhound> dogsBySmallDogPreference = new ArrayList<Greyhound>();
		
		//step through adoptable dogs one at a time
		for (int i = 0; i < hounds.size(); ++i)
		{
			//determine if this dog likes small dogs or not
			Greyhound dog = hounds.get(i);
			YNU smallDogPreference = dog.getSmallDog();
			
			if (smallDogPreference == smallDog)
			{		
				//if so, add to the return list
				dogsBySmallDogPreference.add(dog);
			}
		}
		
		return dogsBySmallDogPreference;
	}
}

