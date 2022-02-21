import java.text.DecimalFormat;
import java.util.ArrayList;

/** Store donations made to charity.  A donation consists of money and/or items
 * that are donated to be sold.
 * @author Deborah A. Trytten
 *
 */
public class Donation 
{
	private ArrayList<DonatedItem> items;
	private double money;
	
	/** Construct a donation with money. Items can be added later.
	 * 
	 * @param money The amount of money donated.
	 */
	public Donation(double money)
	{
		items = new ArrayList<DonatedItem>();
		this.money = money;
	}
	
	/** Create a donation object with no money or donated items.
	 * 
	 */
	public Donation()
	{
		this(0.0);
	}
	
	/** Add a donated item.
	 * 
	 * @param name The name of the donated item.
	 * @param cost The cost of the donated item.
	 */
	public void addItem(String name, double cost)
	{
		DonatedItem d = new DonatedItem(name, cost);
		items.add(d);
	}
	
	/** Return a list of the items that were part of this donation.
	 * 
	 * @return An Arraylist containing the items that were part of this donation.
	 */
	public ArrayList<DonatedItem> getDonatedItems()
	{
		return items;
	}
	
	/** Return the amount of money that was donated.
	 * 
	 * @return  The amount of money that was donated.
	 */
	public double getMoney()
	{
		return money;
	}
	
	/** Return a String summarizing this donation.
	 * 
	 */
	public String toString()
	{
		String result = "";
		DecimalFormat df = new DecimalFormat("$0.00");  // one place to the left and two
		// to the right of the decimal are required
		
		// don't be rude to donors by listing $0.00 in cash
		if (money > 0.0)
		{
			result += "Cash:" + df.format(money) + "\n";
		}
		
		// Add the donated items, one at a time.
		for (DonatedItem d: items)
		{
			result += d.toString()+ "\n";
		}
		
		return result;
	}
}
