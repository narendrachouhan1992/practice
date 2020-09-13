package HackerRank;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class SherlockAnnagram {
	static int sherlockAndAnagrams(String s) 
	{
		int count = 0;
		for(int length=1;length<s.length();length++)
		{
			Map<BigDecimal, Integer> map = new HashMap<BigDecimal, Integer>();
			for (int i = 0; i < s.length()-length+1; i++)
			{
				BigDecimal hash = getHasBigDecimal(s, i, i+length-1);
				if(map.containsKey(hash))
				{
					count+=map.get(hash);
					map.put(hash, map.get(hash)+1);
				}
				else
					map.put(hash ,1);
			}
		}
		return count;
	}
	static BigDecimal getHasBigDecimal(String st, int s, int e)
	{
		BigDecimal b = new BigDecimal(0);
		for (int i = s; i <=e; i++) {
			b = b.add(new BigDecimal(Math.pow(10,st.charAt(i)-'a')));
		}
		return b;
	}
	public static void main(String[] args) {
		System.out.println(sherlockAndAnagrams("abba"));
	}
}
