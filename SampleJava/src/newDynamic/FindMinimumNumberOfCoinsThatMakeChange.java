package newDynamic;

public class FindMinimumNumberOfCoinsThatMakeChange {
	static int getmin(int n, int[] arr)
	{
		if(arr.length==0)
			return Integer.MAX_VALUE;
		if(n==0)
		{
			return 0;
		}
		int[] dp = new int[n+1];
		for (int i = 1; i <= n; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		for(int i =1;i<=n;i++)
		{
			for(int j=0;j<arr.length;j++)
			{
				if(i>=arr[j])
				{
					int sub_str = dp[i-arr[j]];
					if(sub_str!= Integer.MAX_VALUE)
					{
						dp[i] = Integer.min(dp[i], 1+sub_str);
					}
				}
			}
		}
		return dp[n];
	}
	public static void main(String[] args) {
		int[] coins =  {9, 6, 5, 1};
		System.out.println(getmin(11, coins));
	}
}
