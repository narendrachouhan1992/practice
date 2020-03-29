package newDynamic;

public class FindDistinctSubsetSubsequenceSumsArrayDyn {
	void printAllSum(int[] arr)
	{
		int length = arr.length;
		int sum = 0;
		for (int i = 0; i < length; i++) {
			sum+= arr[i];
		}
		boolean[][] dp = new boolean[length+1][sum+1];
		for(int i=0;i<=length;i++)
		{
			dp[i][0] = true;
		}
		for(int i=1;i<=length;i++)
		{
			dp[i][arr[i-1]] = true;
			for(int j=1;j<=sum;j++)
			{
				if(dp[i-1][j])
				{
					dp[i][j] = true;
					dp[i][j+arr[i-1]] = true;
				}
			}
		}
		for(int i = 0;i<=sum;i++)
		{
			if(dp[length][i])
			{
				System.out.println(i);
			}
		}
	}
	public static void main(String[] args) {
		int[] arr = {2, 3, 4, 5, 6};
		FindDistinctSubsetSubsequenceSumsArrayDyn obj = new FindDistinctSubsetSubsequenceSumsArrayDyn();
		obj.printAllSum(arr);
	}
}
