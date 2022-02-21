import java.io.InputStreamReader;
import java.io.IOException;

/** 
 * 
 * @author Emily
 *
 */
public class Controller 
{
	//instance data
	private Grid grid;
	private Frog frog;
	private Truck[] trucks;
	
	private static final int LARGER_THAN_CONSOLE_SIZE = 20; 
	
	/**
	 * 
	 */
	public Controller()
	{
		grid = new Grid();
		frog = new Frog(Grid.ROWS-1, Grid.COLS/2);
		trucks = new Truck[Grid.ROWS-2];
		
		//randomly place trucks
		for(int t = 0; t < trucks.length; ++t)
		{
			boolean goesRight = (Math.random() < 0.50);
			trucks[t] = new Truck(t+1, (int)(Math.random()*Grid.COLS), goesRight);
		}
	}
	
	/**
	 * 
	 */
	public void moveTrucks()
	{
		for (int i = 0; i < trucks.length; ++i)
			trucks[i].move();
	}
	
	/**
	 * 
	 * @param input
	 */
	public void moveFrog(InputStreamReader input) throws IOException
	{
		if (input.ready()) //the user has entered something
		{
			char letter = (char) input.read();
			
			//Move the frog
			if (letter == 'W' || letter == 'w')
				frog.moveUp();
			if (letter == 'A' || letter == 'a')
				frog.moveLeft();
			if (letter == 'D' || letter == 'd')
				frog.moveRight();
			if (letter == 'S' || letter == 's')
				frog.moveDown();
			
			//eats the new line 
			while (input.ready())
				input.read();
		}
	}
	
	public boolean frogWins()
	{
		if (frog.getRow() == 0)
			return true;
		
		return false;
	}
	
	public boolean frogOutOfBounds()
	{
		return(frog.getRow() < 0 || frog.getRow() >= Grid.ROWS 
				|| frog.getCol() < 0 || frog.getCol() >= Grid.COLS);
	}
	
	public boolean frogAndTrucksCollide()
	{
		for(int t = 0; t < trucks.length; ++t)
		{
			if (frog.getRow() == trucks[t].getRow() 
					&& (frog.getCol() == trucks[t].getRightCol() 
						|| frog.getCol() == trucks[t].getLeftCol()))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public void clearScreen()
	{
		for (int i = 0; i < LARGER_THAN_CONSOLE_SIZE; ++i)
			System.out.println();
	}
	
	public void displayGame()
	{
		//clear screen
		clearScreen();
		//empty the grid
		grid.clearGrid();
		
		//fill the grid with trucks and show frog
		grid.setGrid(frog.getRow(), frog.getCol(), Frog.SYMBOL);
		
		for(int i = 0; i < trucks.length; ++i)
		{
			grid.setGrid(trucks[i].getRow(), trucks[i].getLeftCol(), trucks[i].getSymbol());
			grid.setGrid(trucks[i].getRow(), trucks[i].getRightCol(), trucks[i].getSymbol());
		}
		//show the grid on the screen
		grid.displayGrid();
	}
	
}
