package newDynamic;

public class CountBinaryStringsKTimesAppearingAdjacentTwoSetBits {
	int getNumber(int n, int k)
	{
		int[][][] dp = new int[n+1][k+1][2];
   
    // If n = 1 and k = 0. 
    dp[1][0][0] = 1;
    dp[1][0][1] = 1;
 
    for (int i=2; i<=n; i++)
    {
        // number of adjacent 1's can not exceed i-1
        for (int j=0; j<i && j<=k; j++)
        {
            dp[i][j][0] = dp[i-1][j][0] + dp[i-1][j][1];
            dp[i][j][1] = dp[i-1][j][0];
 
            if (j-1 >= 0)
                dp[i][j][1] += dp[i-1][j-1][1];
        }
    }
 
    return dp[n][k][0] + dp[n][k][1];
	}
	public static void main(String[] args) {
		CountBinaryStringsKTimesAppearingAdjacentTwoSetBits obj = new CountBinaryStringsKTimesAppearingAdjacentTwoSetBits();
		System.out.println(obj.getNumber(5, 2));
	}
}
