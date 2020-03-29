package newDynamic;

public class RemoveMinimumElementsEitherSide2minMax {
	int getMin(int[] arr, int start, int end)
	{
		int min = Integer.MAX_VALUE;
		for(int i =start;i<=end;i++)
		{
			min = Integer.min(min, arr[i]);
		}
		return min;
	}
	int getMax(int[] arr, int start, int end)
	{
		int max = Integer.MIN_VALUE;
		for(int i =start;i<=end;i++)
		{
			max = Integer.min(max, arr[i]);
		}
		return max;
	}
	int getMinChanges(int[] arr)
	{
		int length = arr.length;
		int[][] dp = new int[length][length];
		for(int gap=0;gap<length;++gap)
		{
			for(int i =0, j=gap;j<length;++j, ++i)
			{
				int min = getMin(arr, i, j);
				int max = getMax(arr, i, j);
				if(min*2 > max)
				{
					dp[i][j] = 0;
				}
				else
				{
					dp[i][j] = 1+ Integer.min(dp[i+1][j], dp[i][j-1]);
				}
			}
		}
		return dp[0][length-1];
	}
	public static void main(String[] args) {
		RemoveMinimumElementsEitherSide2minMax obj = new RemoveMinimumElementsEitherSide2minMax();
		 int arr[] = {20, 4, 1, 3};
		 System.out.println(obj.getMinChanges(arr));
	}
}
