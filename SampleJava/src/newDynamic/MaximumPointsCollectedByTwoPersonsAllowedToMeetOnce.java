package newDynamic;

public class MaximumPointsCollectedByTwoPersonsAllowedToMeetOnce {
	int getMax(int[][] matrix)
	{
		int rows = matrix.length;
		int columns = matrix[0].length;
		int[][] P1S = new int[rows+1][columns+1];
		int[][] P1E = new int[rows+1][columns+1];
		int[][] P2S = new int[rows+1][columns+1];
		int[][] P2E = new int[rows+1][columns+1];
		
		
		for (int i=1; i<=rows; i++)
	        for (int j=1; j<=columns; j++)
	            P1S[i][j] = Integer.max(P1S[i-1][j],
	                  P1S[i][j-1]) + matrix[i-1][j-1];
	 
	    // Table for P1's journey from
	    // end to meet cell
	    for (int i=rows; i>=1; i--)
	        for (int j=columns; j>=1; j--)
	            P1E[i][j] = Integer.max(P1E[i+1][j],
	                  P1E[i][j+1]) + matrix[i-1][j-1];
	 
	    // Table for P2's journey from start to meeting cell
	    for (int i=rows; i>=1; i--)
	        for(int j=1; j<=columns; j++)
	            P2S[i][j] = Integer.max(P2S[i+1][j],
	                  P2S[i][j-1]) + matrix[i-1][j-1];
	 
	    // Table for P2's journey from end to meeting cell
	    for (int i=1; i<=rows; i++)
	        for (int j=columns; j>=1; j--)
	            P2E[i][j] = Integer.max(P2E[i-1][j],
	                  P2E[i][j+1]) + matrix[i-1][j-1];
		
		
	    int ans = 0;
	    for (int i=2; i<columns; i++)
	    {
	        for (int j=2; j<rows; j++)
	        {
	            int op1 = P1S[i][j-1] + P1E[i][j+1] +
	                      P2S[i+1][j] + P2E[i-1][j];
	            int op2 = P1S[i-1][j] + P1E[i+1][j] +
	                      P2S[i][j-1] + P2E[i][j+1];
	            ans = Integer.max(ans, Integer.max(op1, op2));
	        }
	    }
	    return ans;
	}
	int getMax2(int[][] matrix)
	{
		return 0;
	}
	public static void main(String[] args) {
		int A[][] = {{100, 100, 100},
                {100, 1, 100},
                {100, 100, 100}};
		MaximumPointsCollectedByTwoPersonsAllowedToMeetOnce obj = new MaximumPointsCollectedByTwoPersonsAllowedToMeetOnce();
		System.out.println(obj.getMax(A));
	}
}
