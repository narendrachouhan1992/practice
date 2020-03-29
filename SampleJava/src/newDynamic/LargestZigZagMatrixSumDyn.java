package newDynamic;

public class LargestZigZagMatrixSumDyn {
	int getMax(int[][] arr)
	{
		int size = arr.length;
		int[][] dp = new int[size][size];
		for(int i=0;i<size;i++)
		{
			dp[size-1][i] = arr[size-1][i];
		}
		for(int i=size-2;i>=0;i--)
		{
			for(int j=0;j<size;j++)
			{
				int res = 0;
				for(int k =0;k<size;k++)
				{
					if(k!=j)
					{
						res = Integer.max(res, dp[i+1][k]);
					}
				}
				dp[i][j] = arr[i][j] + res;
			}
		}
		int res = 0;
		for(int i =0;i<size;i++)
		{
			res = Integer.max(res, dp[0][i]);
		}
		return res;
		
	}
	public static void main(String[] args) {
		int[][] arr = { {4, 2, 1},
                {3, 9, 6},
                {11, 3, 15}};
		LargestZigZagMatrixSumDyn obj =  new LargestZigZagMatrixSumDyn();
		System.out.println(obj.getMax(arr));
	}
}
