package newDynamic;

import java.util.Arrays;

public class FindMaximumNumberPossibleByDoingAtMostKSwaps {
	int getMaxInd(int[] arr,int start,int  k)
	{
		int max = Integer.MIN_VALUE;
		int maxInd = start;
		for(int i=1;i<=k;i++)
		{
			if(arr[start+i]>max)
			{
				maxInd = start+i;
				max = arr[start+i];
			}
		}
		return maxInd;
	}
	void getMax(int[] arr, int k)
	{
		if( k == 0)
		{
			System.out.println(Arrays.toString(arr));
		}
		for(int j = 0;j<arr.length && k!= 0;j++)
		{
			int maxInd = getMaxInd(arr, j, k);
			if(maxInd != j)
			{
				k -= maxInd-j;
				int temp = arr[j];
				arr[j] = arr[maxInd];
				arr[maxInd] = temp;
			}
		}
		if( k == 0)
		{
			System.out.println(Arrays.toString(arr));
		}
	}
	public static void main(String[] args) {
		FindMaximumNumberPossibleByDoingAtMostKSwaps obj = new FindMaximumNumberPossibleByDoingAtMostKSwaps();
		int[] arr = {1,2,9,8,1,4,9,9,9};
		int k = 4;
		obj.getMax(arr, k);
	}
}
