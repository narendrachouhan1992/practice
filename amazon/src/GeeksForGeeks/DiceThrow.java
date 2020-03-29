package GeeksForGeeks;

public class DiceThrow {
	static int findWays(int m, int n, int x)
	{
		int[][] dp = new int[n+1][x+1];
		for(int i=1;i<=m && i<=x;i++)
		{
			dp[1][i]=1;
		}
		
		
		for(int i=2;i<=n;i++)
		{
			for(int j=1;j<=x;j++)
			{
				for(int k=1;k<=j&& k<=m;k++)
				{
					dp[i][j]+=dp[i-1][j-k];
				}
			}
		}
	
		
		
		
		
		return dp[n][x];
	}
	public static void main(String[] args) {
		System.out.println(findWays(4, 2, 1));  
        System.out.println(findWays(2, 2, 3));  
        System.out.println(findWays(6, 3, 8));  
        System.out.println(findWays(4, 2, 5));  
        System.out.println(findWays(4, 3, 5));  
	}
}
