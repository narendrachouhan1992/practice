package newDynamic;

public class NumberOfPermutationWithKInversions {
	int getCount(int N, int K)
	{
		int[][] dp = new int[N+1][K+1];
		
		for(int i =1;i<=N;i++)
		{
			dp[i][0]=1;
		}
		for(int i =0;i<=K;i++)
		{
			dp[0][i] = 0;
		}
		
		for(int i =1;i<=N;i++)
		{
			for(int j = 1;j<=K;j++)
			{
				
				for(int k = j;k>=0;k--)
				{
					dp[i][j] += dp[i-1][k]; 
				}
			}
		}
		return dp[N][K];
	}
	public static void main(String[] args) {
		NumberOfPermutationWithKInversions obj = new NumberOfPermutationWithKInversions();
		System.out.println(obj.getCount(3, 2));
	}
}
