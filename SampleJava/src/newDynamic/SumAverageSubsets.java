package newDynamic;

public class SumAverageSubsets {
	int nCr(int n, int k)
	{
		int[][] C = new int[n+1][k+1];
	    int i, j;
	 
	    // Calculate value of Binomial Coefficient in bottom
	    // up manner
	    for (i = 0; i <= n; i++)
	    {
	        for (j = 0; j <= Integer.min(i, k); j++)
	        {
	            // Base Cases
	            if (j == 0 || j == i)
	                C[i][j] = 1;
	 
	            // Calculate value using previously stored
	            // values
	            else
	                C[i][j] = C[i-1][j-1] + C[i-1][j];
	        }
	    }
	    return C[n][k];
	}
	double getAvrageSUm(int[] arr)
	{
		double result = 0.0;
		int length = arr.length;
		int sum = 0;
		for(int i=0;i<length;i++)
		{
			sum+= arr[i];
		}
		for(int i=1;i<=length;i++)
		{
			result += (double)(sum*(nCr(length-1, i-1)))/i;
		}
		return result;
	}
	public static void main(String[] args) {
		int[] arr = {2, 3, 5, 7};
		SumAverageSubsets obj=new SumAverageSubsets();
		System.out.println(obj.getAvrageSUm(arr));
	}
}
