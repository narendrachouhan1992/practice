package newDynamic;

public class ShortestUncommonSubsequenceDyn {
	static int MAX = 10000;
	int getMinUnc(String s1, String s2)
	{
		int l1 = s1.length();
		int l2 = s2.length();
		int[][] dp = new int[l1+1][l2+1];
		for(int i =0;i<=l1;i++)
			dp[i][0] = 1;			
		for(int i=0;i<=l2;i++)
			dp[0][i] = MAX;
		
		for(int i=1;i<=l1;i++)
		{
			for(int j=1;j<=l2;j++)
			{
				 char ch = s1.charAt(i-1);
		            int k;
		            for (k = j-1; k >= 0; k--)
		                if (s2.charAt(k) == ch)
		                    break;
		 
		            // char not present in T
		            if (k == -1)
		                dp[i][j] = 1;
		            else
		               dp[i][j] = Integer.min(dp[i-1][j], dp[i-1][k] + 1);
			}
		}
		return 0;
	}
}
