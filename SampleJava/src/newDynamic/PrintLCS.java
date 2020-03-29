package newDynamic;

import java.util.HashSet;
import java.util.Set;

public class PrintLCS {
	int[][] dp;
	
	Set<String> printAllLCS(String str1, String str2, int m, int n)
	{
		Set<String> s = new HashSet<String>();
		if(m==-1 || n==-1)
		{
			s.add("");
			return s;
		}
		if(str1.charAt(m)==str2.charAt(n))
		{
			Set<String> temp = printAllLCS(str1, str2, m-1, n-1);
		    for (String t : temp) {
				s.add(t+str1.charAt(m));
			}
		}
		else
		{
			if(dp[m-1][n]>= dp[m][n-1])
			{
				s = printAllLCS(str1, str2, m-1, n);
			}
			if(dp[m-1][n]<=dp[m][n-1])
			{
				Set<String> temp = printAllLCS(str1, str2, m, n-1);
				s.addAll(temp);
			}
		}
		return s;
	}
	int getLCS(String str1, String str2)
	{
		int n = str1.length();
		int m = str2.length();
		dp = new int[n][m];
		for(int i=0;i<n;i++)
			for(int j =0;j<m;j++)
			{
				if(i==0 || j==0)
				{
					if(str1.charAt(i)==str2.charAt(j))
					{
						dp[i][j] = 1;
					}
					else
					{
						dp[i][j] = 0;
					}
				}
				else if(str1.charAt(i)==str2.charAt(j))
				{
					dp[i][j] = dp[i-1][j-1]+1;
				}
				else
				{
					dp[i][j] = Integer.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		return dp[n-1][m-1];
	}
	public static void main(String[] args) {
		String X = "AGTGATG";
	    String Y = "GTTAG";
	    PrintLCS obj = new PrintLCS();
	    System.out.println(obj.getLCS(X, Y));
	    Set<String> result = obj.printAllLCS(X, Y, X.length()-1, Y.length()-1);
	    for (String s : result) {
			System.out.println(s);
		}
	}
}
