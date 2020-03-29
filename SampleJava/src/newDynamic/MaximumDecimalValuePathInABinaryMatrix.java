package newDynamic;

public class MaximumDecimalValuePathInABinaryMatrix {
	double getMax(boolean[][] mat)
	{
		int height = mat.length;
		int width = mat[0].length;
		double[][] dp = new double[height][width];
		for(int i = 0;i<height;i++)
		{
			for(int j = 0;j<width;j++)
			{
				if(i==0 && j==0)
				{
					dp[i][j] = mat[i][j]? Math.pow(2, (i+j)): 0;
				}
				else if(i==0)
				{
					dp[i][j] = (mat[i][j]? Math.pow(2, (i+j)): 0) + dp[i][j-1];
				}
				else if(j==0)
				{
					dp[i][j] = (mat[i][j]? Math.pow(2, (i+j)): 0) + dp[i-1][j];
				}
				else
				{
					dp[i][j] = (mat[i][j]? Math.pow(2, (i+j)): 0) + Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[height-1][width-1];
	}
	public static void main(String[] args) {
		boolean[][] mat = {{ true ,true ,false ,true },
		        { false ,true ,true ,false },
		        { true ,false ,false ,true },
		        { true ,false ,true ,true },
		    };
		MaximumDecimalValuePathInABinaryMatrix obj = new MaximumDecimalValuePathInABinaryMatrix();
		System.out.println(obj.getMax(mat));
	}
}
