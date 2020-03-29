package newDynamic;

public class MinimumNumberofSquaresWhoseSumEqualstoGivenNumber {
	static int getmin(int n)
	{
		if(n==0)
		{
			return 1;
		}
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		dp[4] = 1;
		for (int i = 5; i <= n; i++) {
			dp[i] = i;
		}
		for(int i =2;i<=n;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(j*j>i)
				{
					int ind = (j-1)*(j-1);
					dp[i]= Integer.min(dp[i], 1+dp[i-ind]);
					break;
				}
			}
		}
		return dp[n];
	}
	public static void main(String[] args) {
		System.out.println(getmin(22));
	}
}
