/**A class that joins a pair of strings, known as a key and a value. The key is used
 * to retrieve the value.
 * 
 * @author Emily
 *
 */
public class StringPair 
{
	//instance data	
	private String key;
	private String value;
	
	/**
	 * Construct a pair of Strings.
	 * 
	 */
	public StringPair(String k, String v)
	{
		key = k;
		value = v;
	}
	/** Accesses the key of a StringPair.
	 * 
	 * @return The key.
	 */
	public String getKey()
	{
		return key;
	}
	/** Accesses the value of a StringPair.
	 * 
	 * @return The value.
	 */
	public String getValue()
	{
		return value;
	}
	
	
	/**Determine whether the two StringPairs have matching keys.
	 * 
	 * @param other
	 * @return True if the implicit object and the other have the same key.
	 */
	public boolean equals(StringPair other)
	{
		return this.key.equals(other.key);
	}
	
	/** Determine the ordering of the StringPair objects based on the key.
	 * 
	 * @param other A different StringPair which will be compared with this one.
	 * @return The number 0 if the argument object's key is equal to this object's key,
	 * a number less than 0 is this object's key is less than the argument object's key, or a number
	 * greater than 0 if this object's key is greater than the argument object's key.
	 */
	public int compareTo(StringPair other)
	{
		return this.key.compareTo(other.key);
	}
	
	/** Show the key and the value of this StringPair as a String.
	 * 
	 * @return A String containing the key and its value, labeled as such.
	 */
	public String toString()
	{
		return "Key: " + key + "Value: " + value;
	}
}


