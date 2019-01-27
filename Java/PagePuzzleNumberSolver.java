import java.util.*;

public class PagePuzzleNumberSolver
{
	/*		
	 *		int, sign, int, sign, int   = int
	 *		sign, not, sign, not, sign
	 *		int, sign, int, sign, int   = int
	 *		sign, not, sign, not, sign
	 *		int, sign, int, sign, int   = int
	 *		 ||         ||         ||
	 *      int        int        int 
	 *		
	 *		   0     1
	 *		2     3     4
	 *		   5     6
	 *		7     8     9
	 *		   10    11  
	 *	
	 *		char default = '\u0000'
	 *
	 *
	 *
	 *
	 */
	public static void main(String[] args)
	{
		int[][] grid 		= fillGridRandom();
		char[] signs 		= new char[12];
		int[] verticalAns 	= new int[3];
		int[] horizontalAns = new int[3];
		
		fillSigns(signs);
		fillAns(verticalAns, horizontalAns);
		
		final long startTime = System.currentTimeMillis();
		
		while(!checkSolution(grid, signs, verticalAns, horizontalAns))
		{
			grid = fillGridRandom();
		}
		
		printGrid(grid);
		
		final long endTime = System.currentTimeMillis();
		System.out.println("Total execution time(taken after user finishes inputs): " + (endTime - startTime) + "ms");
	}
	
	public static void fillSigns(char[] s)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Fill in the signs: ");
		for(int i = 0; i < s.length; i++)
			s[i] = in.nextLine().charAt(0);	
	}
	
	public static void fillAns(int[] v, int[] h)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Fill verticalAns: ");
		for(int i = 0; i < v.length; i++)
			v[i] = Integer.parseInt(in.nextLine());
		
		System.out.println("Fill horizontalAns: ");
		for(int i = 0; i < h.length; i++)
			h[i] = Integer.parseInt(in.nextLine());
	}
	
	public static int[][] fillGridRandom()
	{
		ArrayList<Integer> alreadyUsed = new ArrayList<>();
		int[][] grid = new int[3][3];
		int temp = 0;
		
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[i].length; j++)
			{
				temp = (int)(Math.random() * 9 + 1);
				while(alreadyUsed.contains(temp))
					temp = (int)(Math.random() * 9 + 1);
				alreadyUsed.add(temp);
				grid[i][j] = temp;
			}
		}
		
		return grid;
	}
	
	public static boolean checkSolution(int[][] g, char[] s, int[] v, int[] h)
	{
		// check vertical answers
		// signs 0 1 then 5 6 then 10 11
		int firstSign  = 0;
		int secondSign = 1;
		
		for(int i = 0; i < g.length; i++)
		{	
			if(calculate(s[secondSign], calculate(s[firstSign], g[i][0], g[i][1]), g[i][2]) != v[i])
				return false;
				
			firstSign += 5;
			secondSign += 5;
		}
		
		// check horizontal answers
		// signs 2 7 then 3 8 then 4 9
		firstSign  = 2;
		secondSign = 7;
		
		for(int i = 0; i < g[0].length; i++)
		{	
			if(calculate(s[secondSign], calculate(s[firstSign], g[0][i], g[1][i]), g[2][i]) != h[i])
				return false;
				
			firstSign++;
			secondSign++;
		}
		
		return true;
	}
	
	public static int calculate(char c, int n1, int n2)
	{
		switch(c)
		{
			case '+': return n1 + n2;
			case '-': return n1 - n2;
			case '*': return n1 * n2;
			case '/': return n1 / n2;
			default: 
				System.out.println("ERROR IN SWITCH");
				return -1;
		}
	}
	
	public static void printGrid(int[][] g)
	{
		for(int i = 0; i < g.length; i++)
		{
			for(int j = 0; j < g[i].length; j++)
			{
				System.out.print(g[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void printGrid(int[][] g, char[] s, int[] v, int[] h)
	{
		
		for(int i = 0; i < g.length; i++)
		{
			for(int j = 0; j < g[i].length; j++)
			{
				System.out.print(g[i][j] + " ");
			}
			System.out.println(" ");
		}
		for(int i = 0; i < s.length; i++)
				System.out.print(s[i] + "  ");
		
		System.out.println("\n" + v[0] + "   " + v[1] + "   " + v[2]);
		System.out.println(h[0] + "   " + h[1] + "   " + h[2]);
	}
}