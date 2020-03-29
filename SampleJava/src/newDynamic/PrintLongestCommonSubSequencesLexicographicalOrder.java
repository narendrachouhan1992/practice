package newDynamic;

import java.util.Arrays;

public class PrintLongestCommonSubSequencesLexicographicalOrder {
	int[][] dp;
	int lcsLength;
	private void getLcs( char[] X, char[] Y)
	{
		int m = X.length;
		int n = Y.length;
		dp = new int[m+1][n+1];
	   int i, j;
	  
	   /* Following steps build L[m+1][n+1] in bottom up fashion. Note 
	      that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
	   for (i=0; i<=m; i++)
	   {
	     for (j=0; j<=n; j++)
	     {
	       if (i == 0 || j == 0)
	         dp[i][j] = 0;
	  
	       else if (X[i-1] == Y[j-1])
	         dp[i][j] = dp[i-1][j-1] + 1;
	  
	       else
	         dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
	     }
	   }
	   lcsLength =  dp[m][n];
	}
	private void print(char[] str1, char[] str2, int i, int j,char[] data, int curr)
	{
		if(curr == lcsLength)
		{
			
			System.out.println(Arrays.toString(data));
		}
		else if (str1.length== i || str2.length==j)
		{
			return;
		}
		else
		{
			for(char ch = 'a'; ch<='z'; ch++)
			{
				boolean done = false;
				for(int k = i;k<str1.length;k++)
				{
					if(ch == str1[k])
					{
						for(int l = j;l<str2.length;l++)
						{
							if(str2[l]== ch && Integer.min(str1.length-k, str2.length-l)>=(lcsLength-curr))
							{
								char[] newData = data.clone();
								newData[curr] = ch;
								print(str1, str2, k+1, l+1, newData, curr+1);
								done = true;
								break;
							}
						}
					}
					if(done)
					{
						break;
					}
				}
			}
		}
	}
	void PrintAllLSC(String str1, String str2)
	{
		getLcs(str1.toCharArray(), str2.toCharArray());
		char[] data = new char[lcsLength];
		print(str1.toCharArray(), str2.toCharArray(), 0, 0, data, 0);
		
	}
	public static void main(String[] args) {
		PrintLongestCommonSubSequencesLexicographicalOrder obj = new PrintLongestCommonSubSequencesLexicographicalOrder();
		obj.PrintAllLSC("abcabcaa", "acbacba");
	}
}
