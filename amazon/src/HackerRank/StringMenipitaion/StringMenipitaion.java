package HackerRank.StringMenipitaion;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StringMenipitaion {
	static int alternatingCharacters(String s) {
		StringBuffer sb = new StringBuffer("");
		char prev = '\0';
		for (int i = 0; i < s.length(); i++) {
			if (prev != s.charAt(i)) {
				prev = s.charAt(i);
				sb.append(prev);
			}
		}
		return (s.length() - sb.length());
	}
	static String isValid(String s) {
		int[] count = new int[26];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i)-'a']++;
		}
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		for (int i = 0; i < count.length; i++) {
			if(count[i]!=0)
			{
				if(map.containsKey(count[i]))
					map.put(count[i], map.get(count[i])+1);
				else
					map.put(count[i], 1);
				if(map.size()==3)
					return "NO";
			}
		}
		if(map.size()==1)
			return "YES";
		if(map.size()==2)
		{
			Iterator<Integer> it = map.keySet().iterator();
			int a = it.next();
			int b = it.next();
			
			if((a==1 && map.get(a) == 1) || (b==1 && map.get(b) == 1) )
			{
				return "YES";
			}
			else if(Math.abs(a-b)==1 && (a>b?map.get(a)==1 :map.get(b)==1))
			{
				return "YES";
			}
		}
		return "NO";
    }
	public static void main(String[] args) {
		String s   = "aabbcd";
		isValid(s);
	}
}
