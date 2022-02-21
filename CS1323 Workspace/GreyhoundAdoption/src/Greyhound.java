import java.util.GregorianCalendar; 

/**A class that defines a dog in this database that is available for adoption.
 * 
 * @author Emily
 * @version 1.0
 */
public class Greyhound 
{
	private String name;
	private int birthYear;
	private String sex;
	private YNU catFriend;
	private YNU kidFriend;
	private YNU smallDogFriend;
	
	/**
	 * Construct a greyhound object from all instance data, if it is available.
	 * @param name The dog's given name.
	 * @param birthYear The year the dog was born (used to determine the dog's age).
	 * @param sex Female or male.
	 * @param catFriend YES if the dog is known to get along with cats, 
	 * 					NO if the dog is known to get along poorly with cats, 
	 * 					UNKNOWN if neither is known.
	 * @param kidFriend YES if the dog is known to get along with kids, 
	 * 					NO if the dog is known to get along poorly with kids, 
	 * 					UNKNOWN if neither is known.
	 * @param smallDogFriend YES if the dog is known to get along with small dogs, 
	 * 					     NO if the dog is known to get along poorly with small dogs, 
	 * 						UNKNOWN if neither is known.
	 * 
	 */
	public Greyhound(String name, int year, String sex, YNU cat, YNU kid, YNU smallDog)
	{
		this.name = name;
		birthYear = year;
		this.sex = sex;
		catFriend = cat;
		kidFriend = kid;
		smallDogFriend = smallDog;
	}
	
	/**Construct a greyhound object when only name, birth year, and sex are known.
	 * 
	 * @param name The name of the dog.
	 * @param year The year the dog was born.
	 * @param sex Female or Male.
	 */
	public Greyhound(String name, int year, String sex)
	{
		this(name, year, sex, YNU.UNKNOWN, YNU.UNKNOWN, YNU.UNKNOWN);
	}
	
	/**
	 * Returns the name of the dog.
	 * 
	 * @return name The dog's name.
	 */
	public String getName()
	{
		return name;
	}
	
	/** Returns the dog's age rounded quite a bit.
	 * 
	 * @param year The year the dog was born.
	 * @return age The age of the dog as an integer.
	 */
	public int getAge()
	{
		int year = this.birthYear;
		GregorianCalendar today = new GregorianCalendar();
		int age = (today.get(GregorianCalendar.YEAR)) - year;
		
		return age; 
	}

	public String getSex()
	{
		return sex;
	}

	public YNU getCat()
	{
		return catFriend;
	}
	public YNU getKid()
	{
		return kidFriend;
	}
	
	public YNU getSmallDog()
	{
		return smallDogFriend;
	}
}
