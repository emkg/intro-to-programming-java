/** This class stores a standard U.S. address.  It does no error
 * checking at this point, although that would be a valuable addition.
 * 
 * @author Deborah  A. Trytten
 *
 */
public class Address 
{
	private String firstLine;
	private String secondLine;
	private String city;
	private String state;
	private String zipcode;
	
	/** Construct an address object.  Line2 may be null.
	 * 
	 * @param line1 The street address.
	 * @param line2 A second line for complex street addresses, may be null.
	 * @param city The city.
	 * @param state The state.
	 * @param zip The zip code.  This should be either 5 ##### or 10 #####-#### digits.
	 */
	public Address(String line1, String line2, String city, String state, String zip)
	{
		firstLine = line1;
		secondLine = line2;
		this.city = city;
		this.state = state;
		zipcode = zip;
	}
	
	/** Return the address as a String, as would be used in a typical mailing label.
	 * 
	 * @Return The address represented as a String.
	 */
	public String toString()
	{
		String result;
		result = firstLine + "\n";
		if (secondLine != null)
			result += secondLine + "\n";
		result += city + ", " + state + " " + zipcode;
		
		return result;
	}
}
