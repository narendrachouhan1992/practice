package newDynamic;
//it is an example of catalan number

public class NonCrossingLinesConnectPointsCircle {
	int getCount(int numberOfPoints)
	{
		if(numberOfPoints%2==1)
		{
			return -1;
		}
		numberOfPoints/=2;
		
		int[] dp = new int[numberOfPoints+1];
		dp[0] = dp[1] =1;
		for(int i=2;i<=numberOfPoints;i++)
		{
			dp[i] = 0;
			
			for(int j=0;j<i;j++)
			{
				dp[i] += (dp[j]* dp[i-j-1]);
			}
		}
		return dp[numberOfPoints];
	}
	public static void main(String[] args) {
		NonCrossingLinesConnectPointsCircle obj = new NonCrossingLinesConnectPointsCircle();
		System.out.println(obj.getCount(6));
	}
}
