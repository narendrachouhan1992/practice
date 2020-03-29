package newDynamic;

public class PalindromePartitioning {
	int getNumberOfPartitioning(String input)
	{
		char[] inArr = input.toCharArray();
		int length = inArr.length;
		boolean[][] isPalendrome = new boolean[length][length];
		int[][] numberOfCuts = new int[length][length];
		
		for(int i =0;i<length;i++)
		{
			isPalendrome[i][i] = true;
			numberOfCuts[i][i] = 0;
		}
		for(int L = 2;L<=length;L++)
		{
			for(int i =0;i<length-L+1;i++)
			{
				int j = i+L-1;
				if(L==2)
				{
					isPalendrome[i][j] = (inArr[i] == inArr[j]);
				}
				else
				{
					isPalendrome[i][j] = (inArr[i] == inArr[j]) && isPalendrome[i+1][j-1];
				}
				if(isPalendrome[i][j])
				{
					numberOfCuts[i][j] = 0;
				}
				else
				{
					numberOfCuts[i][j] = Integer.MAX_VALUE;
					for(int k = i;k<j;k++)
					{
						numberOfCuts[i][j] = Integer.min(numberOfCuts[i][k] + numberOfCuts[k+1][j]+1, numberOfCuts[i][j]);
					}
				}
			}
		}
		
		
		return numberOfCuts[0][length-1]; 
	}
	public static void main(String[] args) {
		PalindromePartitioning obj = new PalindromePartitioning();
		System.out.println(obj.getNumberOfPartitioning("ababbbabbababa"));
	}
}
