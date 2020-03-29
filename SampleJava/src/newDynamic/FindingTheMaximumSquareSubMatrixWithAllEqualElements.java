package newDynamic;

public class FindingTheMaximumSquareSubMatrixWithAllEqualElements {
	int getMaxmatrix(int[][] matrix)
	{
		int row = matrix.length;
		int column = matrix[0].length;
		int[][] dp = new int[row][column];
		int result = 0;
		for(int i =1;i<row;i++)
			for(int j = 1;j<column;j++)
			{
				if(i==0 || j==0)
					dp[i][j] = 1;
				else if(matrix[i][j] == matrix[i-1][j] && matrix[i][j] == matrix[i][j-1] &&  matrix[i][j] == matrix[i-1][j-1])
					dp[i][j] = Integer.min(dp[i-1][j-1], Integer.min(dp[i-1][j], dp[i][j-1]))+1;
				else
					dp[i][j]= 1;
				
				result = Integer.max(result, dp[i][j]);
			}
		
		return result;
	}
	public static void main(String[] args) {
		int[][] matrix =  {{ 2, 2, 3, 3, 4, 4},
                {5, 5, 7, 7, 7, 4},
                {1, 2, 7, 7, 7, 4},
                {4, 4, 7, 7, 7, 4},
                {5, 5, 5, 1, 2, 7},
                {8, 7, 9, 4, 4, 4}
              };
		FindingTheMaximumSquareSubMatrixWithAllEqualElements obj = new FindingTheMaximumSquareSubMatrixWithAllEqualElements();
		System.out.println(obj.getMaxmatrix(matrix));
	}
}
