package newDynamic;

public class CountSubsequencesProductLessK {
	int getProduct(int[] arr, int k)
	{
		int n = arr.length;
		int[][] dp = new int[n+1][k+1];
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=k;j++)
			{
				dp[i][j] = dp[i-1][j];
				if(arr[i-1]< j && arr[i-1]>0)
				{
					dp[i][j] += dp[i-1][j/arr[i-1]] +1;
				}
			}
		}
		return dp[n][k];
	}
	public static void main(String[] args) {
		CountSubsequencesProductLessK obj = new CountSubsequencesProductLessK();
		int[] arr = {1,2,3,4};
		System.out.println(obj.getProduct(arr, 4));
	}
}
