
public class Truck 
{
	//instance data
	private int row;
	private int leftCol;
	private int rightCol;
	private char symbol;
	private boolean isRight;
	
	public Truck(int row, int col, boolean isRight)
	{
		this.row = row;
		leftCol = col;
		rightCol = col + 1;
		this.isRight = isRight;
		
		if (isRight)
			symbol = '>';
		else
			symbol = '<';
		
	}
	/**
	 * 
	 */
	public int getRow()
	{
		return row;
	}
	/**
	 * 
	 */
	public int getRightCol()
	{
		return rightCol;
	}
	/**
	 * 
	 */
	public int getLeftCol()
	{
		return leftCol;
	}
	/**
	 * 
	 */
	public char getSymbol()
	{
		return symbol;
	}
	
	/**
	 * 
	 */
	public void move()
	{
		if (isRight)
		{
			leftCol = (leftCol + 1) % Grid.COLS;
			rightCol = rightCol + 1;
		}
		else
		{
			leftCol = leftCol - 1;
			if (leftCol == -1)
				leftCol = Grid.COLS-1;
			rightCol = rightCol - 1;
			if (rightCol == -1)
				rightCol = Grid.COLS-1;
		}	
	}		
}
