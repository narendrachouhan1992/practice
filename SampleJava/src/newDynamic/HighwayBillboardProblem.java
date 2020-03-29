package newDynamic;

public class HighwayBillboardProblem {
	int getValue(int m, int x[], int revenue[], int t)
	{
		int numberOfBilBoards = x.length;
		int[] dp = new int[m+1];

		int bilBoardNum = 0;
		for(int i =1;i<= m;i++)
		{
			if(bilBoardNum<numberOfBilBoards)
			{
				if(x[bilBoardNum] != i)
				{
					dp[i]= dp[i-1];
				}
				else 
				{
					if(i<=t)
					{
						dp[i] = Integer.max(dp[i-1], revenue[bilBoardNum]);
					}
					else
					{
						dp[i] = Integer.max(dp[i-1], (dp[i-t-1]+ revenue[bilBoardNum]));
					}
					bilBoardNum++;
				}
			}
			else
			{
 				dp[i] = dp[i-1];
			}
		}
		return dp[m];
	}
	public static void main(String[] args) {
		HighwayBillboardProblem obj = new HighwayBillboardProblem();
		int m = 20;
	    int x[] = {6, 7, 12, 13, 14};
	    int revenue[] = {5, 6, 5, 3, 1};
	    int t = 5;
	    System.out.println(obj.getValue(m, x, revenue, t));
	}
}
