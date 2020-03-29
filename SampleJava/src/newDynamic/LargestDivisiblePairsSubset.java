package newDynamic;

import java.util.Arrays;

public class LargestDivisiblePairsSubset {
	int maxValue(int[] dp )
	{
		int max = 0;
		for(int i=0;i<dp.length;i++)
		{
			if(max<dp[i])
				max = dp[i];
		}
		return max;
	}
	int getMaxDiivisiblePair(int[] arr)
	{
		Arrays.sort(arr);
		int length = arr.length;
		int[] dp = new int[length];
		dp[length-1] = 1;
		for(int i=length-2;i>=0;i--)
		{
			int max = 0;
			for(int j=i+1; j<length;j++)
			{
				if(arr[j]%arr[i] == 0)
					max = Integer.max(max, dp[j]);
				
			}
			dp[i] = max+1;
		}
		return maxValue(dp);
	}
	public static void main(String[] args) {
		LargestDivisiblePairsSubset obj = new LargestDivisiblePairsSubset();
		 int[] arr = { 1, 3, 6, 13, 17, 18 };
		 System.out.println(obj.getMaxDiivisiblePair(arr));
	}
}
