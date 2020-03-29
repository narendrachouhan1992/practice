package newDynamic;

public class MiniMumpointReqToReachEnd {
	static int getMinNum(int[][] arr)
	{
		int M= arr.length;
		int N = arr[0].length;
		int[][] dp = new int[M][N];
		dp[M-1][N-1] = arr[M-1][N-1]>=0? 1: Math.abs(arr[M-1][N-1])+1;
		
		for(int m = M-2;m>=0;m--)
		{
			dp[m][N-1] = Integer.max((dp[m+1][N-1]-arr[m][N-1]), 1);
		}
		for(int n = N-2;n>=0;n--)
		{
			dp[M-1][n] = Integer.max((dp[M-1][n+1]-arr[M-1][n]), 1);
		}
		for(int m = M-2;m>=0;m--)
		{
			for(int n = N-2;n>=0;n--)
			{
				int min_point_on_exit = Integer.min(dp[m][n+1], dp[m+1][n]);
				dp[m][n] = Integer.max(min_point_on_exit-arr[m][n],1);
			}
		}
		return dp[0][0];
	}
	public static void main(String[] args) {
		int[][] arr = { {-2,-3,3},
                {-5,-10,1},
                {10,30,-5}};
		System.out.println(getMinNum(arr));
	}
}
