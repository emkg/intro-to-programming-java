import java.util.ArrayList;
/**
 * This class stores the data for a donor to a charity. 
 * @author Emily
 *
 */
public class Donor 
{
	private String name;
	private Address address;
	private ArrayList<Donation> donations;
	
	/** Construct a donor object with the given name and address.
	 * 
	 * @param donorName The donor's name
	 * @param donorAddress The donor's address
	 */
	public Donor(String donorName, Address donorAddress)
	{
		name= donorName;
		address = donorAddress;
		
		donations = new ArrayList<Donation>();
	}
	
	/**
	 * Return the donor's name.
	 * 
	 * @return the donor's name
	 */

	public String getName()
	{
		return name;
	}
	
	/**
	 * Return the donor's address.
	 * 
	 * @return the donor's address
	 */
	public Address getAddress()
	{
		return address;
	}
	
	/** Return the value of all donations made by one donor, including cash and items.
	 * 
	 * @return The value of all donations made by the donor in terms of dollars.
	 * 
	 */
	public double getValueOfAllDonations()
	{
		double totalValue = 0.0;
		
		//step through all donations made by the donor and add the values of cash and items
		for(Donation don: donations)
		{
			totalValue += don.getMoney();
			ArrayList<DonatedItem> list = don.getDonatedItems();
			for(DonatedItem i: list)
			{
				totalValue += i.getItemValue();
			}
		}
		
		return totalValue;
	}
	
	/** Add a donation to the total donations made by one donor.
	 * 
	 * @param don The donation (cash or item) that the donor just made.
	 * 
	 */
	public void addDonation(Donation don)
	{
		donations.add(don);
	}
}

