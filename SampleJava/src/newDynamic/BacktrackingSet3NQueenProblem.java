package newDynamic;

import java.util.Arrays;

public class BacktrackingSet3NQueenProblem {

	private boolean isSafe(boolean board[][], int row, int col) {
		int i, j;

		int length = board.length;
				
		for(i=row-1, j = col+1;i>=0 && j<length;j++, i--)
			if(board[i][j])
				return false;
		/* Check upper diagonal on left side */
		for(i=row-1, j = col-1;i>=0 && j>=0;j--, i--)
			if(board[i][j])
				return false;

		for(i=row-1;i>=0;i--)
			if(board[i][col])
				return false;

		return true;
	}

	private boolean solveUntill(boolean[][] mat, int pos) {
		if (pos == mat.length) {
			
			return true;
		} else {
			for (int i = 0; i < mat.length; i++) {
				if (isSafe(mat, pos, i)) {
					mat[pos][i] = true;
					if (solveUntill(mat, pos + 1)) {
						return true;
					}
					mat[pos][i] = false;
				}
			}
			return false;
		}
	}

	void solve(int num) {
		if (num < 3)
			System.out.println("not possible");
		else {
			boolean[][] mat = new boolean[num][num];
			if (solveUntill(mat, 0)) {
				for(int i=0;i<mat.length;i++)
				{
					for(int j=0;j<mat.length;j++)
					{
						if(mat[i][j])
							System.out.print("1, ");
						else
							System.out.print("0, ");
					}
					System.out.println();
					
				}
			}
		}
	}
	public static void main(String[] args) {
		BacktrackingSet3NQueenProblem obj = new BacktrackingSet3NQueenProblem();
		obj.solve(8);
	}
}
