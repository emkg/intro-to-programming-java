import java.util.Scanner;
import java.text.DecimalFormat;

/** Run a program that stores data for a charity.  The program stores
 * donors and donations of both cash and items.  At this time the data
 * is not written to files, so the program is not persistent.
 * @author Deborah A. Trytten
 *
 */
public class Driver 
{

	private Charity charity;
	
	// Class data--these are all names of critical functions
	private static DecimalFormat dollarFormat = new DecimalFormat("$0.00");
	private static final int ADD_DONOR = 1;
	private static final int ADD_DONATION = 2;
	private static final int FIND_CHARITY_VALUE = 3;
	private static final int FIND_DONOR_VALUE = 4;
	private static final int QUIT = 5;
	
	/** Construct a driver for a charity with the given name.
	 * 
	 * @param name The name of the charity.
	 */
	public Driver(String name)
	{
		charity = new Charity(name);
	}
	
	/** Run the charity. The user will be able to enter donors and donations for
	 * existing donors, and query how much a single person has donated and how much
	 * has been donated overall.
	 * 
	 * @param args There are no command line arguments
	 */
	public static void main(String[] args) 
	{
		Driver petsAndPeople = new Driver("Pets and People");
		Scanner input = new Scanner(System.in);
		
		// priming read
		int choice = 0;
		choice = menuAndResponse(input);
		
		while (choice  != QUIT)
		{
			if (choice == ADD_DONOR)
			{
				petsAndPeople.addDonor(input);
			}
			else if (choice == ADD_DONATION)
			{
				petsAndPeople.addDonation(input);
			}
			else if (choice == FIND_CHARITY_VALUE)
			{
				System.out.println("The charity has " 
				+ dollarFormat.format(petsAndPeople.charity.findValueAllDonations()));
			}
			else if (choice == FIND_DONOR_VALUE)
			{
				petsAndPeople.findDonorValue(input);
			}
			else
			{
				System.out.println("Unanticipated case");
			}
			
			//Priming read
			choice = menuAndResponse(input);
		}

	}
	
	/** Add a new donor.
	 * 
	 * @param keyboard For interaction with the user.
	 */
	public void addDonor(Scanner keyboard)
	{
		System.out.println("Enter the donor's name");
		String name = keyboard.nextLine();
		
		System.out.println("Enter the first line of the donor's address");
		String line1 = keyboard.nextLine();
		
		System.out.println("Does the donor's address have a second line? Yes/No");
		String line2 = keyboard.nextLine();
		if (line2.equalsIgnoreCase("yes"))
		{
			System.out.println("Enter the second line");
			line2 = keyboard.nextLine();
		}
		else
		{
			line2 = null; //flags no second line
		}
		
		System.out.println("Enter the city");
		String city = keyboard.nextLine();
		
		System.out.println("Enter the state");
		String state = keyboard.nextLine();
		
		System.out.println("Enter the zipcode");
		String zipcode = keyboard.nextLine();
		
		Address address = new Address(line1, line2, city, state, zipcode);
		
		charity.addDonor(name, address);
	}

	/** Add a donation for an existing donor.
	 * 
	 * @param keyboard For interaction with the user.
	 */
	public void addDonation(Scanner keyboard)
	{
		System.out.println("Enter the donor's name");
		String name = keyboard.nextLine();
		
		System.out.println("Enter the money donated");
		double money = keyboard.nextDouble();
		
		System.out.println("How many items were donated");
		int numberDonations = keyboard.nextInt();
		keyboard.nextLine(); // get rid of end of line
		
		Donation donation = new Donation(money);
		
		for (int i=0; i< numberDonations; ++i)
		{
			System.out.println("Enter the name of the item");
			String item = keyboard.nextLine();
			System.out.println("Enter the value of the item");
			double value = keyboard.nextDouble();
			keyboard.nextLine(); // get rid of end of line
			
			donation.addItem(item, value);
		}
		
		charity.makeDonation(name, donation);
		
	}
	
	/** Find the amount a single donor has given.
	 * 
	 * @param keyboard For interaction with the user.
	 */
	public void findDonorValue(Scanner keyboard)
	{
		System.out.println("Enter the donor's name");
		String name = keyboard.nextLine();
		
		Donor donor = charity.findDonor(name);
		
		while (donor == null)
		{
			// This could be a problem if the user gets here accidentally--how will they get out?
			System.out.println("That name was not found. Please re-enter the donor's name");
			name = keyboard.nextLine();
			donor = charity.findDonor(name);
		}
		
		System.out.println("That donor has donated " 
				+ dollarFormat.format(charity.findValueOneDonor(name)));
		
	}

	/** Show a menu of possible actions on the screen and accept user input.
	 * 
	 * @param input For interaction with the user.
	 * @return The constant for the menu choice selected.  Renumbered the menu choices may break this method.
	 */
	public static int menuAndResponse(Scanner input)
	{
		System.out.println("Choose one of the following options:");
		System.out.println(ADD_DONOR + ". Add a new donor.");
		System.out.println(ADD_DONATION + ". Add a donation from an existing donor");
		System.out.println(FIND_CHARITY_VALUE + ". Find the amount of money and goods donated by everyone");
		System.out.println(FIND_DONOR_VALUE + ". Find the amount of money and goods donated by one donor");
		System.out.println(QUIT + ". Exit the program.");
		
		int choice = input.nextInt();
		input.nextLine(); // get rid of end of line
		while (choice < ADD_DONOR || choice > QUIT )
		{
			System.out.println("Illegal choice, please re-enter a value");
			choice = input.nextInt();
			input.nextLine(); // get rid of end of line
		}
		return choice;
	}
}
