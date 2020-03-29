package newDynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FindAllStringsThatMatchSpecificPatternInADictionary {
	String getHash(String str)
	{
		int num = 0;
		String res = "";
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int length = str.length();
		for(int i =0;i<length;i++)
		{
			if(!map.containsKey(str.charAt(i)))
			{
				map.put(str.charAt(i), num++);
			}
			res+= map.get(str.charAt(i));
		}
		return res;
	}
	String[] getWords(String[] words, String pat)
	{
		String hash = getHash(pat);
		int pat_len = pat.length();
		String[] res; 
		List<String> list = new ArrayList<String>();
		for (String word : words) {
			if(pat_len == word.length() && hash.equals(getHash(word)))
			{
				list.add(word);
			}
		}
		res = new String[list.size()];
		int i = 0;
		for (String word : list) {
			res[i++] = word;		
		}
		return res;
	}
	public static void main(String[] args) {
		String[] words = { "abb", "abc", "xyz", "xyy" };
		FindAllStringsThatMatchSpecificPatternInADictionary obj =new FindAllStringsThatMatchSpecificPatternInADictionary();
		System.out.println(Arrays.toString(obj.getWords(words, "foo")));
	}
}
