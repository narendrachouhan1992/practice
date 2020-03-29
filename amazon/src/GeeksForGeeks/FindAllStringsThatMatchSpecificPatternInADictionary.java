package GeeksForGeeks;

import java.util.HashMap;
import java.util.Map;

public class FindAllStringsThatMatchSpecificPatternInADictionary {
	
	private static String getUniqueHash(String word)
	{
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		int n = word.length();
		String code ="";
		int num = 1;
		for(int i=0;i<n;i++)
		{
			char c = word.charAt(i);
			if(!map.containsKey(c))
			{
				map.put(c, num++);
			}
			code+=map.get(c);
		}
		return code;
	}
	static void printMatching(String[] words, String pat)
	{
		String patCode = getUniqueHash(pat);
		
		for(int i=0;i<words.length;i++)
		{
			if(patCode.equals(getUniqueHash(words[i])))
				System.out.println(words[i]);
		}
	}
	public static void main(String[] args) {
		String[] dict = { "abb", "abc", "xyz", "xyy" }; 
        String pattern = "foo"; 
        printMatching(dict, pattern);
	}
}
