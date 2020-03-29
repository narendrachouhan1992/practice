package newDynamic;

public class ModifyArrayToMaximizeSumOfAdjacentDifferences {
	int getMax(int[] arr)
	{
		int n = arr.length;
		int[][] dp = new int[n][2];
		
		for(int i=0;i<(n-1);i++)
		{
			dp[i+1][0] = Integer.max(dp[i][0]+ Math.abs(arr[i+1]- arr[i]), dp[i][1]+ Math.abs(1-arr[i+1])); 
			dp[i+1][1] = Integer.max(dp[i][0]+ Math.abs(1-arr[i]), dp[i][1]);
		}
		return Integer.max(dp[n-1][1], dp[n-1][0]);
	}
	public static void main(String[] args) {
		int[] arr = {3, 2, 1, 4, 5};
		ModifyArrayToMaximizeSumOfAdjacentDifferences obj = new ModifyArrayToMaximizeSumOfAdjacentDifferences();
		System.out.println(obj.getMax(arr));
	}
}

