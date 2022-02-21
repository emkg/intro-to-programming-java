/*
 * 3 items bought at glamazon.com
 * mascara - 8.99
 * lipstick - 3.99
 * eye shadow - 6.89
 * taxes are 6.5%
 * shipping is $8
 * number of items is  int
 * cost of items double
 * name of items String
 * tax rate double
 * shipping cost double
 * total cost double
 */

import java.util.Scanner;

public class Glamazon 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		int numberMascara;
		String mascara = "mascara";
		double priceMascara = 8.99;
		
		int numberLipstick;
		String lipstick = "lipstick";
		double priceLipstick = 3.99;
		
		int numberEyeshadow;
		String eyeshadow = "eyeshadow";
		double priceEyeshadow = 6.89;
				
		double totalPrice = 0.0;
		double taxRate = 0.065;
		double shippingCost = 8.00; 
			
		//Get the number of mascara, lipstick, and eyeshadows that are purchased
		System.out.println("How many " + mascara + 
				" do you wish to purchase?");
		numberMascara = input.nextInt();
		
		System.out.println("How many " + lipstick + 
				" do you wish to purchase?");
		numberLipstick = input.nextInt();
		
		System.out.println("How many " + eyeshadow + 
				" do you wish to purchase?");
		numberEyeshadow = input.nextInt();		
		
		//Calculate price of full purchase
		totalPrice = numberMascara * priceMascara 
						+numberLipstick * priceLipstick
						+numberEyeshadow * priceEyeshadow;
		
		//Calculate the actual tax amount
		double tax = totalPrice * taxRate;
		tax = tax + .005;
		tax = (int)(tax * 100)/100.0;
						
		//Show receipt to consumer
		System.out.println("You ordered:");
		System.out.println(" " + numberMascara + " " + mascara);
		System.out.println(" " + numberLipstick + " " + lipstick);
		System.out.println(" " + numberEyeshadow + " " + eyeshadow);
		System.out.println(" ");
		System.out.println("Subtotal: $" + totalPrice);
		
		//Calculate the total with tax
		totalPrice = totalPrice + tax;
		
		if (totalPrice == 0)
		{
		shippingCost = 0.0;
		System.out.println("You owe us nothing!");
		}
		else
		{
		totalPrice = totalPrice + shippingCost;
		//Continue with receipt
		System.out.println(" ");
		System.out.println("Tax: $" + tax);
		System.out.println("Shipping: $" + shippingCost);
		System.out.println(" ");
		System.out.println("Total: $" + (totalPrice + tax + shippingCost));
		}
	}
}
