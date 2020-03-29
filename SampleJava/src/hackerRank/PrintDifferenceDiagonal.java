package hackerRank;

import java.util.Scanner;

public class PrintDifferenceDiagonal {
	
	static int getSum(int[][] arr, int n)
	{
		int lSum = 0;
		int rSum = 0;
		for(int i=0;i<n;i++)
		{
			lSum+=arr[i][i];
			rSum+=arr[i][n-i-1];
		}
		return Math.abs((lSum-rSum));
	}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][n];
        for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }
        System.out.println(getSum(a, n));
    }
}
