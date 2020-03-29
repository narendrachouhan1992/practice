package HackerRank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TeamForation {
	static int[] acmTeam(String[] topic) {

	
		Map<Integer, Set<Integer>> knowns = new HashMap<Integer, Set<Integer>>();
		for(int i=0;i<topic.length;i++)
		{
			Set<Integer> l = new HashSet<Integer>();
			for(int j=0;j<topic[i].length(); j++)
			{
				if(topic[i].charAt(j)=='1')
					l.add(j);
			}
			knowns.put(i, l);
		}
		int maxknown = -1;
		int totalMax = 0;
		for(int i=0;i<topic.length;i++)
		{
			
			for(int j=i+1;j<topic.length;j++)
			{
				int known = 0;
				for(int k=0;k<topic[i].length();k++)
				{
					if(knowns.get(i).contains(k) || knowns.get(j).contains(k))
					{
						known++;
					}
				}
				
				if(maxknown<known)
				{
					totalMax=1;
					maxknown=known;
				}
				else if(maxknown==known)
				{
					totalMax++;
				}
			}
			
		}
		int[] res = new int[2];
		res[0] = maxknown;
		res[1] = totalMax;
		return res;
    }
	public static void main(String[] args) {
		String[] st = {"10101",
		"11100",
		"11010",
		"00101"};
		System.out.println(Arrays.toString(acmTeam(st)));
	}
}	
