package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
class Pair
{
	int a;
	int b;
	public Pair(int a, int b) {
		this.a=a;
		this.b=b;
	}
}
public class GeometricTriplet {

	
	
	
	
	static long countTriplets2(List<Long> arr, long r) 
	{
		Map<Long, List<Integer>> map = new HashMap<Long, List<Integer>>();
		for (int i = 0; i < arr.size(); i++)
		{
			if(map.containsKey(arr.get(i)))
			{
				map.get(arr.get(i)).add(i);
			}
			else
			{
				List<Integer> l = new ArrayList<Integer>();
				l.add(i);
				map.put(arr.get(i), l);
			}
		}
		long count = 0;
		for (int i = 0; i < arr.size(); i++) {
			if(r!=1 && map.containsKey(arr.get(i)*r) && map.containsKey(arr.get(i)*r*r))
			{
				count+=(map.get(arr.get(i)*r).size()*map.get(arr.get(i)*r*r).size());
			}
			else if(r==1)
			{
				if(map.get(arr.get(i)).size()==3)
					count++;
				else if(map.get(arr.get(i)).size()>3)
				{
					List<Integer> ls = map.get(arr.get(i));
					for(int x=0;x<ls.size();x++)
					{
						if(ls.get(x)==i)
						{
							int nums=ls.size()-x-1;
							nums = nums*(nums-1);
							nums/=2;
							count+=nums;
						}
					}
				}
			}
		}
		return count;
	}
	static long countTriplets1(List<Long> arr, long r) 
	{
		Map<Float, List<Pair>> map = new HashMap<Float, List<Pair>>();
		for (int i = 0; i < arr.size()-1; i++) {
			for (int  j = i+1;  j < arr.size();  j++) {
				float ratio= arr.get(i)/arr.get(j);
				if(map.containsKey(ratio))
					map.get(ratio).add(new Pair(i, j));
				else
				{
					List<Pair> l = new ArrayList<Pair>();
					l.add(new Pair(i, j));
					map.put(ratio, l);
				}
					
			}
		}
		Iterator<Float> it =map.keySet().iterator();
		int count = 0;
		while(it.hasNext())
		{
			float key = it.next();
			if (map.get(key).size()>=3) {
				List<Pair> l = map.get(key);
				for (int i = 0; i < l.size()-1; i++) {
					for (int j = i+1; j < l.size(); j++) {
						if (l.get(i).b== l.get(j).a) {
							count++;
						}
					}
				}
			}
		}
		return count;
	}
	 static long countTriplets(List<Long> arr, long r) {
	        
	        Map<Long, Long> rightMap = getOccurenceMap(arr);
	        Map<Long, Long> leftMap = new HashMap<>();
	        long numberOfGeometricPairs = 0;
	    
	        for (long val : arr) {
	          long countLeft = 0;
	          long countRight = 0;
	          long lhs = 0;
	          long rhs = val * r;
	          if (val % r == 0) {
	            lhs = val / r;
	          }
	          Long occurence = rightMap.get(val);
	          rightMap.put(val, occurence - 1L);

	          if (rightMap.containsKey(rhs)) {
	            countRight = rightMap.get(rhs);
	          }
	          if (leftMap.containsKey(lhs)) {
	            countLeft = leftMap.get(lhs);
	          }
	          numberOfGeometricPairs += countLeft * countRight;
	          insertIntoMap(leftMap, val);
	        }
	        return numberOfGeometricPairs;
	    }
	    
	    private static Map<Long, Long> getOccurenceMap(List<Long> test) {
	        Map<Long, Long> occurenceMap = new HashMap<>();
	        for (long val : test) {
	            insertIntoMap(occurenceMap, val);
	        }
	       return occurenceMap;
	    }
	  
	    private static void insertIntoMap(Map<Long, Long> occurenceMap, Long val) {
	        if (!occurenceMap.containsKey(val)) {
	            occurenceMap.put(val, 1L);
	          } else {
	            Long occurence = occurenceMap.get(val);
	            occurenceMap.put(val, occurence + 1L);
	          }
	    }
	public static void main(String[] args) {
		Long[] l = {1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L}; 
		List<Long> al =  new ArrayList<Long>(Arrays.asList(l));
//		System.out.println(countTriplets(al, 1));
	}
}
