package newDynamic;
class Numbers
{
	int num;
}
public class SolveSudoku {
	int[][] sudoku = new int[9][9];
	boolean solveSudoku()
	{
		Numbers row = new Numbers();
		Numbers col = new Numbers();
		if(!findUnassignedLocation(row, col))
		{
			return true;
		}
		
		for(int i =1;i<=9;i++)
		{
			if(isSafe(i, row, col))
			{
				sudoku[row.num][col.num] = i;
				if(solveSudoku())
				{
					return true;
				}
				sudoku[row.num][col.num] = 0;
			}
		}
	
		return false;
		
	}
	boolean usedInRow(int num, Numbers row)
	{
		for(int i=0;i<9;i++)
		{
			if(num == sudoku[row.num][i])
			{
				return true;
			}
		}
		return false;
	}
	boolean usedInCol(int num, Numbers col)
	{
		for(int i=0;i<9;i++)
		{
			if(num == sudoku[i][col.num])
			{
				return true;
			}
		}
		return false;
	}
	boolean usedInBox(int num, Numbers row, Numbers col)
	{
		int startRow;
		int startCol;
		if(row.num<3)
			startRow =0;
		else if(row.num>=3 && row.num<6)
			startRow = 3;
		else
			startRow = 6;
		
		if(col.num<3)
			startCol =0;
		else if(col.num>=3 && col.num<6)
			startCol = 3;
		else
			startCol = 6;
		
		for(int i =0;i<3;i++)
			for(int j=0;j<3;j++)
			{
				if(sudoku[i+startRow][j+startCol] == num)
					return true;
			}
		return false;
	}
	boolean isSafe(int num, Numbers row, Numbers col)
	{
		return (!usedInRow(num, row) &&
	           !usedInCol(num, col) &&
	           !usedInBox(num, row, col));
	}
	boolean findUnassignedLocation(Numbers row, Numbers col)
	{
		for(row.num = 0;row.num<9;row.num++)
			for(col.num = 0;col.num<9;col.num++)
			{
				if(sudoku[row.num][col.num] == 0)
				{
					return true;
				}
			}
		return false;
	}
	void printSudoku()
	{
		for(int i =0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				System.out.print(sudoku[i][j]+ " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		SolveSudoku obj = new SolveSudoku();
		int[][] grid = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
		obj.sudoku = grid;
		if(obj.solveSudoku())
		{
			obj.printSudoku();
		}
		else
		{
			System.out.println("no solution exist");
		}
	}
}
