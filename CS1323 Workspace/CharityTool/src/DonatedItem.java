
/**
 * 
 * @author Emily
 *
 */
public class DonatedItem 
{
	private String name;
	private double value;
	
	/**
	 * Construct a donated item with a given name and value.
	 * 
	 * @param item The name of the item (i.e. "women's shirt").
	 * @param valueOfItem The value of the item.
	 */
	public DonatedItem(String item, double valueOfItem)
	{
		name = item;
		value = valueOfItem;
	}
	
	/**Return the name of the item.
	 * 
	 * @return the item's name
	 */
	public String getItemName()
	{
		return name;
	}
	/**Return the value of an item in terms of currency.
	 * 
	 * @return the item's value in dollars
	 */
	public double getItemValue()
	{
		return value;
	}
	
	/** Show the item as a String. The result shown is:
	 *  item name: item's value
	 *  
	 *  @return A String showing the item's name and value side by side, separated by a colon.
	 * 
	 */
	public String toString()
	{
		return "" + name + ": " + value + " ";
	}
}
