package newDynamic;

public class MaxPossiblePathWithAtMostKTurn {

	int MAX = 100;
	// table to store to store results of subproblems
	int[][][][] dp = new int[MAX][MAX][MAX][2];
	 
	int countPathsUtil(int i, int j, int k, int d)
	{
	    // If invalid row or column indexes
	    if (i < 0 || j < 0)
	        return 0;
	 
	    // If current cell is top left itself
	    if (i == 0 && j == 0)
	        return 1;
	 
	    // If 0 turns left
	    if (k == 0)
	    {
	        // If direction is row, then we can reach here 
	        // only if direction is row and row is 0.
	        if (d == 0 && i == 0) return 1;
	 
	        // If direction is column, then we can reach here 
	        // only if direction is column and column is 0.
	        if (d == 1 && j == 0) return 1;
	 
	        return 0;
	    }
	 
	    // If this subproblem is already evaluated
	    if (dp[i][j][k][d] != -1)
	        return dp[i][j][k][d];
	 
	    // If current direction is row, then count paths for two cases
	    // 1) We reach here through previous row.
	    // 2) We reach here through previous column, so number of 
	    //    turns k reduce by 1.
	    if (d == 0)
	      return dp[i][j][k][d] = countPathsUtil(i, j-1, k, d) +
	                              countPathsUtil(i-1, j, k-1, 1);
	 
	    // Similar to above if direction is column
	    return dp[i][j][k][d] =  countPathsUtil(i-1, j, k, d) +
	                             countPathsUtil(i, j-1, k-1, 0);
	}
	 
	// This function mainly initializes 'dp' array as -1 and calls
	// countPathsUtil()
	int countPaths(int i, int j, int k)
	{
	    // If (0, 0) is target itself
	    if (i == 0 && j == 0)
	          return 1;
	 
	    for (int k2 = 0; k2 < MAX; k2++) {
			for (int l = 0; l < MAX; l++) {
				for (int l2 = 0; l2 < MAX; l2++) {
					for (int m = 0; m < 2; m++) {
						dp[k2][l][l2][m] = -1;
					}
				}
			}
		}
	 
	    // Recur for two cases: moving along row and along column
	    return countPathsUtil(i-1, j, k, 1) +  // Moving along row
	           countPathsUtil(i, j-1, k, 0); // Moving along column
	}
	public static void main(String[] args) {
		 int m = 3, n = 3, k = 2;
		 MaxPossiblePathWithAtMostKTurn obj = new MaxPossiblePathWithAtMostKTurn();
		  System.out.println("Number of paths is "+ obj.countPaths(m-1, n-1, k));
	}
}
