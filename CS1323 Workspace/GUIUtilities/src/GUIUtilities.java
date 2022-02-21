import javax.swing.JOptionPane;
/** A class of utility methods that wrap a JOPtionPane and provide
 * easy access to int, double, String, and boolean types.
 * 
 * @author Emily
 * @version 1.0
 */
public class GUIUtilities 
{
	/** Create an input dialog with the given prompt that returns an int value. If users are not perfect, 
	 * i.e., if mistakes are made in data entry, such as entering the wrong data type, the method will break.
	 * 
	 * @param prompt The instructions to the user. 
	 * @return The int value the user enters.
	 */
	public static int getIntDialog(String prompt)
	{
		String resultString = JOptionPane.showInputDialog(prompt);
		int result = Integer.parseInt(resultString);
		return result;
	}
	/** Create an input dialog with the given prompt that returns a double value. If users are not perfect, 
	 * i.e., if mistakes are made in data entry, such as entering the wrong data type, the method will break.
	 * 
	 * @param prompt The instructions to the user. 
	 * @return The double value the user enters.
	 */
	public static double getDoubleDialog(String prompt)
	{
		String resultString = JOptionPane.showInputDialog(prompt);
		double result = Double.parseDouble(resultString);
		return result;		
	}
	/** Create an input dialog with the given prompt that returns a String value.
	 * 
	 * @param prompt The instructions to the user. 
	 * @return The value the user enters.
	 */
	public static String getStringDialog(String prompt)
	{
		return JOptionPane.showInputDialog(prompt);
	}
	/** Create an input dialog with the given prompt that returns a boolean value. 
	 * 
	 * @param prompt The instructions to the user. 
	 * @return The boolean value the user enters. The method compares all input to "true" (ignoring case). 
	 * All other inputs will return false. Even " true" will return false. If users enter either "True" / "true" / "TRUE" / etc or "false", 
	 * the value they enter will be returned. Else, the value returned will simply be false (because it will not match IgnoreCase("true")).
	 */
	public static boolean getBooleanDialog(String prompt)
	{
		String resultString = JOptionPane.showInputDialog(prompt);
		boolean result = Boolean.parseBoolean(resultString);
		return result;
	}
}

