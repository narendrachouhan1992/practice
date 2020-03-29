package newDynamic;

public class LongestZigZagsequence {
	int getLength(int[] arr)
	{
		
		// dp[][0] = last element is increasing
		//dp[][1] = last element is decreasing
		int length = arr.length;
		int[][] dp = new int[length][2];
		for(int i=0;i<length;i++)
		{
			dp[i][0]= dp[i][1] = 1;
		}
		for(int i=1;i<length;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[i]>arr[j] && (dp[j][1]+1 > dp[i][0]))
					dp[i][0] = dp[j][1]+1;
				if(arr[i]<arr[j] && (dp[j][0]+1>dp[i][1]))
					dp[i][1] = dp[j][0]+1;
			}
		}
		
		return Integer.max(dp[length-1][0], dp[length -1][1]);
	}
	public static void main(String[] args)
	{
	    int arr[] = { 10, 22, 9, 33, 49, 
	                  50, 31, 60 };
	 LongestZigZagsequence obj = new LongestZigZagsequence();
	    System.out.println("Length of Longest "+
	                    "Zig-Zag subsequence is " +
	                    obj.getLength(arr));
	}
}
