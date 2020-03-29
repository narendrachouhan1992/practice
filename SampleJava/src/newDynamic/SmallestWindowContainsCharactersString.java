package newDynamic;

import java.util.Arrays;

public class SmallestWindowContainsCharactersString {
	String getMin(String str)
	{
		boolean[] visited = new boolean[26];
		int length = str.length();
		int charcount = 0;
		for(int i =0;i<length;i++)
		{
			if(visited[str.charAt(i) - 'a'] == false)
			{
				charcount++;
				visited[str.charAt(i) - 'a'] = true;
			}
		}
		int[] chars = new int[26];
		int visitedChar = 0;
		int start = 0;
		int minLength = length;
		int startChar = 0;
		for(int i=0;i<length;i++)
		{
			chars[str.charAt(i) - 'a']++;
			if(chars[str.charAt(i) - 'a'] == 1)
			{
				visitedChar ++;
			}
			if(visitedChar == charcount)
			{
				while(chars[str.charAt(start)-'a']>1)
				{
					
					chars[str.charAt(start) - 'a']--;
					start++;
				}
				if(minLength> (i-start+1))
				{
					minLength = i-start+1;
					startChar = start;
				}
			}
		}
		return str.substring(startChar, startChar+minLength);
	}
	public static void main(String[] args) {
		SmallestWindowContainsCharactersString obj = new SmallestWindowContainsCharactersString();
		System.out.println(obj.getMin("aabcbcdbca"));
	}
}
