//import java.util.Scanner;

public class TestClass 
{
	
	public static void main(String [] args)
	{

		System.out.println("   J     A     V     V     A");
		System.out.println("   J    A A     V   V     A A");
		System.out.println("J  J   AAAAA     V V     AAAAA");
		System.out.println(" JJ   A     A     V     A     A");
		
		//Scanner keyboard = new Scanner(System.in);
		
		//counts the number of dogs that qualify for a national competition based on a score of over 95
		/*
		int numDogs;
		int score = 0;
		int qualifyingDogs = 0;
		
		System.out.println("How many dogs competed?");
		numDogs = keyboard.nextInt();
		
		for(int i = 0; i < numDogs; ++i)
		{
			System.out.println("Enter a score. . .");
			score = keyboard.nextInt();
				if (score > 95)
					qualifyingDogs++;
		}
		
		System.out.println(qualifyingDogs + " dogs qualified for the national competition.");
		
		keyboard.close();
		*/
		
		//dispenses coupons to users over a certain age until the coupons run out
		/*
		for(int coupons = 0; coupons < 10; ++coupons)
		{
			System.out.println("Enter your age and name to recieve a free coupon.");
			int age = keyboard.nextInt();
			String name = keyboard.next();
			if (age < 21)
			{
				System.out.println("I'm sorry, " + name + ", you must be 21 to recieve this coupon.");
				coupons--;
			}
			else
				System.out.println(name + " may have a free coupon.");			
		}
		
		System.out.println("There are no more coupons :-( . . . Please come back later!");
		*/		
		
		//uses a method that finds fees for overdue library books
		/*
		int daysOverdue = 100;
		double priceOfBook = 19.99;
				
		double fine = findFine(daysOverdue, priceOfBook);
		System.out.print("$" + fine);
		*/
	}
	/*
	public static double findFine(int daysOverdue, double priceOfBook)
	{
		double fine = 0.0;
		
		//if the book is between 7 and 14 days overdue, the fine is .25 per day.
		if (7 < daysOverdue && daysOverdue <= 14)
		{
			fine = (.25 * (daysOverdue - 7));
			return fine;
		}
		else if (daysOverdue > 14)
		{
			fine = (.50 * (daysOverdue - 14)) + (.25 * 70);
			if(fine > priceOfBook * 2)
				fine = priceOfBook * 2;
			return fine;
		}
		
		
		
		return fine;
	}
	
	*/
}
	
