package hackerRank;

public class hourGlassSum {
	static int hourglassSum(int[][] arr) {
		int rows = arr.length;
		int cols = arr[0].length;
		int maxSum = Integer.MIN_VALUE;
		for(int i=1;i<rows-1;i++)
		{
			for(int j=1;j<cols-1;j++)
			{
				int sum = arr[i][j]+ arr[i-1][j]+ arr[i+1][j]+ arr[i-1][j-1] + arr[i-1][j+1] + arr[i+1][j-1] + arr[i+1][j+1];
				maxSum = Integer.max(sum, maxSum);
			}
		}
		return maxSum;
    }
}
