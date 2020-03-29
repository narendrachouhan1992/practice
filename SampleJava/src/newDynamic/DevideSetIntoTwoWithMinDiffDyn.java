package newDynamic;

public class DevideSetIntoTwoWithMinDiffDyn {
	int getDifference(int[] arr)
	{
		boolean[][] dp;
		int total = 0;
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			total += arr[i];
		}
		dp = new boolean[n+1][total+1];
		for(int i=0;i<=n;i++)
		{
			dp[i][0] = true;
		}
		for(int i=1;i<=total;i++)
		{
			dp[0][i] = false;
		}
		
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=total;j++)
			{
				dp[i][j] = dp[i-1][j];
				if(j>=arr[i-1])
				{
					dp[i][j] |= dp[i-1][j-arr[i-1]];
				}
			}
		}
		int diff = Integer.MAX_VALUE;
		for(int j=total/2;j>=0;j--)
		{
			if(dp[n][j])
			{
				diff = total - 2*j;
				break;
			}
		}
		
		return diff;
	}
	public static void main(String[] args) 
    {
        int arr[] = {3, 1, 4, 2, 2, 1};
        int n = arr.length;
        DevideSetIntoTwoWithMinDiffDyn obj = new DevideSetIntoTwoWithMinDiffDyn();
        System.out.print("The minimum difference"+
                        " between two sets is " + 
                         obj.getDifference(arr));
    }
}
