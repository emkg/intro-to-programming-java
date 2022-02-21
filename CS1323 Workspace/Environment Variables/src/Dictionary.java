import java.util.ArrayList;
/**
 * 
 * @author Emily
 *
 */
public class Dictionary 
{
	//instance data
	private ArrayList<StringPair> dictionary;
	
	
	/**Construct a new Dictionary object.
	 * 
	 */
	public Dictionary()
	{
		dictionary = new ArrayList<StringPair>();
	}
	
	/** Insert a new key and value in to the dictionary. If the key is already in 
	 * the dictionary the method returns without making any changes.
	 * 
	 * @param key The key to be inserted--which cannot be in the dictionary already.
	 * @param value The value to be inserted into the dictionary.
	 * 
	 */
	public void put(String key, String value)
	{
		StringPair entry = new StringPair(key, value);
		if (findKeyIndex(key) != -1)
			return;
		else
			this.dictionary.add(entry);
		
		return;
	}
	/**
	 * 
	 */
	public void remove(String key)
	{
		if(findKeyIndex(key) == -1)
			return;
		else
			this.dictionary.remove(findKeyIndex(key));
		
	}
	
	/** Find the index of the StringPair with the matching key.
	 * 
	 * @param key The key this method is searching for in the dictionary.
	 * @return The index of the matching key or -1 is the key is unique.
	 */
	private int findKeyIndex(String key)
	{
		for (int i = 0; i < dictionary.size(); ++i)
		{
			StringPair comparePair = dictionary.get(i); 
			if(key.equals(comparePair.getKey()))
			{
				return i;
			}
		}
		
		return -1;
	}
	/** Finds the value of the given key contained in the StringPair object with that key.
	 * 
	 * @param key The key of the StringPair whose value will be returned.
	 * @return The value that corresponds with the key argument for the StringPair object with that key.
	 */
	public String getValue(String key)
	{
		int index = findKeyIndex(key);
		return (dictionary.get(index)).getValue(); 
	}
	/** Determines if the dictionary is empty (true) or not (false).
	 * 
	 * @return True if the dictionary is empty, false if it is not empty.
	 */
	public boolean isEmpty()
	{
		return dictionary.isEmpty();
	}
	
	/** Returns a list of all the keys in the dictionary.
	 * 
	 * @return An ArrayList containing all the keys currently stored in the dictionary. 
	 */
	public ArrayList<String> getAllKeys()
	{
		ArrayList<String> allKeys = new ArrayList<String>();
		for(StringPair p: dictionary)
		{
			allKeys.add(p.getKey());
		}
		
		return allKeys;
	}
}
