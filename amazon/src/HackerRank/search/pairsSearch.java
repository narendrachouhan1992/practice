package HackerRank.search;

import java.util.HashMap;
import java.util.Map;

public class pairsSearch {
	static int pairs(int k, int[] arr) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<arr.length;i++)
		{
			map.put(arr[i], 1);
		}
		int count = 0;
		for(int i=0;i<arr.length;i++)
		{
			if(map.containsKey((arr[i]-k)))
					count++;
		}
		return count;
	}
}
