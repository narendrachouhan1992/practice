package newDynamic;

public class DynamicProgrammingSet24OptimalBinarySearchTree {
	int getMin(int[] freq)
	{
		int length = freq.length;
		int[][] dp = new int[length][length];
		for(int i=0;i<length;i++)
		{
			dp[i][i] =freq[i]; 
		}
		for(int L=2;L<=length;L++)
			for(int i=0;i<length-L+1;i++)
			{
				int j = i+L-1;
				dp[i][j] = Integer.MAX_VALUE;
				for (int r = i; r <= j; r++) {
					 
                    // c = cost when keys[r] becomes root of this subtree
                    int c = ((r > i) ? dp[i][r - 1] : 0)
                            + ((r < j) ? dp[r + 1][j] : 0) + getSum(freq, i, j);
                    if (c < dp[i][j])
                        dp[i][j] = c;
                }
			}
		
		
		return dp[0][length-1];
	}
	private int getSum(int[] arr, int i, int j)
	{
		int sum = 0;
		for(int k=i;k<=j;k++)
		{
			sum+= arr[k];
		}
		return sum;
	}
	public static void main(String[] args) {
		int[] keys= { 10, 12, 20 };
	    int[] freq = { 34, 8, 50 };
	    DynamicProgrammingSet24OptimalBinarySearchTree obj = new DynamicProgrammingSet24OptimalBinarySearchTree();
	    System.out.println(obj.getMin(freq));
	}
}
