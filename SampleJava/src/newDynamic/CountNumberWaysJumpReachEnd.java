package newDynamic;

import java.util.Arrays;

public class CountNumberWaysJumpReachEnd {
	void getNumberOfWays(int[] arr)
	{
		int length = arr.length;
		int[] dp = new int[length];
		dp[length-1] = 0;
		
		for(int i = length-2;i>=0;i--)
		{
			if(arr[i]>=length-i-1)
				dp[i]++;
			for(int j = i+1;j<length-1 && j<= arr[i]+i;j++)
			{
				if(dp[j]!=-1)
				{
					dp[i]+= dp[j];
				}
			}
			if(dp[i]==0)
			{
				dp[i]= -1;
			}
		}
//		for (int i=n-2; i>=0; i--)
//	    {
//	        // if the element can directly
//	        // jump to the end
//	        if (arr[i] >= n - i - 1)
//	            count_jump[i]++;
//	 
//	        // add the count of all the elements
//	        // that can reach to end and arr[i] can
//	        // reach to them
//	        for (int j=i+1; j < n-1 && j <= arr[i] + i; j++)
//	 
//	            // if element can reach to end then add
//	            // its count to count_jump[i]
//	            if (count_jump[j] != -1)
//	                 count_jump[i] += count_jump[j];
//	 
//	        // if arr[i] cannot reach to the end
//	        if (count_jump[i] == 0)
//	            count_jump[i] = -1;
//	    }
	 
		 System.out.println(Arrays.toString(dp));
	}
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 8, 9, 1, 0, 7, 6, 8, 9};
		CountNumberWaysJumpReachEnd obj = new CountNumberWaysJumpReachEnd();
		obj.getNumberOfWays(arr);
	}
}
