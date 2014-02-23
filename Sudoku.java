import java.util.*;

public class Sudoku
{
	private int[][] sudokuGrid;
	private ArrayList<GrabBag<Integer>> available;
	boolean[][] availableRowNums;
	private boolean[][] availableColNums;
	private boolean[][] availableBoxNums;
	private int square, ran;
	public Sudoku()
	{
		int x, y;
		GrabBag<Integer> temp;
		sudokuGrid = new int[9][9];
		available = new ArrayList<GrabBag<Integer>>(81);
		for (int i=0; i<81; i++)
		{
			temp = new GrabBag<Integer>();
			for (int j=0; j<9; j++)
			{
				temp.add(new Integer(j));
			}
			available.add(temp);
		}
		while(square<81 && square > -1)
		{
			x = square % 9;
			y = square / 9;
			if (available.get(square).isEmpty())
			{
				for (int i=0; i<9; i++)
					available.get(square).add(new Integer(i));
				sudokuGrid[x][y] = 0;
				square--;
				continue;
			}
			do
			{
				ran = available.get(square).getRandom();
				if (conflicts(ran))
				{
					//System.out.println((ran+1)+" conflicts on space ("+x+","+y+")");
					available.get(square).remove(new Integer(ran));
					//if (available.get(square).contains(new Integer(ran)))
						//System.out.println("Failed to remove "+(ran+1)+" from space ("+x+","+y+")");
				}			
				else
				{	
					sudokuGrid[x][y] = ran+1;
					square++;
					//System.out.println("Successfully added "+(ran+1)+" to space ("+x+","+y+")");
					break;
				}
			}while (!available.get(square).isEmpty() && conflicts(ran));
			//printGrid();
		}
	}
	private boolean conflicts(int num)
	{
		return (searchCol(num) || searchRow(num) || searchBox(num));
	}
	private boolean searchCol(int num)
	{
		int x = square % 9;
		for(int i=0; i<9; i++)
		{
			if (sudokuGrid[x][i] == num+1)
				return true;
		}
		return false;
	}
	private boolean searchRow(int num)
	{
		int y = square / 9;
		for(int i=0; i<9; i++)
		{
			if (sudokuGrid[i][y] == num+1)
				return true;
		}
		return false;
	}
	private boolean searchBox(int num)
	{
		int x = square % 9;
		int y = square / 9;
		//System.out.println("Square="+square+". On space ("+x+","+y+"), checking if "+(num+1)+" conflicts with box.");
		for (int i=3*(y/3); i<3*(y/3)+3; i++)
		{
			for (int j=3*(x/3); j<3*(x/3)+3; j++)
			{
				if (sudokuGrid[j][i] == num+1)
					return true;
				/*System.out.print("Checking space ("+j+","+i+") with number "+sudokuGrid[j][i]+". ");
				if (sudokuGrid[j][i] == num+1)
				{
					System.out.println("Found conflict.");
					return true;
				}
				else
				{
					System.out.println("No conflict found");
				}*/
			}
		}
		return false;
	}
	public int[][] getGrid()
	{
		return sudokuGrid;
	}
	public void printGrid()
	{
		int tempi;
		for (int i=0; i<11; i++)
		{
			if (i == 3 || i == 7)
			{
				for (int j=0; j<11; j++)
				{
					System.out.print("-");
				}
			}
			else
			{	
				tempi = i;
				if (i>3)
					tempi--;
				if (i>7)
					tempi--;
				 
				for (int j=0; j<9; j++)
				{
					
					System.out.print(sudokuGrid[j][tempi]);
					if (j == 2 || j == 5)
					{
						System.out.print("|");
					}
				}
			}
			System.out.println();
		}
		System.out.println("\n\n");
	}

}