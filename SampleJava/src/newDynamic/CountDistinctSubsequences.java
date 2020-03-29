package newDynamic;

import java.util.Arrays;

public class CountDistinctSubsequences {
	int MAX = 256;
	int getCount(String str)
	{
		int[] last = new int[MAX];
		Arrays.fill(last, -1);
		
		int n = str.length();
		int[] dp = new int[n+1];
		
		dp[0]= 1;
		
		for(int i =1;i<=n;i++)
		{
			dp[i] = 2*dp[i-1];
			
			if(last[str.charAt(i-1)]  != -1)
			{
				dp[i] -= dp[last[str.charAt(i-1)]];
			}
			last[str.charAt(i-1)] = i -1;
		}
		return dp[n];
	}
	public static void main(String[] args) {
		CountDistinctSubsequences obj = new CountDistinctSubsequences();
		System.out.println(obj.getCount("gfg"));
	}
}
