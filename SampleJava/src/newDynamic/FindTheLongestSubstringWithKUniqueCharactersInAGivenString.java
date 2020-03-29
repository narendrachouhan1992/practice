package newDynamic;

import java.util.Map;

public class FindTheLongestSubstringWithKUniqueCharactersInAGivenString {
	void printSubString(String str, int k)
	{
		int large_start = 0;
		int start = 0;
		int end = 1;
		int largest = 0;
		int[] count = new int[256];
		count[str.charAt(0)]++;
		int charcount = 1;
		while(end< str.length() && start<end)
		{
			
			if(count[str.charAt(end)]!= 0)
			{
				charcount ++;
				end++;
			}
			else
			{
				count[str.charAt(end)]++;
			}
			
			if(charcount== k && (largest< end-start+1))
			{
				largest = end-start+1;
				large_start = start;
			}
			while(charcount>k)
			{
				start++;
				count[str.charAt(start)]--;
				if(count[str.charAt(start)] == 0)
				{
					charcount--;
				}
			}
		}
		System.out.println(str.substring(large_start,large_start+ largest));
	}
	public static void main(String[] args) {
		FindTheLongestSubstringWithKUniqueCharactersInAGivenString obj = new FindTheLongestSubstringWithKUniqueCharactersInAGivenString();
		obj.printSubString("aabacbebebe", 3);
	}
}
