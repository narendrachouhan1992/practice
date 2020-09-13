package HackerRank;

import java.util.Iterator;
import java.util.List;

public class Migratory {
	static int migratoryBirds(List<Integer> arr) {
		int[] count = new int[6];
		for (Integer i : arr) {
			count[i]++;
		}
		int max = 0;
		int maxCount = 0;
		for (int i = 1; i < count.length; i++) {
			if(maxCount<count[i])
			{
				max = i;
				maxCount = count[i];
			}
		}
		return max;
	}
}
