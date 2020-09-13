package HackerRank;

import java.util.List;

public class PickingNumber {
	public static int pickingNumbers(List<Integer> a)
	{	
		int[] count = new int[100];
		for (Integer i : a) 
		{
			count[i]++;
		}
		int max = Integer.MIN_VALUE;
		for(int i=0;i<99;i++)
		{
			max = Integer.max(max, count[i]+count[i+1]);
		}
		return max;
	}

}	
