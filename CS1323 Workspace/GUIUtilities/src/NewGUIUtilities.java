import javax.swing.JOptionPane;
public class NewGUIUtilities 
{
	public static int getIntDialog(String prompt, int low, int high)
	{
		String resultString = JOptionPane.showInputDialog(prompt);
		int result = Integer.parseInt(resultString);
		
		while (result < low || result >= high)  //result out of range !(result >= low && result < high)
		{
			resultString = JOptionPane.showInputDialog(prompt);
			result = Integer.parseInt(resultString);
		}
		
		return result;
	}
	
	public static int getIntDialog(String prompt)
	{
		return getIntDialog(prompt, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static int getIntDialog(String prompt, int high)//why can i put in args that the method doesn't ask for? oh!! it's using the one with string, int, int!!
	{
		return getIntDialog(prompt, 0, high);
	}
	
	
	
	public static double getDoubleDialog(String prompt, double low, double high)
	{
		String resultString = JOptionPane.showInputDialog(prompt);
		double result = Double.parseDouble(resultString);
		
		while (result < low || result >= high)  //result out of range !(result >= low && result < high)
		{
			resultString = JOptionPane.showInputDialog(prompt);
			result = Double.parseDouble(resultString);
		}
		
		return result;
	}
	
	public static double getDoubleDialog(String prompt)
	{
		return getDoubleDialog(prompt, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY); // MIN and MAX_VALES of Double class are not the same as with Integers
	}
	
	public static double getDoubleDialog(String prompt, double high)
	{
		return getDoubleDialog(prompt, 0, high);		
	}
	

}
