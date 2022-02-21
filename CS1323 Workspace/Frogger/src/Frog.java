/**
 * 
 * @author Emily
 *
 */
public class Frog 
{

	// instance data
	private int row;
	private int column;
	
	//class data
	public static final char SYMBOL = '*';
	
	//constructor
	public Frog(int r, int c)
	{
		row = r;
		column = c;
	}
	
	/**Return the row location of the Frog.
	 * 
	 */
	public int getRow()
	{
		return row;
	}
	/**Return the column location of the Frog.
	 * 
	 */
	public int getCol()
	{
		return column;
	}
	
	public void moveLeft()
	{
		column = column - 1;
	}
	
	public void moveRight()
	{
		column = column + 1;
	}
	
	public void moveUp()
	{
		row = row - 1;
	}
	
	public void moveDown()
	{
		row = row + 1;
	}
	
	/**Display the row and column of the frog.
	 * 
	 * 
	 */
	public String toString()
	{
		return "Frog: ROW: " + row + " COLUMN: " + column;
	}
	//for testing
	public static void main(String[] args)
	{
		Frog frog = new Frog (10, 10);
		
		System.out.println("The frog is at 10, 10.");
		for(int i = 0; i < 10; ++i)
		{
			double rand = Math.random();
			if (rand < .25)
			{
				frog.moveRight();
				System.out.println("Right : " + frog.row + ", " + frog.column);
			}
			else if (rand < .50)
			{
				frog.moveLeft();
				System.out.println("Left : " + frog.row + ", " + frog.column);
			}
			else if (rand < .75)
			{
				frog.moveUp();
				System.out.println("Up : " + frog.row + ", " + frog.column);
			}
			else
			{
				frog.moveDown();
				System.out.println("Down : " + frog.row + ", " + frog.column);
			}
		}
	}

}
