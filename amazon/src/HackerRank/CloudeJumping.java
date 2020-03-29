package HackerRank;

public class CloudeJumping {
	static int jumpingOnClouds(int[] c) {

		int size = c.length;
		int[] dp = new int[size];
		dp[size-1] = 0;
		if(c[size-2]==0)
		{
			dp[size-2] = 1;
		}
		else
		{
			dp[size-2] = Integer.MAX_VALUE;
		}
	
		for(int i=size-3;i>=0;i--)
		{
			if(c[i]==0)
			{
				dp[i] = Integer.min(dp[i+1], dp[i+2])+1;;
			}
			else
			{
				dp[i] = Integer.MAX_VALUE;	
			}
		}
		return dp[0];
    }
}
