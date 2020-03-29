package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MigeratoryBird {
	static int migratoryBirds(List<Integer> arr) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int maxBirdNum = 0;
		int maxBirdCount=0;
		if(arr==null)
		{
			return 0;
		}
		for (Integer bird : arr) {
			if(map.containsKey(bird))
			{
				map.put(bird, map.get(bird)+1);	
			}
			else
			{
				map.put(bird, 1);
			}
			if(maxBirdCount<=map.get(bird) && maxBirdNum>bird)
			{
				maxBirdCount=map.get(bird);
				maxBirdNum=bird;
			}
		}
		
		return maxBirdNum;
	}
	public static void main(String[] args) {
		List<Integer> arr = new  ArrayList<Integer>();
		arr.add(1);
		arr.add(4);
		arr.add(4);
		arr.add(4);
		arr.add(5);
		arr.add(3);		
		System.out.println(migratoryBirds(arr));
	}
}
