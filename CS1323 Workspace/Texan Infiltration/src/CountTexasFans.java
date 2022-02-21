
import java.util.Scanner;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileNotFoundException;

public class CountTexasFans 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		
		Scanner file = getScanner();
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the domain: ");
		String domain = keyboard.next();
		int count = countEmailInDomain(file, domain);
		
		System.out.println("There are " + count + " users from " + domain + " in the system.");
	}

	public static int countEmailInDomain(Scanner input, String domain)
	{
		int count = 0;
		domain = domain.toLowerCase();
		while (input.hasNext())
		{
			String email = input.next();
			email = email.toLowerCase();
			if (email.endsWith(domain))
			{
				count = count +1;
				
			}
		}
		return count;
	}
	public static Scanner getScanner() throws FileNotFoundException
	{
	
		JFileChooser chooser = new JFileChooser(".");
		while (true)
		{
			
		
		    int returnVal = chooser.showOpenDialog(null);
		    if(returnVal == JFileChooser.APPROVE_OPTION) 
		    {
		    		return new Scanner(new File(chooser.getSelectedFile().getName())); 
		   	}
		}//end while
    }
}
