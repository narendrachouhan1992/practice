package newDynamic;

import java.util.Arrays;

public class CountStringsCanFormedUsingBCGivenConstraints {
	int[][][] dp = new int[100][2][3];
	int getCount(int n, int bCount, int Ccount)
	{
		if(bCount<0 || Ccount<0)
			return 0;
		if(Ccount==0 && bCount==0)
		{	dp[n][0][0] = 1;
			return 1;
		}
		if(n==0)
			return 1;
		
		if(dp[n][bCount][Ccount]!= -1)
		{
			return dp[n][bCount][Ccount];
		}
		
		int res=0;
		res+= getCount(n-1, bCount, Ccount);
		res+= getCount(n-1, bCount-1, Ccount);
		res+= getCount(n-1, bCount, Ccount-1);
		
		return (dp[n][bCount][Ccount] = res);
	}
	int getCount(int n)
	{
		for(int i =0;i<100;i++)
		{
			for(int j=0;j<2;j++)
				for(int k = 0;k<3;k++)
				{
					dp[i][j][k] = -1;
				}
		}
		return getCount(n, 1 ,2);
	}
	public static void main(String[] args) {
		CountStringsCanFormedUsingBCGivenConstraints obj = new CountStringsCanFormedUsingBCGivenConstraints();
		System.out.println(obj.getCount(3));
	}
}
