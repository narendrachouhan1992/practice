package newDynamic;

public class MinimumSumSubsequenceLeastOneEveryFourConsecutiveElementsPickedDyn {
	int getMin(int[] arr)
	{
		int length = arr.length;
		if (length==1)
	        return arr[0];
	    if (length==2)
	        return Integer.min(arr[0], arr[1]);
	    if (length==3)
	        return Integer.min(arr[0], Integer.min(arr[1], arr[2]));
	    if (length==4)
	        return Integer.min(Integer.min(arr[0], arr[1]),
	        		Integer.min(arr[2], arr[3]));
	    int[] dp = new int[length];
	    dp[0]= arr[0];
	    dp[1]= arr[1];
	    dp[2]= arr[2];
	    dp[3]= arr[3];
	    for(int i =4;i<length;i++)
	    {
	    	dp[i] = arr[i] + Integer.min(Integer.min(dp[i-1],dp[i-2]),
	        		Integer.min(dp[i-3], dp[i-4]));
	    }
	    return dp[length -1];
	}
	public static void main(String[] args) {
		 int[] arr = {1, 2, 3, 3, 4, 5, 6, 1};
		 MinimumSumSubsequenceLeastOneEveryFourConsecutiveElementsPickedDyn obj = new MinimumSumSubsequenceLeastOneEveryFourConsecutiveElementsPickedDyn();
		 System.out.println(obj.getMin(arr));
	}
}
