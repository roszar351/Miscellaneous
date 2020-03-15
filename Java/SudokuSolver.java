import java.util.*;
import java.io.*;

public class SudokuSolver
{
	////////////////////////////////////////////////////////////////////
	// A brute force approach, not ompimized in any way therefore     //
	// very slow and unreliable                                       //
	////////////////////////////////////////////////////////////////////
	
	private static int[][] initialGrid = new int[9][9];
	private static int[][] grid = new int[9][9];
	
	public static void main(String[] args) throws IOException
	{
		boolean again = false;
		readSudokuFromFile();
	
		final long startTime = System.currentTimeMillis();
		// do
		// {
		// 	copyGridContents();
		// 	again = fillRandomly();
		// }while(!validSolution() || !again);

		copyGridContents();
		fasterSolver();

		printGrid();
		
		final long endTime = System.currentTimeMillis();
		System.out.println("Total execution time(taken after finished reading the file): " + (endTime - startTime) + "ms");
	}
	
	public static boolean readSudokuFromFile() throws IOException
	{
		File f = new File("sudokus.txt");
		if(f.exists())
		{
			Scanner in = new Scanner(f);
			
			for(int i = 0; i < initialGrid.length; i ++)
			{
				for(int j = 0; j < initialGrid[i].length; j++)
				{
					initialGrid[i][j] = in.nextInt();
				}
				
				if(in.hasNext())
					in.nextLine();
			}
			in.close();
			
			return true;
		}
		else
			return false;
	}
	
	// Very long time to solve i.e. didnt even solve it once (expected)
	public static boolean fillRandomly()
	{
		ArrayList<Integer> alreadyThereH = new ArrayList<>();
		ArrayList<Integer> alreadyThereV = new ArrayList<>();
		int temp = 0;
		long counter = 0l;
		
		for(int i = 0; i < grid.length; i++)
		{
			alreadyThereH = checkPresentNumbersHorizontal(i);
			
			for(int j = 0; j < grid[i].length; j++)
			{
				if(grid[i][j] == 0)
				{
					counter = 0l;
					alreadyThereV = checkPresentNumbersVertical(j);
					temp = (int)(Math.random() * 9 + 1);
				
					while(alreadyThereH.contains(temp) || alreadyThereV.contains(temp))
					{
						temp = (int)(Math.random() * 9 + 1);
						counter++;
						if(counter > 1000000)
						{
							return false;
						}
					}
					
					alreadyThereH.add(temp);
					grid[i][j] = temp;
				}
			}
		}
		return true;
	}

	// Uses backtracking to solve quicker
	public static boolean fasterSolver()
	{
		for(int row = 0; row < grid.length; row++) 
		{
			for(int col = 0; col < grid[row].length; col++)
			{
				if(grid[row][col] == 0)
				{
					for(int number = 1; number <= 9; number++)
					{
						if(!checkPresentNumbersHorizontal(row).contains(number) && !checkPresentNumbersVertical(col).contains(number) && !checkPresentNumbersSquare(row, col).contains(number))
						{
							grid[row][col] = number;

							if(fasterSolver())
								return true;
							else
								grid[row][col] = 0;
						}
			   		}
			  		return false;
			  	}
			}
		}
		return true;
	}
	
	public static ArrayList<Integer> checkPresentNumbersHorizontal(int row)
	{
		ArrayList<Integer> temp = new ArrayList<>();
		
		for(int j = 0; j < grid[row].length; j++)
		{
			if(grid[row][j] != 0)
				temp.add(grid[row][j]);
		}
		
		return temp;
	}
	
	public static ArrayList<Integer> checkPresentNumbersVertical(int colum)
	{
		ArrayList<Integer> temp = new ArrayList<>();
		
		for(int i = 0; i < grid.length; i++)
		{
			if(grid[i][colum] != 0)
				temp.add(grid[i][colum]);
		}
		
		return temp;
	}
	
	public static ArrayList<Integer> checkPresentNumbersSquare(int row, int colum)
	{
		ArrayList<Integer> temp = new ArrayList<>();

		for(int i = 0 + 3 * (row / 3); i < 3 * (row / 3 + 1); i++)
		{
			for(int j = 0 + 3 * (colum / 3); j < 3 * (colum / 3 + 1); j++)
			{
				if(grid[i][j] != 0)
					temp.add(grid[i][j]);
			}
		}

		return temp;
	}

	public static boolean validSolution()
	{
		return checkHorizontal() && checkVertical() && checkSquare();
	}
	
	public static boolean checkHorizontal()
	{
		ArrayList<Integer> alreadyThere = new ArrayList<>();
		
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[0].length; j++)
			{
				if(alreadyThere.contains(grid[i][j]) || grid[i][j] == 0)
					return false;
				
				alreadyThere.add(grid[i][j]);
			}
			
			alreadyThere.clear();
		}
		
		return true;
	}
	
	public static boolean checkVertical()
	{
		ArrayList<Integer> alreadyThere = new ArrayList<>();
		
		for(int i = 0; i < grid[0].length; i++)
		{
			for(int j = 0; j < grid.length; j++)
			{
				if(alreadyThere.contains(grid[j][i]) || grid[j][i] == 0)
					return false;
				
				alreadyThere.add(grid[j][i]);
			}
			
			alreadyThere.clear();
		}
		
		return true;
	}
	
	public static boolean checkSquare()
	{
		ArrayList<Integer> alreadyThere1 = new ArrayList<>();
		ArrayList<Integer> alreadyThere2 = new ArrayList<>();
		ArrayList<Integer> alreadyThere3 = new ArrayList<>();
		
		for(int i = 0; i < grid.length; i++)
		{
			if(i == 3 || i == 6)
			{
				alreadyThere1.clear();
				alreadyThere2.clear();
				alreadyThere3.clear();
			}
			
			for(int j = 0; j < grid[i].length; j++)
			{
				if(j < 3)
				{
					if(alreadyThere1.contains(grid[i][j]) || grid[i][j] == 0)
						return false;
					
					alreadyThere1.add(grid[i][j]);
				}
				else if(j < 6)
				{
					if(alreadyThere2.contains(grid[i][j]) || grid[i][j] == 0)
						return false;
					
					alreadyThere2.add(grid[i][j]);
				}
				else
				{
					if(alreadyThere3.contains(grid[i][j]) || grid[i][j] == 0)
						return false;
					
					alreadyThere3.add(grid[i][j]);
				}
			}
		}
		
		return true;
	}
	
	public static void copyGridContents()
	{
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[i].length; j++)
			{
				grid[i][j] = initialGrid[i][j];
			}
		}
	}
	
	public static void printGrid()
	{
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[i].length; j++)
				System.out.print(grid[i][j] + " ");
			
			System.out.println();
		}
	}
}