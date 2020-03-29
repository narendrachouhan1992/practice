package newDynamic;

public class DynamicProgrammingSet31OptimalStrategyForAGame {
	int getMax(int[] arr)
	{
		int length = arr.length;
		int[][] dp = new int[length][length];
		
		
		for(int gap =0;gap<length;gap++)
		{
			for(int i=0;i<length&& i+gap<length;i++)
			{
					int j = i+gap;
					int x = i+2<=j? dp[i+2][j]:0;
					int y = i+1<=j-1? dp[i+1][j-1]:0;
					int z = i<=j-2 ? dp[i][j-2]: 0;
					dp[i][j] = Integer.max(arr[i] + Integer.min(x, y),arr[j]+ Integer.min(y, z));
			}
		}
		
		return dp[0][length-1];
	}
	public static void main(String[] args) {
		int[] arr1 = {8, 15, 3, 7};
		int[] arr2 = {2, 2, 2, 2};
		int[] arr3 = {20, 30, 2, 2, 2, 10};
		DynamicProgrammingSet31OptimalStrategyForAGame obj = new DynamicProgrammingSet31OptimalStrategyForAGame();
		System.out.println(obj.getMax(arr1));
		System.out.println(obj.getMax(arr2));
		System.out.println(obj.getMax(arr3));
	}
}
