/**Modify the example program to compute the position of an object 
 * after falling for 10 seconds, outputting the position in meters. The formula in Math notation is: 
 * x(t) = 0.5 × a*t^2 + vi*t + xi 
 * Variable     Meaning                    Value 
 *   a      Acceleration  (m/s^2) 		   -9.81      
 *   t          Time       (s)               10 
 *   vi      Initial velocity (m/s)           0 
 *   xi        Initial position               0 
 *   
 *  Note: The correct value is -490.5 m. Java will output more digits after the decimal place, but that is unimportant. 
 * @author Emily
 *
 */

class GravityCalculator 
{ 
	public static void main(String[] arguments) 
	{
		double gravity = -9.81; // Earth's gravity in m/s^2
		double initialVelocity = 0.0;
		double fallingTime = 10.0;
		double initialPosition = 0.0;
		double finalPosition = (0.5 * gravity * (fallingTime * fallingTime) 
				+ (initialVelocity * fallingTime) + initialPosition);
        System.out.println("The object's position after " + fallingTime 
        		+ " seconds is " + finalPosition + " m."); //A String
	}
}