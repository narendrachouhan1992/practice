package newDynamic;

public class SudokuBacktracking7 {
	static private boolean isSafe(int[][] board, int row,int col, int num)
	{
		for(int i=0;i<9;i++)
		{
			if(i!=row && board[i][col] == num)
				return false;
			if(i!=col && board[row][i] == num)
				return false;
		}
		int hq=-1;
		int vq = -1;
		if(row<3)
			vq = 0;
		else if(row<6)
			vq=1;
		else
			vq=2;
		
		if(col<3)
			hq=0;
		else if(col<6)
			hq=1;
		else
			hq=2;
		
		for(int i=vq*3;i<vq*3+3;i++)
		{
			for(int j=hq*3; j<hq+3;j++)
			{
				if(!(i==row && j==col) && board[i][j]==board[row][col])
				{
					return false;
				}
			}
		}
		return true;
	}
	static private void print(int[][] board)
	{
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				System.out.print(board[i][j]+"  ");
			}
			System.out.println();
		}
	}
	static boolean solveSudoku(int[][] board)
	{
		int row = -1;
		int col = -1;
		boolean isSolved = true;
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				if(board[i][j] != 0)
				{
					row = i;
					col = j;
					isSolved = false;
					break;
				}
			}
		}
		if(!isSolved)
		{
			for(int i=1;i<=9;i++)
			{
				
				if(isSafe(board, row, col, i))
				{
					board[row][col] = i;
					if(solveSudoku(board))
					{
						return true;
					}
					else
					{
						board[row][col]= 0;
					}
				}
				
			}
		}
		
		
		return false;
	}
	public static void main(String[] args) {
		 int[][] board = new int[][] 
	    { 
	            {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
	            {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
	            {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
	            {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
	            {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
	            {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
	            {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
	            {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
	            {0, 0, 5, 2, 0, 6, 3, 0, 0} 
	    }; 
	    if (solveSudoku(board)) 
	    { 
	        print(board); // print solution 
	    }  
	    else
	    { 
	        System.out.println("No solution"); 
	    } 
	}
}
