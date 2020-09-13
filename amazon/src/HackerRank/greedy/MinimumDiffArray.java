package HackerRank.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumDiffArray {
	static int minimumAbsoluteDifference(int[] arr) {
		Arrays.parallelSort(arr);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length - 1; i++) {
			if (Math.abs(arr[i + 1] - arr[i]) < min)
				min = Math.abs(arr[i + 1] - arr[i]);
		}
		return min;
	}

	static int luckBalance(int k, int[][] contests) 
	{
		int luckRemaining = 0;
		List<Integer> imps = new ArrayList<Integer>();
		for(int i=0;i<contests.length;i++)
		{
			if(contests[i][1]==0)
				luckRemaining+=contests[i][0];
			else
				imps.add(contests[i][0]);
		}
		int size = imps.size();
		if(size<=k)
			for (Integer i : imps) {
				luckRemaining+=i;
			}
		else
		{
			Collections.sort(imps);
			
			for(int i=size-1;i>=0;i--)
			{
				if(k>0)
				{
					luckRemaining+=imps.get(i);
				}
				else
					luckRemaining-=imps.get(i);
				k--;
			}
			
		}
		return luckRemaining;
	}
	public static void main(String[] args) {
		int[][] nums = {{5, 1},{4, 0},{6, 1},{2, 1},{8, 0}};
		System.out.println(luckBalance(2, nums));
	}
}
