package newDynamic;

public class MinimumNumberOfJumpsToReachEndOfAGivenArray {
	int getMinimum(int[] arr)
	{
		int length = arr.length;
		int[] dp = new int[length];
		dp[length-1] = 0;
		for(int i=length-2;i>=0;i--)
		{
			dp[i] = Integer.MAX_VALUE;
			if(arr[i]!=0)
			{
				if(i+arr[i]>=length)
				{
					dp[i] = 1;
				}
				else
				{
					for(int j =i+1;j<=length && j<= arr[i]+i;j++)
					{
						if(dp[j]!=Integer.MAX_VALUE)
						{
							dp[i] = Integer.min(dp[i], dp[j]+1);
						}
					}
				}
			}
		}
		return dp[0];
	}
	
	
	
	
	
	int getMinJump(int[] arr)
	{
		int length = arr.length;
		int[] dp = new int[length]; 
		dp[length-1] = 0;
		
		for(int i = length -2;i>=0;i--)
		{
			dp[i] = Integer.MAX_VALUE;
			if(arr[i] != 0)
			{
				if(arr[i]+i>length-1)
					dp[i] = 1;
				else
				{
					for(int j = i+1;j<=i+arr[i]&& j<length;j++)
					{
						if(dp[j]!= Integer.MAX_VALUE)
						{
							dp[i] = Integer.min(dp[i], 1+dp[j]);
						}
					}
				}
			}
		}
		return dp[0];
	}
	public static void main(String[] args) {
		int arr[] = {1, 3, 6, 1, 0, 9};
		MinimumNumberOfJumpsToReachEndOfAGivenArray obj = new MinimumNumberOfJumpsToReachEndOfAGivenArray();
		System.out.println(obj.getMinimum(arr));
		System.out.println(obj.getMinJump(arr));
	}
}
