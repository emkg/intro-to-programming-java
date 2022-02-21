public class TestGUIUtilities
{
	public static void main(String[] args)
	{
		GUIUtilities.getIntDialog("Integer please: ");
		GUIUtilities.getDoubleDialog("Double please: ");
		GUIUtilities.getBooleanDialog("Boolean please: ");
		GUIUtilities.getStringDialog("String please: ");
		NewGUIUtilities.getIntDialog("Integer please: ");
		NewGUIUtilities.getDoubleDialog("Double please: ");
	}
}