import java.util.ArrayList;

/** The data for a charity that accepts monetary and goods donations.
 * 
 * @author Deborah A. Trytten
 *
 */
public class Charity 
{
	private String name;
	private double moneyDonated;
	private ArrayList<Donor> donors;
	private ArrayList<DonatedItem> donatedItems;
	
	/** Construct a charity with the given name, and no donors or donated items.
	 * 
	 * @param name  The name of the charity.
	 */
	public Charity(String charityName)
	{
		name = charityName;
		donors = new ArrayList<Donor> ();
		donatedItems = new ArrayList<DonatedItem>();
		moneyDonated = 0.0;
	}
	
	/** Locate a donor already in the system.
	 * 
	 * @param name The name of the donor--foolishly assumed to be unique.
	 * @return A reference to the named donor object or null if no such donor exists.
	 */
	// During final implementation, this method was made public so it could be used in
	// the Driver class
	public Donor findDonor(String name)
	{
		for(Donor d: donors)
		{
			if (d.getName().equals(name))
				return d;
		}
		
		return null;
	}
	
	/** Add a new donor for the charity.  If a donor with this name is found, the method
	 * returns.  This will create havoc when we get two donors with the same name.
	 * 
	 * @param name The name of the donor.
	 * @param address Their current address.
	 */
	public void addDonor(String name, Address address)
	{
		// Don't add in people repeatedly.  This makes the naive assumption 
		// that names are unique.
		if (findDonor(name) != null)
			return;
		
		Donor donor = new Donor(name, address);
		donors.add(donor);
	}
	
	/** Allow a donor with the given name to make a donation.  If the donor is not
	 * already in the system, you will have to add them before calling this method.
	 * @param name The name of the donor, foolishly assumed to be unique.
	 * @param donation A donation that consists of cash and donated items.
	 */
	public void makeDonation(String name, Donation donation)
	{
		Donor donor = findDonor(name);
		donor.addDonation(donation);
	}
	
	/** Find the monetary value of donations made to the charity.
	 * 
	 * @return 
	 */
	public double findValueAllDonations()
	{
		double money = 0.0;
		for (Donor don: donors)
		{
			money = don.getValueOfAllDonations();
		}
		
		return money;
	}
	
	public double findValueOneDonor(String name)
	{
		Donor donor = findDonor(name);
		return donor.getValueOfAllDonations();
	}
	
}
