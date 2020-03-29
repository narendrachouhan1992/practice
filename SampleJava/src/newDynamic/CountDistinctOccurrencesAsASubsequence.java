package newDynamic;

public class CountDistinctOccurrencesAsASubsequence {
	int getValue(String pat, String text)
	{
		int m = pat.length();
		int n = text.length();
		int[][] dp = new int[m+1][n+1];
		
		for(int i=1; i<=m;i++)
		{
			dp[i][0] = 0;
		}
		for(int i =0;i<=n;i++)
		{
			dp[0][i]=1;
		}
		for(int i=1;i<=m;i++)
			for(int j=1;j<=n;j++)
			{
				if(pat.charAt(i-1)==text.charAt(j))
				{
					dp[i][j] = dp[i-1][j-1]+ dp[i][j-1];
				}
				else
				{
					dp[i][j] = dp[i][j-1];
				}
			}
		
		return dp[m][n];
	}
	public static void main(String[] args) {
		String T = "ge";
	    String S = "geeksforgeeks";
	    CountDistinctOccurrencesAsASubsequence obj = new CountDistinctOccurrencesAsASubsequence();
	    System.out.println(obj.getValue(T, S));
	}
}
