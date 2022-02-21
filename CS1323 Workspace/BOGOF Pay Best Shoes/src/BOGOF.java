
import java.util.*;

public class BOGOF 
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);		
		ArrayList<Double> sales;
		sales = getUserData(input);
		double cost = findCost(sales);
		
		System.out.println("THe cost of your purchase is " + cost + "0.");
	}
	
	public static ArrayList<Double> getUserData(Scanner keyboard)
	{
		ArrayList<Double> result = new ArrayList<Double>();
		
		//Priming read
		System.out.println("Enter the cost of your next purchase, or -1 to stop program.");
		double cost = keyboard.nextDouble();
		do
		{
			result.add(cost);
			//Priming read
			System.out.println("Enter the cost of your next purchase, or -1 to stop program.");
			cost = keyboard.nextDouble();
			
		}while (cost > 0);
		
		return result;
		
	}
	
	public static double findCost(ArrayList<Double> purchases)
	{
		Collections.sort(purchases);
		double cost = 0.0;
		int index = purchases.size() - 1;
		while (index >= 0)
		{
			cost = cost + purchases.get(index);
			index = index - 2; //we are counting every other item
		}
		return cost;
	}
}


