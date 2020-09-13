package HackerRank;

import java.util.HashMap;
import java.util.Map;

public class CommonSubString {
	static String twoStrings(String s1, String s2) {
		Map<Character, Boolean> map = new HashMap<Character, Boolean>();
		for(int i=0;i<s1.length();i++)
			map.put(s1.charAt(i), true);
		for(int i=0;i<s1.length();i++)
			if(map.containsKey(s2.charAt(i)))
				return "YES";
		return "NO";
		
	}
}
