package newDynamic;

public class SequencesGivenLengthEveryElementEqualTwicePrevious {
	int getCount(int n, int m)
	{
		int[][] dp = new int[n+1][m+1];
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=m;j++)
			{
				 if (i == 0 || j == 0)
                    dp[i][j] = 0;
 
                // if length of sequence is more than
                // the maximum value, special sequence
                // cannot exist
                else if (i > j)
                    dp[i][j] = 0;
                else if(i == 1)
					dp[i][j] = 1;
                else
                {
                	dp[i][j] = dp[i][j-1] + dp[i-1][j/2];
                }
			}
		}
		return dp[n][m];
	}
	public static void main(String[] args) {
		SequencesGivenLengthEveryElementEqualTwicePrevious obj = new SequencesGivenLengthEveryElementEqualTwicePrevious();
		int m = 10;
	    int n = 4;
	    System.out.println(obj.getCount(n, m));
	}
}
