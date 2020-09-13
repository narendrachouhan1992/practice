package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


import java.util.TreeMap;

public class MinimumSwap {
	static int minimumSwaps1(int[] arr) 
	{
        int swaps = 0;
        for(int i=0;i<arr.length;i++)
        {
        	int min = i;
        	for(int j = i+1;j<arr.length;j++)
        	{
        		if(arr[j]<arr[min])
        			min = j;
        	}
        	if(min!=i)
        	{
        		swaps++;
        		int t = arr[i];
        		arr[i] = arr[min];
        		arr[min] = t;
        	}
        }
        System.out.println(swaps);
        return swaps;
    }
	static int minimumSwaps(int[] arr) 
	{
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] brr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], i);
			brr[i] = arr[i];
		}
		
		Arrays.sort(brr);
		int swap = 0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]!=brr[i])
			{
				swap++;
				int j = map.get(brr[i]);
				int t = arr[i];
        		arr[i] = arr[j];
        		arr[j] = t;
        		map.put(arr[i], i);
        		map.put(arr[j], j);
			}
		}
		return swap;
	}
	public static void main(String[] args) {
		int[] arr = {4, 3, 1, 2};
		System.out.println(minimumSwaps(arr));
	}
}
