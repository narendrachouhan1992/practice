package newDynamic;

public class DynamicProgrammingSet7CoinChange {
	int getNumberOfWays(int[] arr, int num)
	{
		int[] dp = new int[num+1];
		dp[0] = 1;
		for(int i=1;i<=num;i++)
		{
			for(int j=0;j<arr.length;j++)
			{
				if(arr[j]<=i)
				dp[i]+= dp[i-arr[j]];
			}
		}
		return dp[num];
	}
	public static void main(String[] args) {
		DynamicProgrammingSet7CoinChange obj = new DynamicProgrammingSet7CoinChange();
		 int arr[] = {1, 2, 3};
		 int num = 4;
		System.out.println(obj.getNumberOfWays(arr, num));
	}
}
