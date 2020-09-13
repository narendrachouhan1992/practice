package HackerRank.search;

import java.util.HashMap;
import java.util.Map;

public class IcecreamParler {
	 static void whatFlavors(int[] cost, int money) {
		 Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		 
		 for(int i=0;i<cost.length;i++)
			 map.put(cost[i], i);
		 for(int i=0;i<cost.length;i++)
			if(map.containsKey(money-cost[i]) && map.get(money-cost[i])!=i)
			{
				int first  =1+ Integer.min(i, map.get(money-cost[i]));
				int second =1+ Integer.max(i, map.get(money-cost[i]));
				System.out.println(first +" "+second);
				return;
			}
	    }
	 public static void main(String[] args) {
		 int[] arr = {4, 3 ,2 ,5, 7};
		 whatFlavors(arr,8);
	}
}
