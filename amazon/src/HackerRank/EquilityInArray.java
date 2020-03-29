package HackerRank;

import java.util.HashMap;
import java.util.Map;

public class EquilityInArray {
	static int equalizeArray(int[] arr) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = -1;
		for (int i : arr) {
			if(map.containsKey(i))
			{
				map.put(i, map.get(i)+1);
				max = Integer.max(max, map.get(i));
			}
			else
			{
				map.put(i, 1);
				max = Integer.max(1, max);
			}
		}
		return (arr.length-max);
		
    }
}
