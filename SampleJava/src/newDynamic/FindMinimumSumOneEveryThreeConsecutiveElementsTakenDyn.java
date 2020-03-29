package newDynamic;

public class FindMinimumSumOneEveryThreeConsecutiveElementsTakenDyn {
	int getMinCount(int[] arr)
	{
		int n = arr.length;
		int[] dp = new int[n];
		
		dp[0]= arr[0];
		dp[1] = arr[1];
		dp[2] = arr[2];
		for(int i =3;i<n;i++)
		{
			dp[i] = arr[i] + Integer.min(Integer.min(dp[i-1], dp[i-2]), dp[i-3]);
		}
		return Integer.min(Integer.min(dp[n-1], dp[n-2]), dp[n-3]);
	}
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 20, 2, 10, 1};
		FindMinimumSumOneEveryThreeConsecutiveElementsTakenDyn obj = new FindMinimumSumOneEveryThreeConsecutiveElementsTakenDyn();
		System.out.println(obj.getMinCount(arr));
	}
}
