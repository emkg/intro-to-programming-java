
public class Grid 
{
	//instance data
	private char[][] grid;
	
	//class data
	public final static int ROWS = 7;
	public final static int COLS = 30;
	
	/**Constructor of a Grid object.
	 * 
	 */
	public Grid()
	{
		grid = new char[ROWS][COLS];
	}
	
	public void clearGrid()
	{
		for(int r = 0; r < ROWS; ++r)
			for(int c = 0; c < COLS; ++c)
				grid[r][c] = ' ';
	}
	
	public void displayGrid()
	{
		for(int r = 0; r < ROWS; ++r)
		{
			for(int c = 0; c < COLS; ++c)
			{
				System.out.print(grid[r][c]);
			}
			//create a space after each column is printed
			System.out.println();
		}
	}
	
	public void setGrid(int r, int c, char symbol)
	{
		if (0 <= r && r < ROWS && 0 <= c && c < COLS)
			grid[r][c] = symbol;
		else
			System.out.println("My grid isn't big enough for that position.");
	}
}
